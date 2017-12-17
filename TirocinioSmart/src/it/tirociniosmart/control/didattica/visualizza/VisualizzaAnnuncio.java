/**
 * Servelt che permete alla didattica di visualizzare un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VisualizzaAnnuncio extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    Annuncio annuncio = visualizzaAnnuncio();
    // lo metto nella request e faccio il redirect
  }

  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * questo metodo permette la visualizzazione di un annuncio.
   * 
   * @return annuncio
   * 
   */
  public static Annuncio visualizzaAnnuncio() {
    // creo l'annuncio prendendo i campi dall'url
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyAnnuncioDao proxyAnnuncio = (ProxyAnnuncioDao) factory.getAnnuncioDao();
    return proxyAnnuncio.findAnnuncio(annuncio);

  }
}
