/**
 * Servelt che permete alla didattica di modificare un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificaAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;


  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Gestisce il metodo HTTP POST. Gestisce la richiesta dell'utente di modificaAnnuncio
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Questo metodo gestisce la richiesta di modificare un annuncioe di modificare DB.
   * 
   */

  public void modificaAnnuncio(Annuncio annuncioOld, Annuncio annuncioNew) {}
}
