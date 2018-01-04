/**
 * Servlet che permete di visualizzare la lista di tutti i tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
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

@WebServlet("/it.tirociniosmart.view.tutorAccademico/VisualizzaListaTirocini")
public class VisualizzaListaTirocini extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException exception
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    //perchè il parametro?
    //ArrayList<Tirocinio> tirocini = visualizzaListaTirocinio();
    
    // test
    ArrayList<Tirocinio> tirocini = new ArrayList<Tirocinio>();
    TutorAccademico ta = new 
        TutorAccademico("ciao@gmail.com", "as", "asd", "asdf", "as", "",
          "", "", "", "", "", "", "");
    Tirocinio t1 = new Tirocinio("AAAA", "AAAB", "", 10, ta, "", "", "");
    Tirocinio t2 = new Tirocinio("aaaa", "aaab", "", 6, ta, "", "", "");
    
    if (request.getSession().getAttribute("tirocini") == null) {
      tirocini.add(t1);
      tirocini.add(t2);
    } else {
      tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirocini");
    }
    request.getSession().setAttribute("tirocini", tirocini);
    response.sendRedirect("homepage.jsp");
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