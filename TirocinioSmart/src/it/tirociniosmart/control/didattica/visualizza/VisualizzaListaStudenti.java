/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli studenti
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
    HashMap<Integer, RichiestaTirocinio> studenti = visualizzaListaStudenti();
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
  public HashMap<Integer, RichiestaTirocinio> visualizzaListaStudenti() {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tirocinio = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    return tirocinio.selectRichiestaTirocinio();

  }
}
