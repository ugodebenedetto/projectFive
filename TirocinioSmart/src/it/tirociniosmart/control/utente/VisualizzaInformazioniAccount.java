/**
 * Servelt che permete all'utente di visualizzare il suo profilo
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.Utente;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizzaInformazioniAccount extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
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
   * Visualizza profilo.
   * 
   * @param utente utente di cui si vuole visualizzare il profilo
   * @return utente di cui si vuole visualizzare il profilo
   */
  public Utente visualizzaProfilo(Utente utente) {
    return utente;

  }
}
