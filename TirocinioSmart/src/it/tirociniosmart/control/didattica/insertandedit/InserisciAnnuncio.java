/**
 * Servelt che permete alla didattica di inserire un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
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

  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo gestisce la richiesta di inserimento annuncio e quindi di un insert nel DB.
   * 
   * @pre l'utente autenticato � nel ruolo della didattica
   * @post l'annuncio viene creato
   */

  public void inserisciAnnuncio(Annuncio annuncio) {}
}
