/**
 * Servelt che permete all'utente di abbandonare la propria sessione
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {


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
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo gestisce la richiesta dell'utente di abbandonare la sessione.
   * 
   * 
   * @param sessione sessione http da cui bisognerà eliminare l'oggetto utente
   */
  public void logout(HttpSession sessione) {

  }
}
