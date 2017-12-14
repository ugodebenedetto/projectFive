/**
 * Servelt che permete all'utente di autenticarsi per accedere al servizio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.Utente;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {


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
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo gestisce la richiesta dell'utente di loggarsi per accedere al servizio.
   * 
   * 
   * @param username username dell'utente che deve loggarsi
   * @param password password dell'utente che deve loggarsi
   * 
   * 
   */
  public static Utente login(String username, String password) {
    return null;

  }
}
