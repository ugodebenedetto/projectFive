/**
 * Servelt che permete alla didattica avviare e concludere un tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValutaTirocino extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {


    // prendo tirocinio dalla session
    // a seconda del bottone premuto chiamo avvia o fine
    avviaTirocinio(tirocinio);


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
   * Metodo che avvia il tirocinio.
   * 
   * @param tirocinio tirocinio da avviare
   */
  public void avviaTirocinio(Tirocinio tirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    // creo un nuovo oggetto tirocinio, uguale all'altro ma con lo statto giusto
    proxyTirocinio.updateTirocinio(newTirocinio, oldTirocinio);
  }



  /**
   * Questo metodo serve permete alla didattica di porre fine ad un tirocinio.
   * 
   */
  public void fineTirocinio(Tirocinio tirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    // creo un nuovo oggetto tirocinio, uguale all'altro ma con lo statto giusto
    proxyTirocinio.updateTirocinio(newTirocinio, oldTirocinio);
  }
}
