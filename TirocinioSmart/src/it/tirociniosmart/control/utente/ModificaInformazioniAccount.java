/**
 * Servelt che permete all'utente di modificare il suo profilo
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/it.tirociniosmart.view.utente/modificaInformazioni")
public class ModificaInformazioniAccount extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   * @throws ServletException
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = null;

    if (request.getSession().getAttribute("currentSessionUser") instanceof Studente) {
      Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");
      
      if (request.getParameter("codiceFiscale") != null) {
        studente.setCodiceFiscale(request.getParameter("codiceFiscale"));
      }
      
      if (request.getParameter("nome") != null) {
        studente.setNome(request.getParameter("nome"));
      }
      
      if (request.getParameter("cognome") != null) {
        studente.setNome(request.getParameter("cognnome"));
      }
      
      if (request.getParameter("luogoNascita") != null) {
        studente.setLuogoNascita(request.getParameter("luogoNascita"));
      }
      
      if (request.getParameter("dataNascita") != null) {
        studente.setDataNascita(request.getParameter("dataNascita"));
      }
      
      if (request.getParameter("residenza") != null) {
        studente.setResidenza(request.getParameter("residenza"));
      }
      
      if (request.getParameter("via") != null) {
        studente.setVia(request.getParameter("via"));
      }
      
      if (request.getParameter("sesso") != null) {
        studente.setSesso(request.getParameter("sesso"));
      }
      
      if (request.getParameter("telefono") != null) {
        studente.setTelefono(request.getParameter("telefono"));
      }


      try {
        if (modificaProfiloStudente(studente,
            (Studente) request.getSession().getAttribute("currentSessionUser"))) {
          request.getSession().setAttribute("currentSessionUser", studente);
          url = "../it.tirociniosmart.view.studente/info_account_studente.jsp";
        } else {
          url = "../it.tirociniosmart.view.studente/modifica_account_studente.jsp";
        }
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } else if (request.getSession().getAttribute("currentSessionUser") instanceof TutorAccademico) {

      TutorAccademico tutor =
          (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
      
      if (request.getParameter("codiceFiscale") != null) {
        tutor.setCodiceFiscale(request.getParameter("codiceFiscale"));
      }
      
      if (request.getParameter("nome") != null) {
        tutor.setNome(request.getParameter("nome"));
      }
      
      if (request.getParameter("cognome") != null) {
        tutor.setNome(request.getParameter("cognnome"));
      }
      
      if (request.getParameter("luogoNascita") != null) {
        tutor.setLuogoNascita(request.getParameter("luogoNascita"));
      }
      
      if (request.getParameter("dataNascita") != null) {
        tutor.setDataNascita(request.getParameter("dataNascita"));
      }
      
      if (request.getParameter("residenza") != null) {
        tutor.setResidenza(request.getParameter("residenza"));
      }
      
      if (request.getParameter("via") != null) {
        tutor.setVia(request.getParameter("via"));
      }
      
      if (request.getParameter("sesso") != null) {
        tutor.setSesso(request.getParameter("sesso"));
      }
      
      if (request.getParameter("telefono") != null) {
        tutor.setTelefono(request.getParameter("telefono"));
      }
          

      try {
        if (modificaProfiloTutor(tutor,
            (TutorAccademico) request.getSession().getAttribute("currentSessionUser"))) {
          request.getSession().setAttribute("currentSessionUser", tutor);
          url = "it.tirociniosmart.view.tutorAccademico/account_tutor_accademico.jsp";
        } else {
          url = "it.tirociniosmart.view.tutorAccademico/modifica_info_tutor_accademico.jsp";
        }
      } catch (StartupCacheException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    response.sendRedirect(url);

  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Metodo per modificare il profilo dello studente.
   * 
   * @param newStudente studente che sostituirà quello già presente
   * @param oldStudente studente che sarà stostituito.
   * @return true se avvenuto con successo false altrimenti
   * @throws StartupCacheException .
   */
  public boolean modificaProfiloStudente(Studente newStudente, Studente oldStudente)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();


    if (utente.updateStudente(newStudente, oldStudente)) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Metodo per modificare il profilo del tutor.
   * 
   * @param newTutor tutor che sostituirà quello già presente
   * @param oldTutor tutor che sarà stostituito
   * @return true se avvenuto con successo false altrimenti
   * @throws StartupCacheException .
   */
  public boolean modificaProfiloTutor(TutorAccademico newTutor, TutorAccademico oldTutor)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();

    if (utente.updateTutorAccademico(newTutor, oldTutor)) {
      return true;
    } else {
      return false;
    }
  }
}
