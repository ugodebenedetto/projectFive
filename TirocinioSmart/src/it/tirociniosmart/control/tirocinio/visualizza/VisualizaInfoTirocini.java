/**
 * Servlet che permete di visualizzare le info relative ai tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;

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

@WebServlet("/it.tirociniosmart.view.tutorAccademico/VisualizzaInfoTirocini")
public class VisualizaInfoTirocini extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = null;
    
    int id = Integer.parseInt(request.getParameter("id"));
    Tirocinio tirocinio = visualizzaTirocinio(id);

    if (tirocinio != null) {
      request.getSession().setAttribute("tirocinio", tirocinio);
      ArrayList<Studente> studenti = visualizzaTirocinanti(tirocinio);
      request.setAttribute("studenti", studenti);
      url = "gestione_tirocinio_tutor_accademico.jsp";
    } else {
      url = "jsp erroe";
    }
    response.sendRedirect(url);
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Questo metodo visualizza tutti gli studenti tirocinanti ad un tirocinio.
   * 
   * @param tirocinio tirocinio di cui visualizzare i tirocinanti
   * @return ArrayList Studente
   * 
   */
  public ArrayList<Studente> visualizzaTirocinanti(Tirocinio tirocinio) {

    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<Studente> listaTirocinanti = new ArrayList<Studente>();
    HashMap<Integer, RichiestaTirocinio> listaRichieste = tiroc.selectRichiestaTirocinio();
    Iterator<Entry<Integer, RichiestaTirocinio>> it = listaRichieste.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      RichiestaTirocinio singleRequest = (RichiestaTirocinio) pair.getValue();
      if ((singleRequest.getStato() == "richiestaAccettata")
          && (singleRequest.getTirocinio().getTutor() == tirocinio.getTutor())) {
        listaTirocinanti.add(singleRequest.getRichiedente());
      }
    }
    return listaTirocinanti;
  }

  /**
   * Questo metodo visualizza tirocinio.
   * 
   * @param id del tirocinio da visualizzare
   * @return Tirocinio
   * 
   */
  public Tirocinio visualizzaTirocinio(int id) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();

    HashMap<Integer, Tirocinio> tirocini = tiroc.selectTirocinio();

    if (tirocini.get(id) != null) {
      return tirocini.get(id);
    } else {
      return null;
    }
  }
}
