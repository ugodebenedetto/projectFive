/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class VisualizzaListaTirociniTest extends Mockito {
  
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  FactoryProducer producer;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;
  HashMap<Integer, Tirocinio> tirociniHash;
  ArrayList<Tirocinio> tirociniList;
  HashMap<Integer, Studente> studenti;
  ArrayList<Studente> tirocinanti;
  Tirocinio tirocinio;
  TutorAccademico ta;
  Studente studente;
  int id;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    ta = new TutorAccademico();
    studente = new Studente();
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("tirociniTutor")).thenReturn(tirociniList);
  }

  @After
  public void tearDown() throws Exception {}

  
  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException {
    new VisualizzaListaTirocini().doGet(req, res);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(ta);
    new VisualizzaListaTirocini().doGet(req, res);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(studente);
    new VisualizzaListaTirocini().doGet(req, res);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(null);
  }

  @Test
  public void testVisualizzaListaTirocinio() {
  }

}
