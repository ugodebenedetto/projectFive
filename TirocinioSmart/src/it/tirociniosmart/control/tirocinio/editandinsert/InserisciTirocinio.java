/**
* Servlet che permette all'utente TA di inserire un tirocinio
* 
* @author Clara Monaco
*/

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;


public class InserisciTirocinio extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta
   * @param response risposta
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta
   * @param response risposta
   * @throws IOException exception
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
    String url = "aggiungi_tirocinio_success.jsp";
    boolean check;
    
    //i controlli sono già nella form, controllare solo numero posti
    String nome = request.getParameter("nome");
    String obiettivi = request.getParameter("Obiettivi");
    String descrizione = request.getParameter("Descrizione");
    int numPost = Integer.parseInt(request.getParameter("Numero Posti"));
    if (numPost > 0) {
      //controllare se i campi sono quelli giusti
      //TutorAccademico ta = 
      //(TutorAccademico) request.getSession().getAttribute("currentSessionUser");
      TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
      //ricevo dati tirocinio da TA tramite form
      
      //creo e aggiungo tirocinio
      Tirocinio tirocinio = new Tirocinio(nome, descrizione, numPost, ta); 
      //controllare perchè obiettivi sparisce
    //inserisciTirocinio(tirocinio);
    } else {
      url = "aggiungi_tirocinio_failure.jsp";
    }
    
    response.sendRedirect(url);
  }

  /**
   * Questo metodo permette l'inserimento di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto
   * @return tirocinio
   */
  public Tirocinio inserisciTirocinio(Tirocinio tirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    proxyTirocinio.insertTirocinio(tirocinio);
    return tirocinio;
  }

}