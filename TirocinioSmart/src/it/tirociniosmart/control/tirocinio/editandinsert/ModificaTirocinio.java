/**
 * Servlet che permette all'utente TA di modificare un tirocinio
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.TutorAccademico;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.tutorAccademico/ModificaTirocinio")
public class ModificaTirocinio extends HttpServlet {

  private static final long serialVersionUID = 1L;

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
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    String url;
    
    //TutorAccademico ta = 
    //(TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    //ricevo dati tirocinio da TA tramite form
    String nome = request.getParameter("nome");
    String obiettivi = request.getParameter("Obiettivi");
    String descrizione = request.getParameter("Descrizione");
    int numPost = Integer.parseInt(request.getParameter("Numero Posti"));
    if (numPost > 0) {
      //controllare se i campi sono quelli giusti
      
      //creo l'oggetto tirocinio
      Tirocinio newTirocinio = new Tirocinio(nome, descrizione, numPost, ta); 
      //controllare perchè obiettivi sparisce
      
      //prendo il tirocinio di cui modificare i dati
      FactoryProducer factory = FactoryProducer.getIstance();
      ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
      Tirocinio oldTirocinio = proxyTirocinio.findTirocinioForTutorAccademico(ta);
      
      modificaTirocinio(oldTirocinio, newTirocinio);
      
    } 
    response.sendRedirect(url);
    
    
  }

  /**
   * Questo metodo permette la modifica di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto tirocinio che dev'essere sostituito
   * @param nuovoTirocinio tirocinio da sostituire al vecchio
   * @return tirocinio
   */
  
  public Tirocinio modificaTirocinio(Tirocinio tirocinio, Tirocinio nuovoTirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    proxyTirocinio.updateTirocinio(nuovoTirocinio, tirocinio);
    return tirocinio;

  }
}
