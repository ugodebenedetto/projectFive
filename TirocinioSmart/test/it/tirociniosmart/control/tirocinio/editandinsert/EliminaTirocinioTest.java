package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
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

public class EliminaTirocinioTest extends Mockito {
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
  Tirocinio t, tirocinio;
  TutorAccademico ta;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    ta = new TutorAccademico("tutor@mail.it","","","","","","","","","","","","");
    
    tirocini = new ArrayList<Tirocinio>();
    producer = FactoryProducer.getIstance();
    tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tirocini = tiroc.findTirocinioForTutorAccademico(ta.getEmail());
    t = new Tirocinio("Titoloold", "Obiettiviold", "Descrizioneold",
      5, 1, ta, "Sedeold", "Tipoold", "Responsabileold");
    tirocinio = new Tirocinio();
    if(tirocini == null){
      tirocini = new ArrayList<Tirocinio>();
      tirocini.add(t);
    }
    
    when(req.getParameter("id")).thenReturn("1");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("tirociniTutor")).thenReturn(tirocini);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() 
      throws IOException, ServletException {
        new EliminaTirocinio().doGet(req, res);
  }

  @Test
  public void testEliminaTirocinio() {
  }

}
