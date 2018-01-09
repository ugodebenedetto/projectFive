/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;


public class InserisciTirocinioTest extends Mockito {

  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  FactoryProducer producer;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;
  ArrayList<Tirocinio> tirocini;
  
  TutorAccademico ta;
  Tirocinio tirocinio;
  
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    tirocini = new ArrayList<Tirocinio>();
    
    ta = new TutorAccademico("tutor@mail.it","","","","","","","","","","","","");
    
    tirocinio = new Tirocinio("titolo","obiettivi","descrizion",4,ta,"Sede","tip","resp");
    producer = FactoryProducer.getIstance();
    tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tirocini = tiroc.findTirocinioForTutorAccademico(ta.getEmail());
    if(tirocini == null){
      tirocini = new ArrayList<Tirocinio>();
      tirocini.add(tirocinio);
    }
    
    when(req.getParameter("nome")).thenReturn("titolo");
    when(req.getParameter("Obiettivi")).thenReturn("obiettivo1");
    when(req.getParameter("Descrizione")).thenReturn("descrizione1");
    when(req.getParameter("Numero Posti")).thenReturn("3");
    when(req.getParameter("Sede")).thenReturn("sede1");
    when(req.getParameter("Tipo")).thenReturn("tipo1");
    when(req.getParameter("Responsabile")).thenReturn("responsabile1");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(ta);
    when(req.getSession().getAttribute("tirocini")).thenReturn(tirocini);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() throws IOException {
    
    ta = (TutorAccademico) req.getSession().getAttribute("currentSessionUser");
    new InserisciTirocinio().doPost(req, res);
    
    /*String nome = req.getParameter("nome");
    String obiettivi = req.getParameter("Obiettivi");
    String descrizione = req.getParameter("Descrizione");
    int numPost = Integer.parseInt(req.getParameter("Numero Posti"));
    String sede = req.getParameter("Sede");
    String tipo = req.getParameter("Tipo");
    String responsabile = req.getParameter("Responsabile");
    
    assertEquals(nome, "titolo");
    assertEquals(obiettivi, "obiettivo1");
    assertEquals(descrizione, "descrizione1");
    assertEquals(numPost, 3);
    assertEquals(sede, "sede1");
    assertEquals(tipo, "tipo1");
    assertEquals(responsabile, "responsabile1");
    
    ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
      ta, sede, tipo, responsabile);*/
  }

  @Test
  public void testInserisciTirocinio() {
    
  }

}
