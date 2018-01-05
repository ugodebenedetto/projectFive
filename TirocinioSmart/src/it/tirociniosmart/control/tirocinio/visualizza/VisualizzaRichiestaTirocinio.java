/**
 * Servlet che permete di visualizzare la lista di tutte le richieste di tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizzaRichiestaTirocinio extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */


  public void doGet(HttpServletRequest request, 
                    HttpServletResponse response) {
    
    Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");
    try {
      ArrayList<RichiestaTirocinio> richieste = visualizzaStatoRichiestaTirocinio(studente);
      request.getSession().setAttribute("richieste", richieste);
    } catch (StartupCacheException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  

  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Visualizza lo stato della richiesta tirocinio svolta da uno studente.
   * 
   * @param studente studente di cui visualizzare lo stato della richiesta
   * @return RichiestaTirocinio
   * @throws StartupCacheException eccezione cache
   */
  public ArrayList<RichiestaTirocinio> visualizzaStatoRichiestaTirocinio(Studente studente) 
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    return tiroc.findRichiestaTirocinioForUser(studente.getEmail());
  }
}