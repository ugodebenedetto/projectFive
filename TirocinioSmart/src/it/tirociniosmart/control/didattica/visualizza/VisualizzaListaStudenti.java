/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli studenti
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.utente.ProxyUtenteDao;
import it.tirociniosmart.model.utente.Studente;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizzaListaStudenti extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    ArrayList<Studente> studenti = visualizzaListaStudenti();
    //in session e redirect
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
   * Questo metodo visualizza tutti gli studenti.
   * 
   * @return ArrayList Studente
   * 
   */
  public ArrayList<Studente> visualizzaListaStudenti() {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxyUtente = (ProxytenteDao) factory.getUtenteDao();
    return proxyUtente.selectStudente();

  }
}
