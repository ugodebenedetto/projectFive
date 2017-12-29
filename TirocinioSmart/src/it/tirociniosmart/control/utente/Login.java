/**
 * Servelt che permete all'utente di autenticarsi per accedere al servizio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.ProxyUtenteDao;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
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
        url = "/it.tirociniosmart.view.utente/login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", studente);
        url = "/it.tirociniosmart.view.studente/home_studente.jsp";
      }
    } else if (tipo.equals("tutorAccademico")) {
      TutorAccademico tutor = loginTutor(email, password);
      if (tutor.equals(null)) {
        url = "/it.tirociniosmart.view.utente/login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", tutor);
        url = "/it.tirociniosmart.view.tutorAccademico/home_tutor_accademico.jsp";
      }
    } else if (tipo.equals("didattica")) {
      Didattica didattica = loginDidattica(email, password);
      if (didattica.equals(null)) {
        url = "/it.tirociniosmart.view.utente/login.jsp";
      } else {
        request.getSession().setAttribute("currentSessionUser", didattica);
        url = "/it.tirociniosmart.view.didattica/home_didattica.jsp";
      }
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher(url);
    dispatcher.forward(request, response);

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
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();

    ArrayList<Studente> studenti = proxy.selectStudente();

    for (int i = 0; i < studenti.size(); i++) {
      if (studenti.get(i).getEmail().equals(email)
          && studenti.get(i).getPassword().equals(password)) {
        Studente studente = studenti.get(i);
        return studente;
      }
    }
    return null;
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
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();
    ArrayList<TutorAccademico> tutor = proxy.selectTutorAccademico();

    for (int i = 0; i < tutor.size(); i++) {
      if (tutor.get(i).getEmail().equals(email) && tutor.get(i).getPassword().equals(password)) {
        TutorAccademico tutorAccademico = tutor.get(i);
        return tutorAccademico;
      }
    }
    return null;
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
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();
    ArrayList<Didattica> didattiche = proxy.selectDidattica();

    for (int i = 0; i < didattiche.size(); i++) {
      if (didattiche.get(i).getEmail().equals(email)
          && didattiche.get(i).getPassword().equals(password)) {
        Didattica didattica = didattiche.get(i);
        return didattica;
      }
    }
    return null;
  }
}
