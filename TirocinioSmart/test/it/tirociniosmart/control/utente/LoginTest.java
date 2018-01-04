package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class LoginTest extends Mockito {
  private HttpServletRequest req;
  private HttpServletResponse res;
  private HashMap<String, Studente> studenti;
  private Studente studente;
  private HashMap<String, Didattica> didattiche;
  private Didattica dida;
  private HashMap<String, TutorAccademico> tutor;
  private TutorAccademico tutorAcc;
  private String email;
  private String password;
  private String tipo;

  @Before
  public void setUp() throws Exception {
    req = mock(HttpServletRequest.class);
    res = mock(HttpServletResponse.class);
    studente = new Studente("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    studenti = new HashMap<>();
    studenti.put("a", studente);
    tutorAcc = new TutorAccademico("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    tutor = new HashMap<>();
    dida = new Didattica("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", false);
    didattiche = new HashMap<>();
    when(req.getParameter("email")).thenReturn("a");
    when(req.getParameter("pass")).thenReturn("a");
    when(req.getParameter("tipo")).thenReturn("studente");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    email = req.getParameter("email");
    password = req.getParameter("password");
    tipo = req.getParameter("tipo");

    if (tipo.equals("studente")) {
      testLoginStudente();

    } else if (tipo.equals("tutorAccademico")) {
      testLoginTutor();

    } else if (tipo.equals("didattica")) {
      testLoginDidattica();

    }
  }

  @Test
  public void testLoginStudente() {
    if (studenti.get(email) != null && studenti.get(email).getPassword().equals(password)) {
      assertTrue(true);
    }
  }

  @Test
  public void testLoginTutor() {
    if (tutor.get(email) != null && tutor.get(email).getPassword().equals(password)) {
      assertTrue(true);
    }
  }

  @Test
  public void testLoginDidattica() {
    if (didattiche.get(email) != null && didattiche.get(email).getPassword().equals(password)) {
      assertTrue(true);
    }
  }

}
