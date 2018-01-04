package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class ModificaInformazioniAccountTest extends Mockito {
  private HttpServletRequest req;
  private HttpServletResponse res;
  private Studente oldStu;
  private Studente newStu;
  private TutorAccademico oldTutor;
  private TutorAccademico newTutor;
  private ArrayList<Studente> studenti;
  private ArrayList<TutorAccademico> tutor;
  private String email;

  @Before
  public void setUp() throws Exception {
    req = mock(HttpServletRequest.class);
    res = mock(HttpServletResponse.class);
    oldStu = new Studente("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    oldTutor = new TutorAccademico("a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a");
    tutor = new ArrayList<>();
    tutor.add(oldTutor);
    studenti = new ArrayList<>();
    studenti.add(oldStu);
    when(req.getParameter("codiceFiscale")).thenReturn("a");
    when(req.getParameter("nome")).thenReturn("a");
    when(req.getParameter("cognome")).thenReturn("a");
    when(req.getParameter("luogoNascita")).thenReturn("a");
    when(req.getParameter("dataNascita")).thenReturn("a");
    when(req.getParameter("residenza")).thenReturn("b");
    when(req.getParameter("via")).thenReturn("a");
    when(req.getParameter("sesso")).thenReturn("a");
    when(req.getParameter("telefono")).thenReturn("a");
    when(req.getParameter("email")).thenReturn("a");
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    HttpSession session = mock(HttpSession.class);
    if (session.getAttribute("currentSessionUser") instanceof Studente) {
      String codFisc = req.getParameter("codiceFiscale");
      newStu.setCodiceFiscale(codFisc);
      String nome = req.getParameter("nome");
      newStu.setNome(nome);
      String cogn = req.getParameter("cognome");
      newStu.setCognome(cogn);
      String luogNasc = req.getParameter("luogoNascita");
      newStu.setLuogoNascita(luogNasc);
      String dataNasc = req.getParameter("dataNascita");
      newStu.setDataNascita(dataNasc);
      String res = req.getParameter("residenza");
      newStu.setResidenza(res);
      String via = req.getParameter("via");
      newStu.setVia(via);
      String sesso = req.getParameter("sesso");
      newStu.setSesso(sesso);
      String tel = req.getParameter("telefono");
      newStu.setTelefono(tel);
      email = req.getParameter("email");
      newStu.setEmail(email);

      testModificaProfiloStudente();
    }
    
    if (session.getAttribute("currentSessionUser") instanceof TutorAccademico) {
      String codFisc = req.getParameter("codiceFiscale");
      newTutor.setCodiceFiscale(codFisc);
      String nome = req.getParameter("nome");
      newTutor.setNome(nome);
      String cogn = req.getParameter("cognome");
      newTutor.setCognome(cogn);
      String luogNasc = req.getParameter("luogoNascita");
      newTutor.setLuogoNascita(luogNasc);
      String dataNasc = req.getParameter("dataNascita");
      newTutor.setDataNascita(dataNasc);
      String res = req.getParameter("residenza");
      newTutor.setResidenza(res);
      String via = req.getParameter("via");
      newTutor.setVia(via);
      String sesso = req.getParameter("sesso");
      newTutor.setSesso(sesso);
      String tel = req.getParameter("telefono");
      newTutor.setTelefono(tel);
      email = req.getParameter("email");
      newTutor.setEmail(email);

      testModificaProfiloTutor();
    }
  }

  @Test
  public void testModificaProfiloStudente() {
    for (Studente stu : studenti) {
      if (stu.getEmail().equals(email)) {
        stu = newStu;
        assertTrue(true);
      }
    }
  }

  @Test
  public void testModificaProfiloTutor() {
    for (TutorAccademico tu : tutor) {
      if (tu.getEmail().equals(email)) {
        tu = newTutor;
      }
    }
  }

}
