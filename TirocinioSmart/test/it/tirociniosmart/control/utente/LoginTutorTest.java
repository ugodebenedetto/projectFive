package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.io.IOException;
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

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

public class LoginTutorTest {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;

  FactoryProducer producer;
  AbstractFactory utenteFactory;
  UtenteDAO utente;

  String email;
  String pass;
  TutorAccademico ta;
  HashMap<String, TutorAccademico> tutor;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;

  ArrayList<Tirocinio> tirocini;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();

    producer = FactoryProducer.getIstance();
    utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    tutor = utente.selectTutorAccademico();

    tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();

    Mockito.when(req.getParameter("email")).thenReturn("ddddd");
    Mockito.when(req.getParameter("pass")).thenReturn("dddddddd");
    Mockito.when(req.getParameter("tipo")).thenReturn("tutorAccademico");
    Mockito.when(req.getSession()).thenReturn(session);
    
    if (tutor.get("ddddd@unisa.it") != null) {
      ta = tutor.get("ddddd@unisa.it");
    }
        
    tirocini = new ArrayList<>();
  }


  @After
  public void tearDown() throws Exception {}



  @Test
  public void testDoPostHttpServletRequestHttpServletResponse()
      throws ServletException, IOException, StartupCacheException {
    email = req.getParameter("email");
    pass = req.getParameter("pass");
    email = email + "@unisa.it";

    if (req.getParameter("tipo").equals("tutorAccademico")) {
      new Login().doPost(req, res);

      testLoginTutor();
      
      new Login().visualizzaListaTirocinio(ta);
    }
  }

  @Test
  public void testLoginTutor() {
    new Login().loginTutor(req.getParameter(email), req.getParameter(pass));

  }

  @Test
  public void testVisualizzaListaTirocinio() throws StartupCacheException {}

}
