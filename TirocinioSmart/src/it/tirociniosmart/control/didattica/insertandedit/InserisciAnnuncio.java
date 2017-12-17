/**
 * Servelt che permete alla didattica di inserire un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class InserisciAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestione richiesta doGet.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. Gestisce la richiesta di creare un annuncio
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    // prendo dati
    // creo annuncio
    inserisciAnnuncio(null);

  }

  /**
   * Questo metodo gestisce la richiesta di inserimento annuncio e quindi di un insert nel DB.
   * 
   */


  public void inserisciAnnuncio(Annuncio annuncio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyAnnuncioDao proxyAnnuncio = (ProxyAnnuncioDao) factory.getAnnuncioDao();
    proxyAnnuncio.insertAnnuncio(annuncio);
  }
}
