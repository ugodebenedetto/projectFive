/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.TutorAccademico;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;


public class InserisciTirocinioTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Tirocinio> tirocini;
  private Tirocinio tirocinio;
  
  
  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    tirocini = new ArrayList<Tirocinio>();
    when(request.getParameter("nome")).thenReturn("titolo");
    when(request.getParameter("Obiettivi")).thenReturn("obiettivo1");
    when(request.getParameter("Descrizione")).thenReturn("descrizione1");
    when(request.getParameter("Numero Posti")).thenReturn("3");
    when(request.getParameter("Sede")).thenReturn("sede1");
    when(request.getParameter("Tipo")).thenReturn("tipo1");
    when(request.getParameter("Responsabile")).thenReturn("responsabile1");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    fail("Not yet implemented");
  }

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    
    String nome = request.getParameter("nome");
    String obiettivi = request.getParameter("Obiettivi");
    String descrizione = request.getParameter("Descrizione");
    int numPost = Integer.parseInt(request.getParameter("Numero Posti"));
    String sede = request.getParameter("Sede");
    String tipo = request.getParameter("Tipo");
    String responsabile = request.getParameter("Responsabile");
    
    assertEquals(nome, "titolo");
    assertEquals(obiettivi, "obiettivi1");
    assertEquals(descrizione, "descrizione1");
    assertEquals(numPost, 3);
    assertEquals(sede, "sede1");
    assertEquals(tipo, "tipo1");
    assertEquals(responsabile, "responsabile1");
    
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
      ta, sede, tipo, responsabile);
  }

  @Test
  public void testInserisciTirocinio() {
    tirocini.add(tirocinio);
    assertEquals(tirocinio, tirocini.get(0));
  }

}
