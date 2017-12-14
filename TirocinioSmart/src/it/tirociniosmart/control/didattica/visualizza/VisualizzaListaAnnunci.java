package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli annunci.
 * 
 * @author Clara Monaco
 */






public class VisualizzaListaAnnunci extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request
   * 
   * @param response
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. con questo metodo possiamo gestire la richiesta di controllo
   * lista annunci permettendo poi l'iterazione con essi.
   * 
   * 
   * @param request
   * 
   * @param response
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Questo metodo visualizza tutti gli annunci.
   * 
   * @return ArrayList Annuncio
   */
  public ArrayList<Annuncio> visualizzaListaAnnuncio() {
    return null;

  }
}
