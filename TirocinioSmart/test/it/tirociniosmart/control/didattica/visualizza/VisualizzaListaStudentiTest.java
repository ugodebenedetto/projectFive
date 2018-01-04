package it.tirociniosmart.control.didattica.visualizza;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.utente.Studente;

public class VisualizzaListaStudentiTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Studente> studenti;
  private Studente s1;
  private Studente s2;

  /**
   * setup.
   * 
   * @throws Exception eccezione
   */
  @Before
  public void setUp() throws Exception {

    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    studenti = new ArrayList<Studente>();

    s1 = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "", "", "",
        "0512103456", "triennale");
    s2 = new Studente("prova", "prova", "prova", "cognome", "no", "12/12/12", "", "", "", "", "",
        "0512103457", "triennale");
    studenti.add(s1);
    studenti.add(s2);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    testVisualizzaListaStudenti();
  }


  @Test
  public void testVisualizzaListaStudenti() {
    assertEquals(studenti.get(0), s1);
    assertEquals(studenti.get(1), s2);
  }

}
