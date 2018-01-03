/**
 * Servlet che permette allo studente di inviare la richiesta di tirocinio
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
    
    String id = request.getParameter("id");
    String stato = request.getParameter("stato");
    String dataInvio = request.getParameter("dataInvio");
    String dataAccettazione = request.getParameter("dataAccettazione");
    
    //Studente studente= 
    //(Studente) request.getSession().getAttribute("currentSessionUser");
    Studente studente = new Studente("","","","","","","","","","","","","");
    
    //trova il tirocinio tramite id ???
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinio = new Tirocinio("", "", 1, ta);
   
    RichiestaTirocinio richiesta = new RichiestaTirocinio(
        stato, dataInvio, dataAccettazione, studente, tirocinio);
    if (inviaRichiesta(richiesta) == true) {
      //lancia un alert nel caso di successo nell'invio della richiesta
      out.println("<script type=\"text/javascript\">");
      out.println("alert('Richiesta inviata');");
      out.println("</script>");
      //Modifichiamo il numero di posti del tirocinio
      //tirocinio.setNumPost(tirocinio.getNumPost - 1);
      response.sendRedirect("NONLOSO.jsp");
    } else {
      //lancia un alert nel caso di fallimento nell'invio della richiesta
      out.println("<script type=\"text/javascript\">");
      out.println("alert('Richiesta non inviata');");
      out.println("</script>");
      response.sendRedirect("NONLOSO.jsp"); 
    }
  }


  /**
   * Gestisce l'invio della richiesta tirocinio.
   * 
   * @param richiestaTirocinio richiesta relativa ad un tirocinio
   * @return boolean
   * 
   */

  public boolean inviaRichiesta(RichiestaTirocinio richiestaTirocinio) {
    //prendo il tutor accademico dalla session ???
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    Tirocinio tirocinio = proxyTirocinio.findTirocinioForTutorAccademico(ta);
    
    //inserimento richiesta
    proxyTirocinio.insertRichiestaTirocinio(richiestaTirocinio);
    if ((controllaDisponibilita(tirocinio)) && (controllaInvioPrecedente(richiestaTirocinio))) {
      proxyTirocinio.insertRichiestaTirocinio(richiestaTirocinio);
      return true;
    } else {
      return false;  
    }
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
   * 
   */
  public boolean controllaInvioPrecedente(RichiestaTirocinio tirocinio) {
    //Studente studente= 
    //(Studente) request.getSession().getAttribute("currentSessionUser");
    Studente studente = new Studente("","","","","","","","","","","","","");
    
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxy = (ProxyTirocinioDao) factory.getTirocinioDao();
    if (proxy.findRichiestaTirocinioForUser(studente) == null) {
      return true;
    } else {
      return false;
    }
  }


}