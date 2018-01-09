/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class InviaRichiestaTirocinioTest extends Mockito {
  
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  FactoryProducer producer;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;
  HashMap<Integer, Tirocinio> tirocini;
  ArrayList<RichiestaTirocinio> richieste;
  RichiestaTirocinio richiesta;
  Tirocinio tirocinio;
  Studente studente, studente2;
  
  boolean checkInvio, checkDisp;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    tirocinio = new Tirocinio("","","",10,null,"","","");
    
    tirocini = new HashMap<Integer,Tirocinio>();
    tirocini.put(tirocinio.getId(), tirocinio);
    
    studente = new Studente("studente@mail.it","","","","","","","","","","","","");
    Studente studente2 = new Studente("studente2@mail.it","","","","","","","","","","","","");
    
    richiesta = new RichiestaTirocinio(0,"inArrivo", "", "", studente, tirocinio);
    richieste = new ArrayList<RichiestaTirocinio>();
    richieste.add(richiesta);
    richieste.add(null);
    richieste.add(null);
    richieste.add(null);
    
    when(req.getParameter("stato")).thenReturn("abc");
    when(req.getParameter("id")).thenReturn("0");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(studente);
    when(req.getSession().getAttribute("tirocini")).thenReturn(tirocini);
    when(req.getSession().getAttribute("richieste")).thenReturn(richieste);
    
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException, StartupCacheException {
    
    System.out.println("Richieste Array:"+richieste);
    new InviaRichiestaTirocinio().doGet(req, res);
    }
    

    
    /*String stato = req.getParameter("stato");
    int id = Integer.parseInt(req.getParameter("id"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String localDate = (LocalDate.now().format(dtf)).toString(); 
    String dataInvio = localDate;
    String dataAccettazione = null;
    
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Studente studente = new Studente("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = new Tirocinio("","","",1,ta,"","","");
    //tirocini.add(tirocinio);
    tirocinio = tirocini.get(id);
    richiesta = new RichiestaTirocinio(stato, dataInvio, dataAccettazione, studente, tirocinio);
    testInviaRichiesta(); */
  

  @Test
  public void testInviaRichiesta() {
  }

  @Test
  public void testControllaDisponibilita() {
  }

  @Test
  public void testControllaInvioPrecedente() {
  }

}
