/** 
* Servlet che permette al TA di accettare o rifiutare richiesta di tirocinio
* 
* @author Clara Monaco
*/

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.control.tirocinio.visualizza.VisualizzaRichiestaTirocinio;
import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.utente.Studente;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValutaRichiestaTirocinio extends HttpServlet {
  
  
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    
    //SERVLET DA FINIRE CHIEDERE A SEBASTIANO DEL FORM DELLA PAGINA HTML
    HttpSession session = request.getSession();
    Studente studente = (Studente) session.getAttribute("Studente");
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    ArrayList<RichiestaTirocinio> richieste = proxyTirocinio.selectRichiestaTirocinio();
    proxyTirocinio.findRichiestaTirocinioForUser(studente);
    // a seconda della scelta chiamo il metodo giusto
    // rivedere qui!!!
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
    proxyTirocinio.updateRichiestaTirocinio(newRichiesta, oldRichiesta);
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
    proxyTirocinio.updateRichiestaTirocinio(newRichiesta, oldRichiesta);
  }
    

}
