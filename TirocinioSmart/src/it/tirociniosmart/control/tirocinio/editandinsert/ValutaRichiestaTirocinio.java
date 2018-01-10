/**
 * Servlet che permette al TA di accettare o rifiutare richiesta di tirocinio
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/it.tirociniosmart.view.tutorAccademico/ValutaRichiestaTirocinio")
public class ValutaRichiestaTirocinio extends HttpServlet {

  private int idTirocinio;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<RichiestaTirocinio> richieste =
        (ArrayList<RichiestaTirocinio>) request.getSession().getAttribute("richieste");
    TutorAccademico ta = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    ArrayList<Integer> posizioni = new ArrayList<>();
    int id = Integer.parseInt(request.getParameter("id"));
    idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
    RichiestaTirocinio richiesta = new RichiestaTirocinio();
    richiesta.setId(id);
    richiesta.setDataRisposta(new Date().toString());
    String r = request.getParameter("return");
    // VALORE DI RITORNO SECONDO CUI CHIAMARE LE FUNZIONI
    ArrayList<Tirocinio> tirociniTutor =
        (ArrayList<Tirocinio>) request.getSession().getAttribute("tirociniTutor");
    if (r.equals("true")) {
      try {
        tirociniTutor = accettaRichiestaTirocinio(richiesta, ta);
        for (Tirocinio t : tirociniTutor) {
          if (t.getNumPost() == 0) {
            for (RichiestaTirocinio rt : richieste) {
              if (rt.getId() != richiesta.getId()) {
                rifiutaRichiestaTirocinio(rt);
              }
            }
          }
        }
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("tirociniTutor", tirociniTutor);
      request.getSession().setAttribute("richieste", richieste);
      response
          .sendRedirect("../it.tirociniosmart.view.tutorAccademico/VisualizzaRichiestaTirocinio");
    }
    if (r.equals("false")) {
      try {
        rifiutaRichiestaTirocinio(richiesta);
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("richieste", richieste);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
  }


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sar� gestita la richiesta di tirocinio da
   * parte del TA
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {

  }

  /**
   * accetta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che deve essere accettata
   * @throws StartupCacheException
   * 
   * 
   */
  public ArrayList<Tirocinio> accettaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio,
      TutorAccademico tutor) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    Tirocinio newTirocinio = tiroc.selectTirocinio().get(idTirocinio);
    if (newTirocinio.getNumPost() != 0) {
      tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaAccettata");
      newTirocinio.setNumPost(newTirocinio.getNumPost() - 1);
      if (newTirocinio.getNumPost() == 0) {
        newTirocinio.setStato("nonDisponibile");
      }
      Tirocinio oldTirocinio = new Tirocinio();
      oldTirocinio.setId(idTirocinio);
      tiroc.updateTirocinio(newTirocinio, oldTirocinio);
    } else {
      tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaRifiutata");
    }

    return tiroc.findTirocinioForTutorAccademico(tutor.getEmail());
  }

  /**
   * rifiuta richiesta tirocinio da perte del TA.
   * 
   * @param richiestaTirocinio richiesta che dev'essere rifiutata
   * @throws StartupCacheException
   * 
   * 
   */
  public void rifiutaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaRifiutata");
  }


}
