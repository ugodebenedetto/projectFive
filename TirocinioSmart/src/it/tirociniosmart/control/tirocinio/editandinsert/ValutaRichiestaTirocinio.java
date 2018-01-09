package it.tirociniosmart.control.tirocinio.editandinsert;
/**
 * Servlet che permette al TA di accettare o rifiutare richiesta di tirocinio
 * 
 * @author Clara Monaco
 */


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
    int id = Integer.parseInt(request.getParameter("id"));
    idTirocinio = Integer.parseInt(request.getParameter("idTirocinio"));
    RichiestaTirocinio richiesta = new RichiestaTirocinio();
    richiesta.setId(id);
    richiesta.setDataRisposta(new Date().toString());
    String r = request.getParameter("return");
    // VALORE DI RITORNO SECONDO CUI CHIAMARE LE FUNZIONI
    if (r.equals("true")) {
      try {
        accettaRichiestaTirocinio(richiesta);
        if (richieste.size() == 1) {
          if (richieste.get(0).getId() == richiesta.getId()) {
            richieste.remove(0);
          }
        } else {
          for (RichiestaTirocinio rt : richieste) {
            if (rt.getId() == richiesta.getId()) {
              richieste.remove(rt);
              break;
            }
          }
        }
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      request.getSession().setAttribute("richieste", richieste);
      response.sendRedirect("richieste_tirocinio_tutor_accademico.jsp");
    }
    if (r.equals("false")) {
      try {
        rifiutaRichiestaTirocinio(richiesta);
        if (richieste.size() == 1) {
          if (richieste.get(0).getId() == richiesta.getId()) {
            richieste.remove(0);
          }
        } else {
          for (RichiestaTirocinio rt : richieste) {
            if (rt.getId() == richiesta.getId()) {
              richieste.remove(rt);
              break;
            }
          }
        }
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
  public void accettaRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateRichiestaTirocinio(richiestaTirocinio, "richiestaAccettata");
    Tirocinio newTirocinio = tiroc.selectTirocinio().get(idTirocinio);
    /* CODICE PER IL TESTING
    if (newTirocinio == null){
      newTirocinio = new Tirocinio("","","",4,1,null,"","",""); */
    newTirocinio.setNumPost(newTirocinio.getNumPost() - 1);
    if (newTirocinio.getNumPost() == 0) {
      newTirocinio.setStato("nonDisponibile");
    }
    Tirocinio oldTirocinio = new Tirocinio();
    oldTirocinio.setId(idTirocinio);
    tiroc.updateTirocinio(newTirocinio, oldTirocinio);
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
