/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;

public class VisualizaInfoTirociniTest extends Mockito{
  private HttpServletRequest request;
  private HttpServletResponse response;
  private Tirocinio tirocinio;
  private HashMap<Integer, Studente> studenti;
  private ArrayList<Studente> tirocinanti;
  private HashMap<Integer, Tirocinio> tirocini;
  private int id;

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    tirocinio = new Tirocinio();
    
    when(request.getParameter("id")).thenReturn("1");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    id = Integer.parseInt(request.getParameter("id"));
    
    assertEquals(id, 1);
    
    testVisualizzaTirocinio();
    if (tirocinio != null){
      testVisualizzaTirocinanti();
    }
  }

  @Test
  public void testVisualizzaTirocinanti() {
    studenti = new HashMap<Integer,Studente>();
    Iterator it = studenti.entrySet().iterator();
    Studente s = null;
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      RichiestaTirocinio singleRequest = (RichiestaTirocinio) pair.getValue();
      if ((singleRequest.getStato() == "richiestaAccettata")
          && (singleRequest.getTirocinio().getTutor() == tirocinio.getTutor())) {
        tirocinanti.add(singleRequest.getRichiedente());
      }
    }
  }

  @Test
  public void testVisualizzaTirocinio() {
    tirocini = new HashMap<Integer,Tirocinio>();
    if (tirocini.get(id) != null) {
      assertTrue(true);
    } else {
      assertTrue(true);
    }
  }

}
