package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.utente.Didattica;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;



public class VisualizzaListaAnnunciTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Annuncio> annunci;
  private Annuncio a1;
  private Annuncio a2;

  /**
   * setup.
   * 
   * @throws Exception eccezione
   */
  @Before
  public void setUp() throws Exception {

    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    annunci = new ArrayList<Annuncio>();
    a1 =
        new Annuncio(
            "prova1", new Didattica("prova@prova.it", "ADFF", "prova", "provaaa", "prova",
                "12/12/1111", "no", "m", "r", "via", "3455", false),
            "12/12/1200", "annuncio di prova 2", "prova");
    a2 =
        new Annuncio(
            "prova2", new Didattica("prova@prova.it", "ADFF", "prova", "provaaa", "prova",
                "12/12/1111", "no", "m", "r", "via", "3455", false),
            "12/12/1200", "annuncio di prova 3", "prova");
    annunci.add(a1);
    annunci.add(a2);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    testVisualizzaListaAnnuncio();
  }

  @Test
  public void testVisualizzaListaAnnuncio() {
    assertEquals(annunci.get(0), a1);
    assertEquals(annunci.get(1), a2);
  }

}
