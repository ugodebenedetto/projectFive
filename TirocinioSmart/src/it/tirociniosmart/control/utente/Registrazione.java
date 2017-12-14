
/**
 * Servelt che permete all'utente di registrarsi al sito e quindi al servizio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.Utente;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Registrazione extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Questo metodo permette di controllare che l'utente non sia presente nel DB.
   * 
   * @param email email da controllare
   * @return boolean
   * 
   */

  public boolean controllaEsistenzaUser(String email) {
    return false;
  }



  /**
   * Metodo che registra l'utente nel db.
   * @param utente da registrare nel db
   * @return utente registrato
   */
  public static Utente registra(Utente utente) {
    return utente;
  }

}
