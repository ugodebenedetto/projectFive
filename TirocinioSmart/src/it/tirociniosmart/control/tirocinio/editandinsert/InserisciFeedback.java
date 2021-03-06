/**
 * Servlet che permette allo studente di lasciare un feedback
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/it.tirociniosmart.view.studente/InserisciFeedback")
public class InserisciFeedback extends HttpServlet {

  private static final long serialVersionUID = 1L;

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
   * @throws IOException eccezione IO
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    boolean check = true;
    response.setContentType("text/html;charset=UTF-8");

    // ricevo il feedback
    String dataInvio = request.getParameter("dataInvio");
    int valutazione = Integer.parseInt(request.getParameter("valutazione"));
    String commento = request.getParameter("messages");
    // tutti i parametri da ricevere da tirocinio_studente.jsp
    Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");

    // tirocinio ricevuto dalla session
    Tirocinio tirocinio = (Tirocinio) request.getSession().getAttribute("tirocinioStudente");

    // creo l'oggetto
    Feedback feedback = new Feedback(tirocinio, studente, dataInvio, valutazione, commento);
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    HashMap<Integer, Feedback> feedbackList = tiroc.selectFeedback();
    Iterator<Entry<Integer, Feedback>> it = feedbackList.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      Feedback singleFeedback = (Feedback) pair.getValue();
      if (singleFeedback.getStudente().getEmail().equals(studente.getEmail())) {
        check = false;
      }
    }
    if (check) {
      try {
        inserisciFeedback(feedback);
        response.sendRedirect("tirocinio_studente.jsp");
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else {
      response.sendRedirect("feedbackGiaInviato.jsp");
    }
  }



  /**
   * Questo metodo permette l'inserimento di un feedback da parte di uno sudente che ha sosenuto un
   * tirocinio nel DB.
   * 
   * @param feedback feedback da inserire
   * @return Feedback
   * @throws StartupCacheException .
   */
  public Feedback inserisciFeedback(Feedback feedback) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.insertFeedback(feedback);
    return feedback;
  }
}
