/**
 * Servelt che permete alla didattica di visualizzare i feedback rilasciati
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.tirocinio.Feedback;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisualizzaFeedback extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request
   * 
   * @param response
   * 
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Gestisce il metodo HTTP POST.
   * 
   * 
   * @param request
   * 
   * @param response
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo permette la visualizzazione dei feedback lasciati dagli studenti.
   * 
   * 
   */

  public ArrayList<Feedback> visualizzaFeedback() {
    return null;
  }
}
