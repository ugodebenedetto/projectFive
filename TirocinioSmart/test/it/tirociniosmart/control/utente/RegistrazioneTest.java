package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class RegistrazioneTest extends Mockito {
  private HttpServletRequest req;
  private HttpServletResponse res;
  private String email;
  private String tipo;
  private Studente studente1;
  private Studente studente2;
  private HashMap<String, Studente> studenti;
  private TutorAccademico tutor1;
  private TutorAccademico tutor2;
  private HashMap<String, TutorAccademico> tutors;  
  private boolean esiste;


  @Before
  public void setUp() throws Exception {
    req = mock(HttpServletRequest.class);
    res = mock(HttpServletResponse.class);
    studente1 = new Studente("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    tutor1 = new TutorAccademico("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    tutors = new HashMap<>();
    tutors.put("a", tutor1);
    studenti = new HashMap<>();
    studenti.put("a", studente1);
    when(req.getParameter("codiceFiscale")).thenReturn("b");
    when(req.getParameter("nome")).thenReturn("b");
    when(req.getParameter("cognome")).thenReturn("b");
    when(req.getParameter("luogoNascita")).thenReturn("b");
    when(req.getParameter("dataNascita")).thenReturn("b");
    when(req.getParameter("residenza")).thenReturn("b");
    when(req.getParameter("via")).thenReturn("b");
    when(req.getParameter("sesso")).thenReturn("b");
    when(req.getParameter("telefono")).thenReturn("b");
    when(req.getParameter("email")).thenReturn("b");
    when(req.getParameter("tipo")).thenReturn("studente");

  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    tipo = req.getParameter("tipo");
    email = req.getParameter("email");
    testControllaEsistenzaUser();
    if (!esiste) {
      String codiceFiscale = req.getParameter("codiceFiscale");
      String nome = req.getParameter("nome");
      String cognome = req.getParameter("cognome");
      String luogoNascita = req.getParameter("luogoNascita");
      String dataNascita = req.getParameter("dataNascita");
      String residenza = req.getParameter("residenza");
      String via = req.getParameter("via");
      String sesso = req.getParameter("sesso");
      String telefono = req.getParameter("telefono");
      String password = req.getParameter("password");

      if (tipo.equals("studente")) {

        String matricola = req.getParameter("matricola");
        String tipoLaurea = req.getParameter("tipoLaurea");
        studente2 = new Studente(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita,
            password, sesso, residenza, via, telefono, matricola, tipoLaurea);
        testRegistraStudente();

      } else if (tipo.equals("tutor")) {
        String dipartimento = req.getParameter("dipartimento");
        String codiceDocente = req.getParameter("codiceDocente");
        tutor2 = new TutorAccademico(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita,
            password, sesso, residenza, via, telefono, dipartimento, codiceDocente);
        testRegistraTutor();
      }
    }
  }

  @Test
  public void testControllaEsistenzaUser() {
    String stu = "studente";
    String tutor = "tutor";
    if (stu.equals(tipo)) {
      if (studenti.get(email) != null) {
        esiste = true;
        assertTrue(true);
      }
    } else if (tutor.equals(tipo)) {
      if (tutors.get(email) != null) {
        esiste = true;
        assertTrue(true);
      }
    }
  }

  @Test
  public void testRegistraStudente() {
    studenti.put(email, studente2);
  }

  @Test
  public void testRegistraTutor() {
    tutors.put(email, tutor2);
  }

}
