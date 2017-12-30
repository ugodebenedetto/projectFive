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

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisualizzaListaStudenti")
public class VisualizzaListaStudenti extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws IOException
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // ArrayList<Studente> studenti = visualizzaListaStudenti();
    //CODICE DI PROVA
    ArrayList<Studente> studenti = new ArrayList<Studente>();
    Studente s = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "",
        "", "", "0512103456", "triennale");
    Studente s1 = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "",
        "", "", "0512103456", "triennale");
    studenti.add(s);
    studenti.add(s1);
    
    request.getSession().setAttribute("studenti", studenti);
    response.sendRedirect("it.tirociniosmart.view.didattica/lista_studenti.jsp");
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
