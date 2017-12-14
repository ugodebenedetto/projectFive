/**
 * Servelt che permete alla didattica di visualizzare un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
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

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}

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
    return null;

  }
}
