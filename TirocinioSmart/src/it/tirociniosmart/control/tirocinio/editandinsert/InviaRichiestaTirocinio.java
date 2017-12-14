/**
 * Servelt che permette allo studente di inviare la richiesta di tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InviaRichiestaTirocinio extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sara gestita la richiesta di tirocinio da parte
   * dello studente.
   * 
   *
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce l'invio della richiesta tirocinio.
   * 
   * @param richiestaTirocinio richiesta relativa ad un tirocinio
   * @return boolean
   * 
   */

  public boolean inviaRichiesta(RichiestaTirocinio richiestaTirocinio) {
    return false;
  }

  /**
   * Controlla la disponibilità del tirocinio.
   * 
   * @param tirocinio tirocinio di cui controllare la disponibilità
   * @return boolean
   * 
   */

  public boolean controllaDisponibilita(Tirocinio tirocinio) {
    return false;
  }

  /**
   * Controlla invio precedente.
   * 
   * @param tirocinio tirocinio da controllare
   * @return boolean
   * 
   */
  public boolean controllaInvioPrecedente(RichiestaTirocinio tirocinio) {
    return false;
  }


}
