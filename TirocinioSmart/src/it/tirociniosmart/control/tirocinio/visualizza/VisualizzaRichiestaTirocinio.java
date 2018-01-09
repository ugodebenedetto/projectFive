/**
 * Servlet che permete di visualizzare la lista di tutte le richieste di tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
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

@WebServlet("/it.tirociniosmart.view.tutorAccademico/VisualizzaRichiestaTirocinio")
public class VisualizzaRichiestaTirocinio extends HttpServlet {
 
  private static final long serialVersionUID = 1L;


  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    if (request.getSession().getAttribute("currentSessionUser") instanceof TutorAccademico) {
      TutorAccademico ta =
          (TutorAccademico) request.getSession().getAttribute("currentSessionUser");

      try {
        ArrayList<RichiestaTirocinio> richieste = visualizzaRichiestaTirocinioTutor(ta);
        request.getSession().setAttribute("richieste", richieste);

      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Visualizza lo stato della richiesta tirocinio svolta da uno studente.
   * 
   * @param studente studente di cui visualizzare lo stato della richiesta
   * @return RichiestaTirocinio
   * @throws StartupCacheException eccezione cache
   */
  public ArrayList<RichiestaTirocinio> visualizzaRichiestaTirocinioStudente(Studente studente)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    return tiroc.findRichiestaTirocinioForUser(studente.getEmail());
  }


  /**
   * Visualizza lo stato della richiesta tirocinio svolta da uno studente.
   * 
   * @param ta tutor accademico di cui visualizzare le richieste
   * @return RichiestaTirocinio
   * @throws StartupCacheException eccezione cache
   */
  public ArrayList<RichiestaTirocinio> visualizzaRichiestaTirocinioTutor(TutorAccademico ta)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<RichiestaTirocinio> richieste = new ArrayList<RichiestaTirocinio>();
    HashMap<Integer, RichiestaTirocinio> hash = new HashMap<>();
    hash = tiroc.selectRichiestaTirocinio();
    if (hash != null) {
      for (Integer key : hash.keySet()) {
        if (hash.get(key).getTirocinio().getTutor().getEmail().equals(ta.getEmail())
            && hash.get(key).getStato().equals("inFaseDiApprovazione")) {
          richieste.add(hash.get(key));
        }
      }
    }
    return richieste;
  }
}
