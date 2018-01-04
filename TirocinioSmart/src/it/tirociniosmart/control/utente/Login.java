/**
 * Servelt che permete all'utente di autenticarsi per accedere al servizio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.utente.Didattica;
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

@WebServlet("/it.tirociniosmart.view.utente/Login")
public class Login extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
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
    String password = request.getParameter("password");
    String tipo = request.getParameter("tipo");

    if (tipo.equals("studente")) {
      Studente studente = loginStudente(email, password);
      if (studente.equals(null)) {
        url = "login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", studente);
        url = "../it.tirociniosmart.view.studente/home_studente.jsp";
      }
    } else if (tipo.equals("tutorAccademico")) {
      TutorAccademico tutor = loginTutor(email, password);
      if (tutor.equals(null)) {
        url = "login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", tutor);
        url = "../it.tirociniosmart.view.tutorAccademico/home_tutor_accademico.jsp";
      }
    } else if (tipo.equals("didattica")) {
      Didattica didattica = loginDidattica(email, password);
      if (didattica.equals(null)) {
        url = "login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", didattica);
        url = "../it.tirociniosmart.view.didattica/home_didattica.jsp";
      }
    }

    response.sendRedirect(url);

  }

  /**
   * Questo metodo gestisce la richiesta dello studente di loggarsi per accedere al servizio.
   * 
   * 
   * @param email username dell'utente che deve loggarsi
   * @param password password dell'utente che deve loggarsi
   * 
   * 
   */
  public Studente loginStudente(String email, String password) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    HashMap<String, Studente> studenti = utente.selectStudente();

    Studente stu = null;

    if ((studenti.get(email) != null) && studenti.get(email).getPassword().equals(password)) {
      stu = studenti.get(email);
    }

    return stu;
  }

  /**
   * Questo metodo gestisce la richiesta del tutor di loggarsi per accedere al servizio.
   * 
   * 
   * @param email username dell'utente che deve loggarsi
   * @param password password dell'utente che deve loggarsi
   *
   * 
   */
  public TutorAccademico loginTutor(String email, String password) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    HashMap<String, TutorAccademico> tutor = utente.selectTutorAccademico();

    TutorAccademico tutorAcc = null;

    if ((tutor.get(email) != null) && tutor.get(email).getPassword().equals(password)) {
      tutorAcc = tutor.get(email);
    }

    return tutorAcc;
  }

  /**
   * Questo metodo gestisce la richiesta della didattica di loggarsi per accedere al servizio.
   * 
   * 
   * @param email username dell'utente che deve loggarsi
   * @param password password dell'utente che deve loggarsi
   * 
   * 
   */
  public Didattica loginDidattica(String email, String password) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    HashMap<String, Didattica> didattiche = utente.selectDidattica();

    Didattica dida = null;

    if ((didattiche.get(email) != null) && didattiche.get(email).getPassword().equals(password)) {
      dida = didattiche.get(email);
    }

    return dida;
  }


}
