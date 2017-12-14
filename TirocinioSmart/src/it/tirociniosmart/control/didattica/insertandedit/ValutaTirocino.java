/**
 * Servelt che permete alla didattica avviare e concludere un tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

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


  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


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
   * @param tirocinio tirocinio da avviare
   */
  public void avviaTirocinio(Tirocinio tirocinio) {}



  /**
   * Questo metodo serve permete alla didattica di porre fine ad un tirocinio.
   * 
   */
  public void fineTirocinio(Tirocinio tirocinio) {}
}
