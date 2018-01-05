package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VisualizzaFeedbackTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Feedback> feedback;
  private Feedback f1;
  private Feedback f2;



  /**
   * setup.
   * 
   * @throws Exception eccezione
   */
  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    feedback = new ArrayList<Feedback>();
    f2 = new Feedback(
        new Tirocinio("prova", "prova", "", 5, 0,
            new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", ""), "", "", ""),
        new Studente("prova@prova.it", "asdfgh5", "prova", "prova", "prova", "prova", "prova", "M",
            "r", "", "", "", ""),
        "5/10/1999/", 5, "ciao");
    f1 = new Feedback(
      new Tirocinio("prova", "prova", "", 5, 0,
          new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", ""), "", "", ""),
      new Studente("prova@prova.it", "asdfgh5", "prova", "prova", "prova", "prova", "prova", "M",
          "r", "", "", "", ""),
      "5/10/1999/", 5, "ciao");
    feedback.add(f2);
    feedback.add(f1);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    testVisualizzaFeedback();
  }


  @Test
  public void testVisualizzaFeedback() {
    assertEquals(feedback.get(0), f2);
    assertEquals(feedback.get(1), f1);

  }

}
