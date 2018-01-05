/**
 * Servelt che permete alla didattica di visualizzare i feedback rilasciati
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
    StartupCache cache = new StartupCache();
    HashMap<Integer, Feedback> feedback = visualizzaFeedback();
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

  public HashMap<Integer, Feedback> visualizzaFeedback() {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tirocinio = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    return tirocinio.selectFeedback();
  }
}
