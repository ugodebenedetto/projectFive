
/**
 * Servelt che permete all'utente di registrarsi al sito e quindi al servizio
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
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/it.tirociniosmart.view.utente/Registrazione")
public class Registrazione extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   * @throws ServletException
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String url = null;
    String email = request.getParameter("email");
    String tipo = request.getParameter("tipo");

    if (controllaEsistenzaUser(email, tipo)) {
      url = "errorRegistrazione.jsp";
    } else {

      String codiceFiscale = request.getParameter("codiceFiscale");
      String nome = request.getParameter("nome");
      String cognome = request.getParameter("cognome");
      String luogoNascita = request.getParameter("luogoNascita");
      String dataNascita = request.getParameter("dataNascita");
      String password = request.getParameter("password");
      String residenza = request.getParameter("residenza");
      String via = request.getParameter("via");
      String sesso = request.getParameter("sesso");
      String telefono = request.getParameter("telefono");

      if (tipo.equalsIgnoreCase("studente")) {
        String matricola = request.getParameter("matricola");
        String tipoLaurea = request.getParameter("tipoLaurea");
        Studente studente = new Studente(email, codiceFiscale, nome, cognome, luogoNascita,
            dataNascita, password, sesso, residenza, via, telefono, matricola, tipoLaurea);
        try {
          if (registraStudente(studente)) {
            url = "successRegistrazione.jsp";
          } else {
            url = "errorRegistrazione.jsp";
          }
        } catch (StartupCacheException e) {
          e.printStackTrace();
        }
      } else if (tipo.equalsIgnoreCase("tutorAccademico")) {
        String dipartimento = request.getParameter("dipartimento");
        // codice docente del tutor
        String codiceDocente = request.getParameter("codiceDocente");
        TutorAccademico tutor =
            new TutorAccademico(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita,
                password, sesso, residenza, via, telefono, dipartimento, codiceDocente);
        try {
          if (registraTutor(tutor)) {
            url = "successRegistrazione.jsp";
          } else {
            url = "errorRegistrazione.jsp";
          }
        } catch (StartupCacheException e) {
          e.printStackTrace();
        }
      }
    }

    response.sendRedirect(url);
  }


  /**
   * Questo metodo permette di controllare che l'utente non sia presente nel DB.
   * 
   * @param email email da controllare
   * @return boolean
   * 
   */
  // tipo si riferisce al tipo di utente che si sta per registrare (studente o tutor)
  public boolean controllaEsistenzaUser(String email, String tipo) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();

    if (tipo.equalsIgnoreCase("studente")) {

      HashMap<String, Studente> studenti = utente.selectStudente();
      if (studenti.get(email) != null) {
        return true;
      }
    } else if (tipo.equalsIgnoreCase("tutor")) {

      HashMap<String, TutorAccademico> tutor = utente.selectTutorAccademico();
      if (tutor.get(email) != null) {
        return true;
      }
    }

    return false;
  }



  /**
   * Metodo che registra lo studente nel db.
   * 
   * @param studente da registrare nel db
   * @return boolean
   * @throws StartupCacheException .
   */
  // per ora lo faccio boolean poi ne dobbiamo parlare
  public boolean registraStudente(Studente studente) throws StartupCacheException {

    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();

    if (utente.insertStudente(studente)) {
      return true;
    } else {
      return false;
    }

  }

  /**
   * Metodo che registra il tutor nel DB.
   * 
   * @param tutor tutor da registrare
   * @return boolean
   * @throws StartupCacheException .
   */
  public boolean registraTutor(TutorAccademico tutor) throws StartupCacheException {

    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();

    if (utente.inserTutorAccademico(tutor)) {
      return true;
    } else {
      return false;
    }
  }
}
