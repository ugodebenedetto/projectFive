/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class VisualizzaRichiestaTirocinioTest extends Mockito{
  
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
  ArrayList<RichiestaTirocinio> richieste;
  ArrayList<Tirocinio> tirocini;
  Studente studente;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    ta = new TutorAccademico();
    studente = new Studente();
    
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(ta);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException {
    new VisualizzaRichiestaTirocinio().doGet(req, res);
  }


  @Test
  public void testVisualizzaStatoRichiestaTirocinioStudente() throws StartupCacheException {
    new VisualizzaRichiestaTirocinio().visualizzaRichiestaTirocinioStudente(studente);
  }
  
  @Test
  public void testVisualizzaStatoRichiestaTirocinioTutor() {
    
  }
}
