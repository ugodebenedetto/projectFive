/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli studenti
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.ProxyUtenteDao;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.didattica/VisualizzaListaStudenti")
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
    // ArrayList<RichiestaTirocinio> studenti = visualizzaListaStudenti();
    // CODICE DI PROVA
    ArrayList<RichiestaTirocinio> studenti = new ArrayList<RichiestaTirocinio>();
    Studente s = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "",
        "", "", "0512103456", "triennale");
    Studente s1 = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "",
        "", "", "0512103457", "triennale");
    RichiestaTirocinio r = new RichiestaTirocinio("richiestaAccettata", "", "", s1,
        new Tirocinio("nome", "provola", 4,
            new TutorAccademico("email", "codiceFiscale", "nome", "cognome", "luogoNascita",
                "dataNascita", "password", "sesso", "residenza", "via", "telefono", "dipartimento",
                "codiceDocente")));
    RichiestaTirocinio r1 = new RichiestaTirocinio("inFaseDiApprovazione", "", "", s,
        new Tirocinio("nome", "provola", 4,
            new TutorAccademico("email", "codiceFiscale", "nome", "cognome", "luogoNascita",
                "dataNascita", "password", "sesso", "residenza", "via", "telefono", "dipartimento",
                "codiceDocente")));
    studenti.add(r);
    studenti.add(r1);

    request.getSession().setAttribute("studenti", studenti);
    response.sendRedirect("lista_studenti.jsp");
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
  public ArrayList<RichiestaTirocinio> visualizzaListaStudenti() {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    return proxyTirocinio.selectRichiestaTirocinio();

  }
}
