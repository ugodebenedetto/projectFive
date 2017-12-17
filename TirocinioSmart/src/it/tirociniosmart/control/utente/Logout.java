/**
 * Servelt che permete all'utente di abbandonare la propria sessione
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {

  private static final long serialVersionUID = 1L;

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
   * @throws IOException .
   * @throws ServletException
   * 
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    if (request.getSession().getAttribute("currentSessionUser") != null) {
      logout(request.getSession());
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("Dobbiamo vedere dove fare redirect");
    dispatcher.forward(request, response);
  }

  /**
   * Questo metodo gestisce la richiesta dell'utente di abbandonare la sessione.
   * 
   * 
   * @param sessione sessione http da cui bisognerà eliminare l'oggetto utente
   */
  public void logout(HttpSession sessione) {
    sessione.setAttribute("currentSessionUser", null);
  }
}
