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

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    tirocini = new ArrayList<Tirocinio>();
    
    
    when(request.getParameter("stato")).thenReturn("inFaseDiApprovazione");
    when(request.getParameter("id")).thenReturn("101");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    fail("Not yet implemented");
  }

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    String stato = request.getParameter("stato");
    int id = Integer.parseInt(request.getParameter("id"));
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String localDate = (LocalDate.now().format(dtf)).toString(); 
    String dataInvio = localDate;
    String dataAccettazione = null;
    
    Studente studente = new Studente("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinio = tirocini.get(id);
    richiesta = new RichiestaTirocinio(stato, dataInvio, dataAccettazione, studente, tirocinio);
    testInviaRichiesta(richiesta, studente);
  }

  @Test
  public void testInviaRichiesta(RichiestaTirocinio richiesta, Studente studente) {
    Tirocinio t = richiesta.getTirocinio();
    if (testControllaDisponibilita(t) && testControllaInvioPrecedente(richiesta, studente)) {
      System.out.println("Richiesta Inviata con successo");
    } else {
      System.out.println("Richiesta non inviata");
    }
  }

  @Test
  public boolean testControllaDisponibilita(Tirocinio tirocinio) {
    if(tirocinio.getNumPost()>0) {
      return true;
    } else {
      return false;
    }
  }

  @Test
  public boolean testControllaInvioPrecedente(RichiestaTirocinio richiesta, Studente studente) {
    return true;
  }

}
