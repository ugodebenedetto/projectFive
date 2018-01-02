/**
 * Servelt che permete all'utente di modificare il suo profilo
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/modificaInformazioni")
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

    String codiceFiscale = request.getParameter("codiceFiscale");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String luogoNascita = request.getParameter("luogoNascita");
    String dataNascita = request.getParameter("dataNascita");
    String residenza = request.getParameter("residenza");
    String via = request.getParameter("via");
    String sesso = request.getParameter("sesso");
    String telefono = request.getParameter("telefono");

    if (request.getSession().getAttribute("currentSessionUser") instanceof Studente) {
      Studente studente = (Studente) request.getSession().getAttribute("currentSessionUser");
      studente.setCodiceFiscale(codiceFiscale);
      studente.setCognome(cognome);
      studente.setDataNascita(dataNascita);
      studente.setLuogoNascita(luogoNascita);
      studente.setNome(nome);
      studente.setResidenza(residenza);
      studente.setSesso(sesso);
      studente.setTelefono(telefono);
      studente.setVia(via);

      if (modificaProfiloStudente(studente,
          (Studente) request.getSession().getAttribute("currentSessionUser"))) {
        request.getSession().setAttribute("currentSessionUser", studente);
        url = "/it.tirociniosmart.view.studente/info_account_studente.jsp";
      } else {
        url = "/it.tirociniosmart.view.studente/modifica_account_studente.jsp";
      }

    } else if (request.getSession().getAttribute("currentSessionUser") instanceof TutorAccademico) {
      TutorAccademico tutor =
          (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
      tutor.setCodiceFiscale(codiceFiscale);
      tutor.setCognome(cognome);
      tutor.setDataNascita(dataNascita);
      tutor.setLuogoNascita(luogoNascita);
      tutor.setNome(nome);
      tutor.setResidenza(residenza);
      tutor.setSesso(sesso);
      tutor.setTelefono(telefono);
      tutor.setVia(via);

      if (modificaProfiloTutor(tutor,
          (TutorAccademico) request.getSession().getAttribute("currentSessionUser"))) {
        request.getSession().setAttribute("currentSessionUser", tutor);
        url = "/it.tirociniosmart.view.tutorAccademico/account_tutor_accademico.jsp";
      } else {
        url = "/it.tirociniosmart.view.tutorAccademico/modifica_info_tutor_accademico.jsp";
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
   * @param newStudente studente che sostituir� quello gi� presente
   * @param oldStudente studente che sar� stostituito.
   * @return true se avvenuto con successo false altrimenti
   */
  public boolean modificaProfiloStudente(Studente newStudente, Studente oldStudente) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDAO proxy = (ProxyUtenteDAO) factory.getUtenteDao();

    if (proxy.updateStudente(newStudente, oldStudente)) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Metodo per modificare il profilo del tutor.
   * @param newTutor tutor che sostituir� quello gi� presente
   * @param oldTutor tutor che sar� stostituito
   * @return true se avvenuto con successo false altrimenti
   */
  public boolean modificaProfiloTutor(TutorAccademico newTutor, TutorAccademico oldTutor) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDAO proxy = (ProxyUtenteDAO) factory.getUtenteDao();

    if (proxy.updateTutorAccademico(newTutor, oldTutor)) {
      return true;
    } else {
      return false;
    }
  }
}
