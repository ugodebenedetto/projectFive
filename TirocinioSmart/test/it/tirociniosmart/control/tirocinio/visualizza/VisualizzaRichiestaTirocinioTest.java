/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.visualizza;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;

public class VisualizzaRichiestaTirocinioTest extends Mockito{
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<RichiestaTirocinio> richieste;
  private ArrayList<Tirocinio> tirocini;
  
  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    richieste = new ArrayList<RichiestaTirocinio>();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    testVisualizzaStatoRichiestaTirocinioStudente();
    testVisualizzaStatoRichiestaTirocinioTutor();
  }


  @Test
  public void testVisualizzaStatoRichiestaTirocinioStudente() {
    
  }
  
  @Test
  public void testVisualizzaStatoRichiestaTirocinioTutor() {
    tirocini = new ArrayList<Tirocinio>();
    richieste = new ArrayList<RichiestaTirocinio>();
    for (Tirocinio t : tirocini) {
      RichiestaTirocinio r = new RichiestaTirocinio();
      richieste.add(r);
      for (RichiestaTirocinio rich : richieste) {
        if (rich.getStato() != "inFaseDiApprovazione") {
          richieste.remove(r);
        }
      }
    }
  }
}
