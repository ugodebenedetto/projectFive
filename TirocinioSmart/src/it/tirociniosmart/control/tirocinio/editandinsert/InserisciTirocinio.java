/**
* Servlet che permette all'utente TA di inserire un tirocinio
* 
* @author Clara Monaco
*/

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    //ricevo dati tirocinio da TA
    //creo e aggiungo tirocinio
    inserisciTirocinio(tirocinio);
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