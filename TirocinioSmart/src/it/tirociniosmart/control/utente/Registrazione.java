package it.tirociniosmart.control.utente;

/**
 * Servelt che permete all'utente di registrarsi al sito e quindi al servizio
 * 
 * @author Clara Monaco
 */

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    if (checkEmail(email)) {
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

        if (checkParameters(codiceFiscale, nome, cognome, luogoNascita, dataNascita, password,
            residenza, via, telefono)) {
          if (tipo.equalsIgnoreCase("studente")) {
            String matricola = request.getParameter("matricola");
            String tipoLaurea = request.getParameter("tipoLaurea");
            email = email + "@studenti.unisa.it";
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
            email = email + "@unisa.it";
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
        } else {
          url = "errorRegistrazione.jsp";
        }
      }
    } else {
      url = "errorRegistrazione.jsp";
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
      if (studenti != null) {
        if (studenti.get(email) != null) {
          return true;
        }
      }
    } else if (tipo.equalsIgnoreCase("tutor")) {

      HashMap<String, TutorAccademico> tutor = utente.selectTutorAccademico();
      if (tutor != null) {
        if (tutor.get(email) != null) {
          return true;
        }
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

  /**
   * Metodo di convalida dei parametri della registrazione.
   * 
   * @param codiceFiscale codice fiscale da convalidare
   * @param nome nome da convalidare
   * @param cognome cognome da convalidare
   * @param luogoNascita luogo di nascita da convalidare
   * @param dataNascita data di nascita da convalidare
   * @param password passowrd da convalidare
   * @param residenza da convalidare
   * @param via via da convalidare
   * @param telefono da convalidare
   * @return boolean
   */

  public boolean checkParameters(String codiceFiscale, String nome, String cognome,
      String luogoNascita, String dataNascita, String password, String residenza, String via,
      String telefono) {

    boolean check = true;
    boolean checkDate = true;
    int checkVia = 0;

    Date date = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
      date = sdf.parse(dataNascita);
      if (!dataNascita.equals(sdf.format(date))) {
        date = null;
      }
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (date == null) {
      // Invalid date format
      checkDate = false;
    } else {
      checkDate = true;
    }
    // Controllo via

    if (((((((nome.length() >= 3) && (nome.length() <= 20)) && ((cognome.length() >= 3))
        && (cognome.length() <= 20)) && ((password.length() >= 8) && (password.length() <= 20))
        && ((residenza.length() >= 3)) && (residenza.length() <= 40))
        && ((luogoNascita.length() >= 3)) && (luogoNascita.length() <= 40)) && ((via.length() >= 5))
        && (via.length() <= 40)) && (via.contains(",")) && ((codiceFiscale.length() == 16))
        && ((checkDate)) && ((telefono.length() == 10))) {
      System.out.println("Entro nell'if");
      for (int i = 0; i < nome.length(); i++) {
        char ch = nome.charAt(i);
        if (!(Character.isLetter(ch) || (ch == ' '))) {
          System.out.println("Nome sbagliato");
          check = false;
          break;
        }
      }

      for (int i = 0; i < cognome.length(); i++) {
        char ch = cognome.charAt(i);
        if (!(Character.isLetter(ch) || (ch == ' '))) {
          System.out.println("Cognome sbagliato");
          check = false;
          break;
        }
      }

      for (int i = 0; i < password.length(); i++) {
        char ch = password.charAt(i);
        if (!((Character.isLetter(ch)
            || (Character.isDigit(ch) || (ch == '.') || (ch == '_') || (ch == '-'))))) {
          System.out.println("Password sbagliato");
          check = false;
          break;
        }
      }
      for (int i = 0; i < residenza.length(); i++) {
        char ch = residenza.charAt(i);
        if (!(Character.isLetter(ch) || (ch == ' '))) {
          System.out.println("residenza sbagliato");
          check = false;
          break;
        }
      }
      for (int i = 0; i < luogoNascita.length(); i++) {
        char ch = luogoNascita.charAt(i);
        if (!(Character.isLetter(ch) || (ch == ' '))) {
          System.out.println("luogo sbagliato");
          check = false;
          break;
        }
      }
      for (int i = 0; i < via.length(); i++) {
        char ch = via.charAt(i);
        if ((Character.isLetter(ch)) || (Character.isDigit(ch)) || (ch == ',')
            || (ch == ' ') && (checkVia < 2)) {
          if (ch == ',') {
            checkVia++;
          }
        } else {
          System.out.println("via sbagliata");
          check = false;
          break;
        }
      }
      for (int i = 0; i < codiceFiscale.length(); i++) {
        char ch = codiceFiscale.charAt(i);
        if (!((Character.isLetter(ch)) || (Character.isDigit(ch)))) {
          System.out.println("codice sbagliato");
          check = false;
          break;
        }
      }
      for (int i = 0; i < telefono.length(); i++) {
        char ch = telefono.charAt(i);
        if (!Character.isDigit(ch)) {
          System.out.println("telefono sbagliato");
          check = false;
          break;
        }
      }
    } else {
      check = false;
    }

    return check;
  }


  /**
   * Metodo per la convalida della email.
   * 
   * @param email da convalidare
   * @return boolean
   */
  public boolean checkEmail(String email) {
    boolean checkEmail = true;
    if ((email.length() >= 5) && (email.length() <= 40)) {
      for (int i = 0; i < email.length(); i++) {
        char ch = email.charAt(i);
        if (!((Character.isLetter(ch)
            || (Character.isDigit(ch) || (ch == '.') || (ch == '_') || (ch == '-'))))) {
          checkEmail = false;
          break;
        }
      }
    } else {
      checkEmail = false;
    }
    return checkEmail;
  }
}
