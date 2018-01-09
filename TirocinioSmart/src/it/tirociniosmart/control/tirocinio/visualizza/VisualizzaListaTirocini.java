package it.tirociniosmart.control.tirocinio.visualizza;
/**
 * Servlet che permete di visualizzare la lista di tutti i tirocini
 * 
 * @author Clara Monaco
 */


import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/it.tirociniosmart.view.tutorAccademico/VisualizzaListaTirocini")
public class VisualizzaListaTirocini extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException exception
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HttpSession session = request.getSession();
    ArrayList<Tirocinio> tirocini = visualizzaListaTirocinio();
    //commenti per il testing
    //tirocini.add(new Tirocinio("","","",5,1,null,"","",""));
    request.getSession().setAttribute("tirocini", tirocini);
    if (session.getAttribute("currentSessionUser") instanceof TutorAccademico) {
      response.sendRedirect("i_miei_tirocini.jsp");
    } else if (session.getAttribute("currentSessionUser") instanceof Studente) {
      response.sendRedirect("offerta_formativa_studente.jsp");
    } else {
      response.sendRedirect("offerta_formativa.jsp");
    }
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Questo metodo visualizza tutti i tirocini.
   * 
   * @return ArrayList tirocinio
   * 
   */
  public ArrayList<Tirocinio> visualizzaListaTirocinio() {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
    HashMap<Integer, Tirocinio> tirocini = tiroc.selectTirocinio();
    Iterator<Entry<Integer, Tirocinio>> it = tirocini.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      Tirocinio singleTirocinio = (Tirocinio) pair.getValue();
      listaTirocini.add(singleTirocinio);
    }
    return listaTirocini;

  }
}