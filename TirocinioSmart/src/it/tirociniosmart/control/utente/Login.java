/**
 * Servelt che permete all'utente di autenticarsi per accedere al servizio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

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

    StartupCache cache = new StartupCache();
    String url = null;
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String tipo = request.getParameter("tipo");

    HashMap<String, Annuncio> annunci = new HashMap<>();

    annunci = visualizzaListaAnnuncio();

    if (tipo.equals("studente")) {
      email = email + "@studenti.unisa.it";
      Studente studente = loginStudente(email, password);
      if (studente == null) {
        url = "login.jsp";
      } else {
        ArrayList<RichiestaTirocinio> richieste = new ArrayList<>();
        
        try {
          richieste = visualizzaRichiestaTirocinioStudente(studente);
        } catch (StartupCacheException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
        
        HashMap<Integer, Tirocinio> tirocini = new HashMap<>();
        try {
          tirocini = visualizzaTuttiTirocini();
        } catch (StartupCacheException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        try {
          Tirocinio t = returnTirocinioForStudent(studente);
          if (t != null) {
            request.getSession().setAttribute("tirocinioStudente", t);
          }
        } catch (StartupCacheException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
        request.getSession().setAttribute("richieste", richieste);
        request.getSession().setAttribute("tirocini", tirocini);
        request.getSession().setAttribute("currentSessionUser", studente);
        url = "../it.tirociniosmart.view.studente/home_studente.jsp";
      }
    } else if (tipo.equals("tutorAccademico")) {
      email = email + "@unisa.it";
      TutorAccademico tutor = loginTutor(email, password);
      if (tutor == null) {
        url = "login.jsp";
      } else {
        ArrayList<Tirocinio> tirocini = new ArrayList<>();
        try {
          tirocini = visualizzaListaTirocinio(tutor);
        } catch (StartupCacheException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        request.getSession().setAttribute("tirociniTutor", tirocini);
        System.out.println("TIROCINI: " + tirocini.size());
        request.getSession().setAttribute("currentSessionUser", tutor);
        url = "../it.tirociniosmart.view.tutorAccademico/home_tutor_accademico.jsp";
      }
    } else if (tipo.equals("didattica")) {
      email = email + "@unisa.it";
      Didattica didattica = loginDidattica(email, password);
      if (didattica == null) {
        url = "login.jsp";
      } else {
        HashMap<Integer, Tirocinio> tirocini = new HashMap<>();
        try {
          tirocini = visualizzaTuttiTirocini();
        } catch (StartupCacheException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        request.getSession().setAttribute("tirocini", tirocini);
        request.getSession().setAttribute("currentSessionUser", didattica);
        if (didattica.getDirettore()) {
          url = "../it.tirociniosmart.view.direttore/home_direttore.jsp";
        } else {
          url = "../it.tirociniosmart.view.didattica/home_didattica.jsp";
        }
      }
    }

    request.getSession().setAttribute("annunci", annunci);
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

  /**
   * Questo metodo visualizza tutti i tirocini.
   * 
   * @return ArrayList tirocinio
   * @throws StartupCacheException
   * 
   */
  public ArrayList<Tirocinio> visualizzaListaTirocinio(TutorAccademico tutor)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
    listaTirocini = tiroc.findTirocinioForTutorAccademico(tutor.getEmail());
    for (int i = 0; i < listaTirocini.size(); i++) {
      System.out.println("Nome = " + listaTirocini.get(i).getNome() + "Tutor = "
          + listaTirocini.get(i).getTutor().getNome());
    }
    return listaTirocini;

  }

  /**
   * Questo metodo visualizza tutti i tirocini.
   * 
   * @return ArrayList tirocinio
   * @throws StartupCacheException
   * 
   */
  public HashMap<Integer, Tirocinio> visualizzaTuttiTirocini() throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    HashMap<Integer, Tirocinio> listaTirocini = new HashMap<>();
    listaTirocini = tiroc.selectTirocinio();
    return listaTirocini;

  }

  public Tirocinio returnTirocinioForStudent(Studente s) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    ArrayList<RichiestaTirocinio> rt = tiroc.findRichiestaTirocinioForUser(s.getEmail());
    Tirocinio tirocinio = null;
    for (RichiestaTirocinio richieste : rt) {
      if (richieste.getStato().equals("richiestaAccettata")) {
        tirocinio = richieste.getTirocinio();
        break;
      }
    }
    return tirocinio;
  }

  /**
   * Questo metodo visualizza tutti gli annunci.
   * 
   * @return ArrayList Annuncio
   */
  public HashMap<String, Annuncio> visualizzaListaAnnuncio() {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    return annunci.selectAnnuncio();

  }

  /**
   * Visualizza lo stato della richiesta tirocinio svolta da uno studente.
   * 
   * @param studente studente di cui visualizzare lo stato della richiesta
   * @return RichiestaTirocinio
   * @throws StartupCacheException eccezione cache
   */
  public ArrayList<RichiestaTirocinio> visualizzaRichiestaTirocinioStudente(Studente studente)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    return tiroc.findRichiestaTirocinioForUser(studente.getEmail());
  }
}
