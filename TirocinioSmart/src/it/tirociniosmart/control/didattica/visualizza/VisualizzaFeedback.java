/** Servelt che permete alla didattica di visualizzare i feedback rilasciati
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.direttore/VisualizzaFeedback")
public class VisualizzaFeedback extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws IOException eccezione sul redirect
   * @throws ServletException
   * 
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArrayList<Feedback> feedback = visualizzaFeedback();
    request.getSession().setAttribute("feedback", feedback);
    response.sendRedirect("feedback.jsp");
  }

  /**
   * Gestisce il metodo HTTP POST.
   * 
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo permette la visualizzazione dei feedback lasciati dagli studenti.
   * 
   * 
   */

  public ArrayList<Feedback> visualizzaFeedback() {
    //FactoryProducer factory = FactoryProducer.getIstance();
    //CODICE DI ESEMPIO in mancanza del model
    Feedback f = new Feedback(
        new Tirocinio("prova", "prova", 5,
            new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "")),
        new Studente("prova@prova.it", "asdfgh5", "prova", "prova", "prova", "prova", "prova", "M",
            "r", "", "", "", ""),
        "5/12/1990", "5", "bah");
    Feedback f1 = new Feedback(
        new Tirocinio("prova", "prova", 5,
            new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "")),
        new Studente("prova@prova.it", "asdfgh5", "prova", "prova", "prova", "prova", "prova", "M",
            "r", "", "", "", ""),
        "5/12/1990", "5", "bah");
    ArrayList<Feedback> feedback = new ArrayList<>();
    feedback.add(f);
    feedback.add(f1);
    return feedback;
    //CODICE DA UTILIZZARE CON MODEL
    // ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    // return proxyTirocinio.selectFeedback();
  }
}
