/**
 * Servlet che permette all'utente TA di modificare un tirocinio
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.tutorAccademico/ModificaTirocinio")
public class ModificaTirocinio extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = "i_miei_tirocini.jsp";
    //prendo il tirocinio dalla session
    Tirocinio oldTirocinio = (Tirocinio) request.getSession().getAttribute("tirocinio");
    //TutorAccademico ta = 
    //(TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    //ricevo dati tirocinio da TA tramite form
    String nome = request.getParameter("nome");
    String obiettivi = request.getParameter("Obiettivi");
    String descrizione = request.getParameter("Descrizione");
    int numPost = Integer.parseInt(request.getParameter("Numero Posti"));
    String sede = request.getParameter("sede");
    String tipo = request.getParameter("tipo");
    String responsabile = request.getParameter("responsabile");
    if (numPost > 0) {
      //controllare se i campi sono quelli giusti
      
      //creo l'oggetto tirocinio
      Tirocinio newTirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
        ta, sede, tipo, responsabile); 
      //controllare perchè obiettivi sparisce
      
      //prendo il tirocinio di cui modificare i dati
      
      try {
        modificaTirocinio(oldTirocinio, newTirocinio);
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    } 
    response.sendRedirect(url);
    
    
  }

  /**
   * Questo metodo permette la modifica di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto tirocinio che dev'essere sostituito
   * @param nuovoTirocinio tirocinio da sostituire al vecchio
   * @return tirocinio
   * @throws StartupCacheException 
   */
  
  public Tirocinio modificaTirocinio(Tirocinio tirocinio, Tirocinio nuovoTirocinio) 
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateTirocinio(nuovoTirocinio, tirocinio);
    return tirocinio;

  }
}
