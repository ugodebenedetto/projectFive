/**
 * Servelt che permette allo studente di lasciare un feedback
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.tirocinio.Feedback;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InserisciFeedback extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sara gestita la richiesta di inserimento
   * feedback.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo permette l'inserimento di un feedback da parte di uno sudente che ha sosenuto un
   * tirocinio nel DB.
   * 
   * @param feedback feedback da inserire
   * @return Feedback
   */
  public Feedback inserisciFeedback(Feedback feedback) {
    return feedback;

  }
}
