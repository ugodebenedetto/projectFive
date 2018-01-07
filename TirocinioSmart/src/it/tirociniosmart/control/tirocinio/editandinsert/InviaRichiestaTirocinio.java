/**
 * Servlet che permette allo studente di inviare la richiesta di tirocinio
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
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.studente/InviaRichiestaTirocinio")
public class InviaRichiestaTirocinio extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    HashMap<Integer, Tirocinio> tirocini =
        (HashMap<Integer, Tirocinio>) request.getSession().getAttribute("tirocini");
    Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");
    int id = Integer.parseInt(request.getParameter("id"));
    String stato = request.getParameter("stato");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String localDate = (LocalDate.now().format(dtf)).toString();
    String dataInvio = localDate;
    // Gestione della data
    String dataAccettazione = null;


    // trova il tirocinio tramite l'int incrementale, abbiamo la lista di tirocini nella session
    Tirocinio tirocinio = tirocini.get(id);
    // che manda il tutor accademico qui
    // TutorAccademico ta = tirocinio.getTutor();
    RichiestaTirocinio richiesta =
        new RichiestaTirocinio(stato, dataInvio, dataAccettazione, studente, tirocinio);
    try {
      if (inviaRichiesta(richiesta, studente)) {
        // lancia un alert nel caso di successo nell'invio della richiesta
        // Modifichiamo il numero di posti del tirocinio
        ArrayList<RichiestaTirocinio> richieste =
            (ArrayList<RichiestaTirocinio>) request.getSession().getAttribute("richieste");
        richieste.add(richiesta);
        request.getSession().setAttribute("richieste", richieste);
        tirocinio.setNumPost(tirocinio.getNumPost() - 1);
        response.sendRedirect("richiestaInviata.jsp");
      } else {
        response.sendRedirect("richiestaGiaInviata.jsp");
      }
    } catch (StartupCacheException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sara gestita la richiesta di tirocinio da parte
   * dello studente.
   * 
   *
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException eccezione di I/O
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {}


  /**
   * Gestisce l'invio della richiesta tirocinio.
   * 
   * @param richiestaTirocinio richiesta relativa ad un tirocinio
   * @return boolean
   * @throws StartupCacheException
   * 
   */

  public boolean inviaRichiesta(RichiestaTirocinio richiestaTirocinio, Studente studente)
      throws StartupCacheException {
    boolean check = true;
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();

    // inserimento richiesta
    if ((controllaDisponibilita(richiestaTirocinio.getTirocinio()))
        && (controllaInvioPrecedente(richiestaTirocinio, studente))) {
      richiestaTirocinio.setStato("inFaseDiApprovazione");
      tiroc.insertRichiestaTirocinio(richiestaTirocinio);
      check = true;
    } else {
      check = false;
    }
    return check;
  }

  /**
   * Controlla la disponibilità del tirocinio.
   * 
   * @param tirocinio tirocinio di cui controllare la disponibilità
   * @return boolean
   * 
   */

  public boolean controllaDisponibilita(Tirocinio tirocinio) {
    if (tirocinio.getNumPost() > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Controlla invio precedente.
   * 
   * @param tirocinio tirocinio da controllare
   * @return boolean
   * @throws StartupCacheException
   * 
   */
  public boolean controllaInvioPrecedente(RichiestaTirocinio tirocinio, Studente studente)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<RichiestaTirocinio> richieste =
        tiroc.findRichiestaTirocinioForUser(studente.getEmail());
    for (RichiestaTirocinio rt : richieste) {
      if (rt.getStato().equals("richiestaAccettata")) {
        return false;
      }
    }
    return true;
  }


}
