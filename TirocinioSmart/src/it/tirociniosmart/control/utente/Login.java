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
import it.tirociniosmart.model.utente.Utente;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {


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
   * @throws IOException
   * @throws ServletException
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String user = request.getParameter("username");
    String password = request.getParameter("password");
    String tipo = request.getParameter("tipo");

    if (tipo.equals("studente")) {
      Studente studente = loginStudente(user, password);
      request.getSession().setAttribute("currentSessionUser", studente);
    } else if (tipo.equals("tutor")) {
      TutorAccademico tutor = loginTutor(user, password);
      request.getSession().setAttribute("currentSessionUser", tutor);
    } else if (tipo.equals("didattica")) {
      Didattica didattica = loginDidattica(user, password);
      request.getSession().setAttribute("currentSessionUser", didattica);
    }

    RequestDispatcher dispatcher =
        getServletContext().getRequestDispatcher("DOBBIAMO ANCORA VEDERE DOVE FARE IL REDIRECT");
    dispatcher.forward(request, response);

  }

  /**
   * Questo metodo gestisce la richiesta dell'utente di loggarsi per accedere al servizio.
   * 
   * 
   * @param username username dell'utente che deve loggarsi
   * @param password password dell'utente che deve loggarsi
   * 
   * 
   */
  public Studente loginStudente(String username, String password) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();

    ArrayList<Studente> studenti = proxy.selectStudente();

    for (int i = 0; i < studenti.size(); i++) {
      if (studenti.get(i).getEmail().equals(username)
          && studenti.get(i).getPassword().equals(password)) {
        Studente studente = studenti.get(i);
        return studente;
      }
    }
    return null;
  }

  public TutorAccademico loginTutor(String username, String password) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();
    ArrayList<TutorAccademico> tutor = proxy.selectTutorAccademico();

    for (int i = 0; i < tutor.size(); i++) {
      if (tutor.get(i).getEmail().equals(username) && tutor.get(i).getPassword().equals(password)) {
        TutorAccademico tutorAccademico = tutor.get(i);
        return tutorAccademico;
      }
    }
    return null;
  }

  public Didattica loginDidattica(String username, String password) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyUtenteDao proxy = (ProxyUtenteDao) factory.getUtenteDao();
    ArrayList<Didattica> didattiche = proxy.selectDidattica();

    for (int i = 0; i < didattiche.size(); i++) {
      if (didattiche.get(i).getEmail().equals(username)
          && didattiche.get(i).getPassword().equals(password)) {
        Didattica didattica = didattiche.get(i);
        return didattica;
      }
    }
    return null;
  }
}
