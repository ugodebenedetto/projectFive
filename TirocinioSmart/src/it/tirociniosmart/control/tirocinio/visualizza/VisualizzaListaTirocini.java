/**
 * Servlet che permete di visualizzare la lista di tutti i tirocini
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.tirocinio.Tirocinio;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizzaListaTirocini extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    //perchè il parametro?
    ArrayList<Tirocinio> tirocini = visualizzaListaTirocinio(tirocinio);
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo visualizza tutti i tirocini.
   * 
   * @return ArrayList tirocinio
   * 
   */
  public ArrayList<Tirocinio> visualizzaListaTirocinio(Tirocinio tirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    return proxyTirocinio.selectTirocinio();

  }
}