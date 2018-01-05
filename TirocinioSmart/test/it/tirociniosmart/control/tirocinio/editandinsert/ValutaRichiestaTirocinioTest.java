/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

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
import it.tirociniosmart.model.utente.TutorAccademico;

public class ValutaRichiestaTirocinioTest extends Mockito {
  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<RichiestaTirocinio> richieste;
  private Tirocinio tirocinio;
  private RichiestaTirocinio richiesta;
  private TutorAccademico ta;
  private HashMap<Integer, Studente> studenti;
  

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    richieste = new ArrayList<RichiestaTirocinio>();
    
    when(request.getParameter("stato")).thenReturn("stato1");
    when(request.getParameter("dataric")).thenReturn("datarichiesta1");
    when(request.getParameter("datarisp")).thenReturn("datarisposta1");
    when(request.getParameter("email")).thenReturn("email1");
    
    when(request.getParameter("titolo")).thenReturn("titolo1");
    when(request.getParameter("obiettivi")).thenReturn("obiettivi1");
    when(request.getParameter("descrizione")).thenReturn("descrizione1");
    when(request.getParameter("numpost")).thenReturn("3");
    when(request.getParameter("sede")).thenReturn("sede1");
    when(request.getParameter("tipo")).thenReturn("tipo1");
    when(request.getParameter("responsabile")).thenReturn("responsabile1");
    
    when(request.getParameter("return")).thenReturn("true");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    String stato = request.getParameter("stato");
    String dataRichiesta = request.getParameter("dataric");
    String dataRisposta = request.getParameter("datarisp");
    String email = request.getParameter("email");
    
    studenti = new HashMap<Integer,Studente>();
    Iterator it = studenti.entrySet().iterator();
    Studente s = null;
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      s = (Studente) pair.getValue();
      if (s.getEmail().equals(email)) {
        break;
      }
    }
    Studente studente = s;
    String nome = request.getParameter("titolo");
    String obiettivi = request.getParameter("obiettivi");
    String descrizione = request.getParameter("descrizione");
    int numPost = Integer.parseInt(request.getParameter("numpost"));
    String sede = request.getParameter("sede");
    String tipo = request.getParameter("tipo");
    String responsabile = request.getParameter("responsabile");
    tirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
      ta, sede, tipo, responsabile);
    richiesta = new RichiestaTirocinio(stato,dataRichiesta, dataRisposta, studente, tirocinio);
    String r = request.getParameter("return");
    if (r.equals("true")){
      testAccettaRichiestaTirocinio();
      richieste.remove(richiesta);
    } else {
      testRifiutaRichiestaTirocinio();
      richieste.remove(richiesta);
    }
  }

  @Test
  public void testAccettaRichiestaTirocinio() {
    
  }

  @Test
  public void testRifiutaRichiestaTirocinio() {

  }

}
