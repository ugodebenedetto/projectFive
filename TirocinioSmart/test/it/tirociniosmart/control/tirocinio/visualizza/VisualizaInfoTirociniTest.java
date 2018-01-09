/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

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
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;

public class VisualizaInfoTirociniTest extends Mockito{
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
  int id;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    
    Tirocinio tirocinio = new Tirocinio("","","",5,1,null,"","","");
    tirociniHash = new HashMap<Integer, Tirocinio>();
    tirociniList = new ArrayList<Tirocinio>();
    tirociniHash.put(1, tirocinio);
    tirociniList.add(tirocinio);
    
    
    when(req.getParameter("id")).thenReturn("1");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("tirociniTutor")).thenReturn(tirociniList);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException {
    new VisualizaInfoTirocini().doGet(req, res);
    when(req.getParameter("id")).thenReturn(null);
    new VisualizaInfoTirocini().doGet(req, res);
    
  }

  @Test
  public void testVisualizzaTirocinanti() {
  }

  @Test
  public void testVisualizzaTirocinio() {
  }

}
