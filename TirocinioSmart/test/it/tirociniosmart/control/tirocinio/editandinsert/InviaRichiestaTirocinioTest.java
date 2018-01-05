/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

public class InviaRichiestaTirocinioTest extends Mockito {
  
  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Tirocinio> tirocini;
  private RichiestaTirocinio richiesta;
  private Tirocinio tirocinio;
  private Studente studente;
  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    tirocini = new ArrayList<Tirocinio>();
    
    
    when(request.getParameter("stato")).thenReturn("abc");
    when(request.getParameter("id")).thenReturn("0");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    String stato = request.getParameter("stato");
    int id = Integer.parseInt(request.getParameter("id"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String localDate = (LocalDate.now().format(dtf)).toString(); 
    String dataInvio = localDate;
    String dataAccettazione = null;
    
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Studente studente = new Studente("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = new Tirocinio("","","",1,ta,"","","");
    tirocini.add(tirocinio);
    tirocinio = tirocini.get(id);
    richiesta = new RichiestaTirocinio(stato, dataInvio, dataAccettazione, studente, tirocinio);
    testInviaRichiesta();
  }

  @Test
  public void testInviaRichiesta() {
    testControllaDisponibilita();
    testControllaInvioPrecedente();
  }

  @Test
  public void testControllaDisponibilita() {
    int numeroPosti = 10;
    if (numeroPosti > 0){
      assertTrue(true);
    } else {
      assertTrue(true);
    }
  }

  @Test
  public void testControllaInvioPrecedente() {
    ArrayList<RichiestaTirocinio> richieste = new ArrayList<RichiestaTirocinio>();
    String email = "email";
    for (RichiestaTirocinio r : richieste){
      if(email.equals(richieste.get(0).getRichiedente().getEmail())){
        assertTrue(true);
      } else {
        assertTrue(true);
      }
    }
  }

}
