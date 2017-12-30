/**
 * Servlet che permette all'utente TA di modificare un tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    //prendo il tirocinio di cui modificare i dati
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    //il tutor accademico dalla session
    Tirocinio tirocinio = proxyTirocinio.findTirocinioForTutorAccademico(tutorAccademico);
    // ricevo i nuovi parametri del tirocinio modificato
    // creo un nuovo tirocinio
    modificaTirocinio(oldTirocinio, newTirocinio);
    
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
