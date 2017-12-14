/**
 * Servelt che permette all'utente TA di inserire un tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.tirocinio.Tirocinio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserisciTirocinio extends HttpServlet {

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
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo permette l'inserimento di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto
   * @return tirocinio
   */
  public Tirocinio inserisciTirocinio(Tirocinio tirocinio) {
    return tirocinio;

  }

}
