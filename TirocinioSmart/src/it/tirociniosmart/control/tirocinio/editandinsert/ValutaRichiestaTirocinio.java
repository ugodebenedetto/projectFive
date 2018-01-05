/** 
* Servlet che permette al TA di accettare o rifiutare richiesta di tirocinio
* 
* @author Clara Monaco
*/

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.control.tirocinio.visualizza.VisualizzaRichiestaTirocinio;
import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.tutorAccademico/ValutaRichiestaTirocinio")
public class ValutaRichiestaTirocinio extends HttpServlet {
  
  
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException 
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<RichiestaTirocinio> richieste = (ArrayList<RichiestaTirocinio>) request.getSession()
        .getAttribute("richieste");
    TutorAccademico ta = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    String stato = request.getParameter("stato");
    String dataRichiesta = request.getParameter("dataric");
    String dataRisposta = request.getParameter("datarisp");
    String email = request.getParameter("email");
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    HashMap<String, Studente> studenti = utente.selectStudente();
    Iterator it = studenti.entrySet().iterator();
    Studente s = null;
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      s = (Studente) pair.getValue();
      if (s.getEmail().equals(email)) {
        break;
      }
      //it.remove();
    }
    Studente studente = s;
    //COSTRUZIONE STUDENTE
    String nome = request.getParameter("titolo");
    String obiettivi = request.getParameter("obiettivi");
    String descrizione = request.getParameter("descrizione");
    int numPost = Integer.parseInt(request.getParameter("numpost"));
    String sede = request.getParameter("sede");
    String tipo = request.getParameter("tipo");
    String responsabile = request.getParameter("responsabile");
    Tirocinio tirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
                                         ta, sede, tipo, responsabile);
    //COSTRUZIONE TIROCINIO
    
    RichiestaTirocinio richiesta = new 
        RichiestaTirocinio(stato,dataRichiesta, dataRisposta, studente, tirocinio);
    String r = request.getParameter("return");
    //VALORE DI RITORNO SECONDO CUI CHIAMARE LE FUNZIONI
    
    if (r.equals("true")) {
      try {
        accettaRichiestaTirocinio(richiesta);
        richieste.remove(richiesta);
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("richieste", richieste);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
    if (r.equals("true")) {
      try {
        rifiutaRichiestaTirocinio(richiesta);
        richieste.remove(richiesta);
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("richieste", richieste);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
       } 


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sar� gestita la richiesta di tirocinio da parte
   * del TA
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    
  }

  /**
   * accetta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che deve essere accettata
   * @throws StartupCacheException 
   * 
   * 
   */
  public void accettaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaAccettata");
  }

  /**
   * rifiuta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che dev'essere rifiutata
   * @throws StartupCacheException 
   * 
   * 
   */
  public void rifiutaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaRifiutata");
  }
    

}
