/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class ValutaRichiestaTirocinioTest extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  FactoryProducer producer;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;
  ArrayList<RichiestaTirocinio> richieste;
  HashMap<Integer,Tirocinio> tirocini;
  Tirocinio tirocinio;
  RichiestaTirocinio richiesta, richiestaDue, richiestaTre;
  TutorAccademico ta;
  HashMap<Integer, Studente> studenti;
  Studente studente;
  

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    richieste = new ArrayList<RichiestaTirocinio>();
    tirocini = new HashMap<Integer,Tirocinio>();
    
    studente = new Studente();
    ta = new TutorAccademico("tutor@mail.it","","","","","","","","","","","","");
    Tirocinio tirocinio = new Tirocinio("","","",4,1,ta,"","","");
    richiesta = new RichiestaTirocinio(1,"","","",studente,tirocinio);
    richiestaDue = new RichiestaTirocinio(2,"","","",studente,tirocinio);
    richiestaTre = new RichiestaTirocinio(1,"","","",studente,tirocinio);
    
    tirocini.put(0, tirocinio);
    richieste.add(richiesta);
    richieste.add(richiestaDue);
    richieste.add(richiestaTre);
    
    when(req.getParameter("id")).thenReturn("0");
    when(req.getParameter("idTirocinio")).thenReturn("0");
    when(req.getParameter("return")).thenReturn("true");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(ta);
    when(req.getSession().getAttribute("richieste")).thenReturn(richieste);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException {
    
    new ValutaRichiestaTirocinio().doGet(req, res);
    when(req.getParameter("return")).thenReturn("false");
    new ValutaRichiestaTirocinio().doGet(req, res);
  }

  @Test
  public void testAccettaRichiestaTirocinio() {
    try {
      new ValutaRichiestaTirocinio().accettaRichiestaTirocinio(richiesta);
    } catch (StartupCacheException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  public void testRifiutaRichiestaTirocinio() {
    try {
      new ValutaRichiestaTirocinio().rifiutaRichiestaTirocinio(richiesta);
    } catch (StartupCacheException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
