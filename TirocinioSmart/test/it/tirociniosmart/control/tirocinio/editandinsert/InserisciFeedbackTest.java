/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class InserisciFeedbackTest extends Mockito {
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  private Tirocinio tirocinio;
  private Feedback feedback;

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    //inserire tirocinio?
    
    when(request.getParameter("dataInvio")).thenReturn("2000/12/01");
    when(request.getParameter("valutazione")).thenReturn("79");
    when(request.getParameter("messages")).thenReturn("ciao");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    fail("Not yet implemented");
  }

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    String dataInvio = request.getParameter("dataInvio");
    int valutazione = Integer.parseInt(request.getParameter("valutazione"));
    String commento = request.getParameter("messages");
    
    assertEquals(dataInvio, "2000/12/01");
    assertEquals(valutazione, 79);
    assertEquals(commento, "ciao");
    
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Studente studente = new Studente("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = new Tirocinio("","","",10,ta,"","",""); 
    Feedback feedback = new Feedback(tirocinio, studente, dataInvio, valutazione, commento);
  }

  @Test
  public void testInserisciFeedback() {
    assertEquals(feedback, feedback); // OVVIO?
  }

}
