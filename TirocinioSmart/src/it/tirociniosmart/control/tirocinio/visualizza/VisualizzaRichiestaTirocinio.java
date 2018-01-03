/**
 * Servlet che permete di visualizzare la lista di tutte le richieste di tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

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


  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    
    //Studente studente= 
    //(Studente) request.getSession().getAttribute("currentSessionUser");
    //Studente studente = new Studente("","","","","","","","","","","","","");
    //RichiestaTirocinio richiesta = visualizzaStatoRichiestaTirocinio(studente);
    Studente studente = new
        Studente("lucanastri@hotmail.it", "Luca", "Nastri", "",
          "", "", "", "", "", "", "", "", "");
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinio = new Tirocinio("", "", 1, ta);
    RichiestaTirocinio richiesta = new RichiestaTirocinio("InFaseDiApprovazione", "", "", studente, tirocinio);
    
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
   */
  public RichiestaTirocinio visualizzaStatoRichiestaTirocinio(Studente studente) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    return proxyTirocinio.findRichiestaTirocinioForUser(studente);
  }
}