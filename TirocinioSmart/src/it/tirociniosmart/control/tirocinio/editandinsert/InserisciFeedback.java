/**
 * Servlet che permette allo studente di lasciare un feedback
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
    //ricevo il feedback
    
    //inserisco il feedback
    inserisciFeedback(feedback);
  }
 
  
  
  /**
   * Questo metodo permette l'inserimento di un feedback da parte di uno sudente che ha sosenuto un
   * tirocinio nel DB.
   * 
   * @param feedback feedback da inserire
   * @return Feedback
   */
  public Feedback inserisciFeedback(Feedback feedback) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    proxyTirocinio.insertFeedback(feedback);
    return feedback;
  }
}