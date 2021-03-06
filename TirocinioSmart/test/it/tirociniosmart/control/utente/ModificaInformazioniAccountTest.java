package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class ModificaInformazioniAccountTest extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;

  private Studente oldStu;
  private Studente newStu;
  private TutorAccademico oldTutor;
  private TutorAccademico newTutor;
  private String email;

  FactoryProducer producer;
  AbstractFactory utenteFactory;
  UtenteDAO utente;
  HashMap<String, Studente> studenti;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

    producer = FactoryProducer.getIstance();
    utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();

    when(req.getParameter("codiceFiscale")).thenReturn("dddddddddddddddd");
    when(req.getParameter("nome")).thenReturn("pippoo");
    when(req.getParameter("cognome")).thenReturn("pippoo");
    when(req.getParameter("luogoNascita")).thenReturn("Quaa");
    when(req.getParameter("dataNascita")).thenReturn("1998-05-05");
    when(req.getParameter("residenza")).thenReturn("qui");
    when(req.getParameter("via")).thenReturn("Via Roma, 125");
    when(req.getParameter("sesso")).thenReturn("Maschio");
    when(req.getParameter("telefono")).thenReturn("3333333333");
    when(req.getSession()).thenReturn(session);
    email = "claudio@studenti.unisa.it";
    
    studenti = utente.selectStudente();
    if (studenti.get(email) != null) {
      oldStu = studenti.get(email);
    }
    newStu = new Studente();
    
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(oldStu);

    oldTutor = new TutorAccademico();
    newTutor = new TutorAccademico();
  }

  @After
  public void tearDown() throws Exception {
    req.getSession().setAttribute("currentSessionUser", null);
  }

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse()
      throws StartupCacheException, ServletException, IOException {
    new ModificaInformazioniAccount().doGet(req, res);

    if (req.getSession().getAttribute("currentSessionUser") instanceof Studente) {
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
      newStu.setMatricola(oldStu.getMatricola());
      newStu.setTipoLaurea(oldStu.getTipoLaurea());
      newStu.setEmail(oldStu.getEmail());
      newStu.setPassword(oldStu.getPassword());

      new ModificaInformazioniAccount().modificaProfiloStudente(newStu,
          oldStu);
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
  public void testModificaProfiloStudente() {}

  @Test
  public void testModificaProfiloTutor() throws StartupCacheException {
    new ModificaInformazioniAccount().modificaProfiloTutor(newTutor, oldTutor);
  }

}
