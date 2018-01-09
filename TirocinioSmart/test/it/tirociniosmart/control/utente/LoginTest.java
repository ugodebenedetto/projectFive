package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.DAOCache;
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

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;



public class LoginTest extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;

  String email;
  String pass;
  Studente stu;


  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    stu = new Studente();

    when(req.getParameter("email")).thenReturn("ccccc");
    when(req.getParameter("password")).thenReturn("cccccccc");
    when(req.getParameter("tipo")).thenReturn("studente");
    when(req.getSession()).thenReturn(session);

  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse()
      throws ServletException, IOException, StartupCacheException {

    email = req.getParameter("email");
    pass = req.getParameter("password");

    if (req.getParameter("tipo").equals("studente")) {
      new Login().doPost(req, res);


      try {
        testVisualizzaRichiestaTirocinioStudente();
        testVisualizzaTuttiTirocini();
        testReturnTirocinioForStudent();

      } catch (StartupCacheException e) {
        e.printStackTrace();
      }
    }

  }

  @Test
  public void testLoginStudente() {
    stu = new Login().loginStudente(req.getParameter("email"), req.getParameter("pass"));
  }

  @Test
  public void testVisualizzaRichiestaTirocinioStudente() throws StartupCacheException {
    new Login().visualizzaRichiestaTirocinioStudente(stu);
  }


  @Test
  public void testVisualizzaTuttiTirocini() throws StartupCacheException {
    new Login().visualizzaTuttiTirocini();
  }

  @Test
  public void testReturnTirocinioForStudent() throws StartupCacheException {
    new Login().returnTirocinioForStudent(stu);
  }
}
