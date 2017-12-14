/**
 * Servelt che permete di visualizzare la lista di tutte le richieste di tirocini
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.utente.Studente;
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


  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


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
    return null;
  }
}
