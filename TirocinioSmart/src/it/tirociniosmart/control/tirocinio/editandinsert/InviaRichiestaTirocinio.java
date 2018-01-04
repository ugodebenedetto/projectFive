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
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. In questo metodo sara gestita la richiesta di tirocinio da parte
   * dello studente.
   * 
   *
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException eccezione di I/O
   */
  
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    ArrayList<Tirocinio> tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirocini");
    //if (request.getSession().getAttribute("currentSessionUser") != null) {
      String stato = request.getParameter("stato");
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      LocalDate localDate = LocalDate.now(); 
      String dataInvio = localDate.toString();
      //Gestione della data
      String dataAccettazione = null;
    
      //Studente studente= 
      //(Studente) request.getSession().getAttribute("currentSessionUser");
      Studente studente = new Studente("","","","","","","","","","","","","");
    
      //trova il tirocinio tramite id 
      //Tirocinio tirocinio = tirocini.get(id);
      //che manda il tutor accademico qui
      TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
      Tirocinio tirocinio = new Tirocinio("", "", "", 1, 1010, ta, "", "", "");
   
      RichiestaTirocinio richiesta = new RichiestaTirocinio(
          stato, dataInvio, dataAccettazione, studente, tirocinio);
      try {
        if (inviaRichiesta(richiesta) == true) {
          //lancia un alert nel caso di successo nell'invio della richiesta
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Richiesta inviata');");
          out.println("</script>");
          //Modifichiamo il numero di posti del tirocinio
          //tirocinio.setNumPost(tirocinio.getNumPost - 1);
          response.sendRedirect("offerta_formativa_studente.jsp");
        }
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } /*else 
      if (request.getSession().getAttribute("currentSessionUser") == null) {
        //lancia un alert nel caso di fallimento nell'invio della richiesta
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Richiesta non inviata');");
        out.println("</script>");
        response.sendRedirect("Login.jsp"); 
      } 
  }*/


  /**
   * Gestisce l'invio della richiesta tirocinio.
   * 
   * @param richiestaTirocinio richiesta relativa ad un tirocinio
   * @return boolean
   * @throws StartupCacheException 
   * 
   */

  public boolean inviaRichiesta(RichiestaTirocinio richiestaTirocinio) 
        throws StartupCacheException {
    boolean check = true;
    TutorAccademico ta = richiestaTirocinio.getTirocinio().getTutor();
    //TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<Tirocinio> tirocini = tiroc.findTirocinioForTutorAccademico(ta.getEmail());
    
    //inserimento richiesta
    for (Tirocinio t : tirocini) {
      if ((controllaDisponibilita(t)) && (controllaInvioPrecedente(richiestaTirocinio))) {
        tiroc.insertRichiestaTirocinio(richiestaTirocinio);
        check = true;
        break;
      } else {
        check = false;
        break;
      }
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
  public boolean controllaInvioPrecedente(RichiestaTirocinio tirocinio) 
      throws StartupCacheException {
    //Studente studente= 
    //(Studente) request.getSession().getAttribute("currentSessionUser");
    Studente studente = new Studente("","","","","","","","","","","","","");
    
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    if (tiroc.findRichiestaTirocinioForUser(studente.getEmail()) == null) {
      return true;
    } else {
      return false;
    }
  }


}