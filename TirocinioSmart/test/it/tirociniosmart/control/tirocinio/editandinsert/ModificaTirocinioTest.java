/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

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

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.TutorAccademico;

public class ModificaTirocinioTest extends Mockito {
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
  Tirocinio oldTirocinio, newTirocinio;
  TutorAccademico ta;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    tirocini = new ArrayList<Tirocinio>();
    
    ta = new TutorAccademico("tutor@mail.it","","","","","","","","","","","","");
    
    newTirocinio = new Tirocinio("titolo","obiettivi","descrizion",4,ta,"Sede","tip","resp");
    producer = FactoryProducer.getIstance();
    tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tirocini = tiroc.findTirocinioForTutorAccademico(ta.getEmail());
    if(tirocini == null){
      tirocini = new ArrayList<Tirocinio>();
      tirocini.add(oldTirocinio);
    }
    
    oldTirocinio = new Tirocinio("Titoloold", "Obiettiviold", "Descrizioneold",
      5, 1, ta, "Sedeold", "Tipoold", "Responsabileold");
    
    when(req.getParameter("id")).thenReturn("1");
    when(req.getParameter("nome")).thenReturn("titolo");
    when(req.getParameter("Obiettivi")).thenReturn("obiettivo1");
    when(req.getParameter("Descrizione")).thenReturn("descrizione1");
    when(req.getParameter("Numero Posti")).thenReturn("3");
    when(req.getParameter("Sede")).thenReturn("sede1");
    when(req.getParameter("Tipo")).thenReturn("tipo1");
    when(req.getParameter("Responsabile")).thenReturn("responsabile1");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(ta);
    when(req.getSession().getAttribute("tirociniTutor")).thenReturn(tirocini);
    when(req.getSession().getAttribute("tirocinioModifica")).thenReturn(oldTirocinio);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() throws IOException {
        new ModificaTirocinio().doPost(req, res);
  }

  @Test
  public void testModificaTirocinio() {
  }

}
