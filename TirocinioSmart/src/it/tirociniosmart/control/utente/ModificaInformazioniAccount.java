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

      String codiceFiscale = request.getParameter("codiceFiscale");
      if (!codiceFiscale.equals("")) {
        studente.setCodiceFiscale(codiceFiscale);
      }

      String nome = request.getParameter("nome");
      if (!nome.equals("")) {
        studente.setNome(nome);
      }

      String cognome = request.getParameter("cognome");
      if (!cognome.equals("")) {
        studente.setCognome(cognome);

      }

      String luogoNascita = request.getParameter("luogoNascita");
      if (!luogoNascita.equals("")) {
        studente.setLuogoNascita(luogoNascita);
      }

      String dataNascita = request.getParameter("dataNascita");
      if (!dataNascita.equals("")) {
        studente.setDataNascita(request.getParameter("dataNascita"));
      }

      String residenza = request.getParameter("residenza");
      if (!residenza.equals("")) {
        studente.setResidenza(residenza);
      }

      String via = request.getParameter("via");
      if (!via.equals("")) {
        studente.setVia(via);
      }

      String sesso = request.getParameter("sesso");
      if (!sesso.equals("")) {
        studente.setSesso(sesso);
      }

      String telefono = request.getParameter("telefono");
      if (!telefono.equals("")) {
        studente.setTelefono(telefono);
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

      String codiceFiscale = request.getParameter("codiceFiscale");
      if (!codiceFiscale.equals("")) {
        tutor.setCodiceFiscale(codiceFiscale);
      }

      String nome = request.getParameter("nome");
      if (!nome.equals("")) {
        tutor.setNome(nome);
      }

      String cognome = request.getParameter("cognome");
      if (!cognome.equals("")) {
        tutor.setCognome(cognome);

      }

      String luogoNascita = request.getParameter("luogoNascita");
      if (!luogoNascita.equals("")) {
        tutor.setLuogoNascita(luogoNascita);
      }

      String dataNascita = request.getParameter("dataNascita");
      if (!dataNascita.equals("")) {
        tutor.setDataNascita(request.getParameter("dataNascita"));
      }

      String residenza = request.getParameter("residenza");
      if (!residenza.equals("")) {
        tutor.setResidenza(residenza);
      }

      String via = request.getParameter("via");
      if (!via.equals("")) {
        tutor.setVia(via);
      }

      String sesso = request.getParameter("sesso");
      if (!sesso.equals("")) {
        tutor.setSesso(sesso);
      }

      String telefono = request.getParameter("telefono");
      if (!telefono.equals("")) {
        tutor.setTelefono(telefono);
      }


      try {
        if (modificaProfiloTutor(tutor,
            (TutorAccademico) request.getSession().getAttribute("currentSessionUser"))) {
          request.getSession().setAttribute("currentSessionUser", tutor);
          url = "../it.tirociniosmart.view.tutorAccademico/account_tutor_accademico.jsp";
        } else {
          url = "../it.tirociniosmart.view.tutorAccademico/modifica_info_tutor_accademico.jsp";
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
