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

import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.TutorAccademico;

public class VisualizzaListaTirociniTest extends Mockito {
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  private Tirocinio tirocinio;
  private HashMap<Integer, Tirocinio> tirocini;
  
  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    tirocini = new HashMap<Integer, Tirocinio>();
  }

  @After
  public void tearDown() throws Exception {}

  
  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() throws IOException {
    
  }

  @Test
  public void testVisualizzaListaTirocinio() {
    ArrayList<Tirocinio> listaTirocini = new ArrayList<Tirocinio>();
    Iterator<Entry<Integer, Tirocinio>> it = tirocini.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      Tirocinio singleTirocinio = (Tirocinio) pair.getValue();
      listaTirocini.add(singleTirocinio);
    }
  }

}
