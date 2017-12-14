/**
 * Servelt che permete all'utente di modificare il suo profilo
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.Utente;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ModificaInformazioniAccount extends HttpServlet {

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
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  public Utente modificaProfilo(Utente utente) {
    return utente;

  }
}
