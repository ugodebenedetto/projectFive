/**
 * Servlet che permette allo studente di lasciare un feedback
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.group.interceptors.TwoPhaseCommitInterceptor.MapEntry;


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
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {

    boolean check = true;
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    //ricevo il feedback
    int id = Integer.parseInt(request.getParameter("id"));
    String dataInvio = request.getParameter("dataInvio");
    String valutazione = request.getParameter("valutazione");
    String commento = request.getParameter("messages");
    // tutti i parametri da ricevere da tirocinio_studente.jsp
    //Studente studente= 
    //(Studente) request.getSession().getAttribute("currentSessionUser");
    Studente studente = new Studente("","","","","","","","","","","","","");
    
    //tirocinio ricevuto dalla session
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinio = new Tirocinio("", "", "", 1, 1010, ta, "", "", "");
    
    //creo l'oggetto
    Feedback feedback = new Feedback(tirocinio, studente, dataInvio, 0, valutazione, commento);
    //forse setcache va messo qui
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    HashMap<Integer, Feedback> feedbackList = tiroc.selectFeedback();
    Iterator it = feedbackList.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      Feedback singleFeedback = (Feedback) pair.getValue();
      if (singleFeedback.getStudente().equals(studente) 
          && (singleFeedback.getTirocinio().equals(tirocinio))) {
        check = false;
      }
    }
    if (check) {
      //inserisco il feedback
      //controlli gi� effettuati nella pagina jsp
      inserisciFeedback(feedback);
      out.println("<script type=\"text/javascript\">");
      out.println("alert('Feedback inviato con successo');");
      out.println("location='tirocinio_studente.jsp';");
      out.println("</script>");
    } else {
      out.println("<script type=\"text/javascript\">");
      out.println("alert('Feedback non inviato');");
      out.println("location='tirocinio_studente.jsp';");
      out.println("</script>");
    }
  }
 
  
  
  /**
   * Questo metodo permette l'inserimento di un feedback da parte di uno sudente che ha sosenuto un
   * tirocinio nel DB.
   * 
   * @param feedback feedback da inserire
   * @return Feedback
   * @throws StartupCacheException 
   */
  public Feedback inserisciFeedback(Feedback feedback) throws StartupCacheException {
    //Codice da utilizzare in seguito ! Inizializzare cache
    StartupCache cache = new StartupCache();
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.insertFeedback(feedback);
    //cache.setCacheFeedback();
    return feedback;
  }
}