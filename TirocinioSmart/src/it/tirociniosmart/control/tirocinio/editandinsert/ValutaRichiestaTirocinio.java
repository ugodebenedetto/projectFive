/**
 * Servelt che permette al TA di accettare o rifiutare richiesta di tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValutaRichiestaTirocinio extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sar� gestita la richiesta di tirocinio da parte
   * del TA
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * accetta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che deve essere accettata
   * 
   * 
   */
  public void accettaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {}

  /**
   * rifiuta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che dev'essere rifiutata
   * 
   * 
   */
  public void rifiutaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {}


}
