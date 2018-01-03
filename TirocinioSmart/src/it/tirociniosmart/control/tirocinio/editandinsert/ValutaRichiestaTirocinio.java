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
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
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
import javax.servlet.http.HttpSession;

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
    //ArrayList<RichiestaTirocinio> richieste = (ArrayList<RichiestaTirocinio>) request.getSession().getAttribute("richieste");
    //SERVLET DA FINIRE CHIEDERE A SEBASTIANO DEL FORM DELLA PAGINA HTML
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
    /*while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      s = (Studente) pair.getValue();
      if (s.getEmail().equals(email)) {
        break;
      }
      //it.remove();
    } CODICE DA IMPLEMENTARE IN SEGUITO */ 
    Studente studente = s;
    //COSTRUZIONE STUDENTE
    String titolo = request.getParameter("titolo");
    String descrizione = request.getParameter("descrizione");
    int numPost = Integer.parseInt(request.getParameter("numpost"));
    Tirocinio tirocinio = new Tirocinio(titolo, descrizione, numPost, ta);
    //COSTRUZIONE TIROCINIO
    
    RichiestaTirocinio richiesta = new 
        RichiestaTirocinio(stato, dataRichiesta, dataRisposta, studente, tirocinio);
    String r = request.getParameter("return");
    //VALORE DI RITORNO SECONDO CUI CHIAMARE LE FUNZIONI
    
    if (r.equals("true")) {
      accettaRichiestaTirocinio(richiesta);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
    if (r.equals("true")) {
      rifiutaRichiestaTirocinio(richiesta);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
    System.out.println(r);
    /*Studente studente = (Studente) session.getAttribute("Studente");
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    ArrayList<RichiestaTirocinio> richieste = proxyTirocinio.selectRichiestaTirocinio();
    proxyTirocinio.findRichiestaTirocinioForUser(studente);
    // a seconda della scelta chiamo il metodo giusto
    // rivedere qui!!!
     * */
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
   * 
   * 
   */
  public void accettaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
    
    // clono l'oggetto richiesta tirocinio con lo stato "richiestaAccettata"
    RichiestaTirocinio newRichiesta = richiestaTirocinio;
    newRichiesta.setStato("richiestaAccettata");
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    proxyTirocinio.updateRichiestaTirocinio(newRichiesta, richiestaTirocinio);
  }

  /**
   * rifiuta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che dev'essere rifiutata
   * 
   * 
   */
  public void rifiutaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
    // clono l'oggetto richiesta tirocinio con lo stato "richiestaRifiutata"
    RichiestaTirocinio newRichiesta = richiestaTirocinio;
    newRichiesta.setStato("richiestaRifiutata");
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    proxyTirocinio.updateRichiestaTirocinio(newRichiesta, richiestaTirocinio);
  }
    

}
