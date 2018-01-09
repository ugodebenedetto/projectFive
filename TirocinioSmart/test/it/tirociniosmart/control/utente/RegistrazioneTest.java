package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.UtenteDAOFactory;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;

public class RegistrazioneTest extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;

  private String email;
  private String tipo;
  String codiceFiscale;
  String nome;
  String cognome;
  String luogoNascita;
  String dataNascita;
  String password;
  String residenza;
  String via;
  String sesso;
  String telefono;
  String matricola;
  String tipoLaurea;
  String codiceDocente;
  String dipartimento;

  Studente stu;
  TutorAccademico tutor;


  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache s = new StartupCache();


    when(req.getParameter("email")).thenReturn("claudione");
    when(req.getParameter("tipo")).thenReturn("studente");

    when(req.getParameter("codiceFiscale")).thenReturn("dddddddddddddddd");
    when(req.getParameter("nome")).thenReturn("pippoo");
    when(req.getParameter("cognome")).thenReturn("pippoo");
    when(req.getParameter("luogoNascita")).thenReturn("quaaaaaaaa");
    when(req.getParameter("dataNascita")).thenReturn("1998-05-05");
    when(req.getParameter("password")).thenReturn("aaaaaaaa");
    when(req.getParameter("residenza")).thenReturn("quiquoqua");
    when(req.getParameter("via")).thenReturn("Via Roma, 125");
    when(req.getParameter("sesso")).thenReturn("Maschio");
    when(req.getParameter("telefono")).thenReturn("3333333333");
    when(req.getParameter("matricola")).thenReturn("1111111112");
    when(req.getParameter("tipoLaurea")).thenReturn("triennale");
    when(req.getParameter("codiceDocente")).thenReturn("1111111112");
    when(req.getParameter("dipartimento")).thenReturn("informatica");


  }

  @After
  public void tearDown() throws Exception {
    String sqlStudente = "DELETE FROM `mydb`.`studente` " + "WHERE `email`=?;";

    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement stStudente = con.prepareStatement(sqlStudente);) {
      stStudente.setString(1, email);
      stStudente.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }

  }


  @Test
  public void testDoPostHttpServletRequestHttpServletResponse()
      throws ServletException, IOException, StartupCacheException {
    codiceFiscale = req.getParameter("codiceFiscale");
    nome = req.getParameter("nome");
    cognome = req.getParameter("cognome");
    luogoNascita = req.getParameter("luogoNascita");
    dataNascita = req.getParameter("dataNascita");
    password = req.getParameter("password");
    residenza = req.getParameter("residenza");
    via = req.getParameter("via");
    sesso = req.getParameter("sesso");
    telefono = req.getParameter("telefono");
    matricola = req.getParameter("matricola");
    tipoLaurea = req.getParameter("tipoLaurea");

    new Registrazione().doPost(req, res);

    email = req.getParameter("email");
    tipo = req.getParameter("tipo");



    new Registrazione().controllaEsistenzaUser(email, tipo);
    stu = new Studente(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita, password,
        sesso, residenza, via, telefono, matricola, tipoLaurea);
    new Registrazione().registraStudente(stu);

    /*new Registrazione().controllaEsistenzaUser(email, "tutorAccademico");
    codiceDocente = req.getParameter("codiceDocente");
    dipartimento = req.getParameter("dipartimento");
    tutor = new TutorAccademico(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita,
        password, sesso, residenza, via, telefono, dipartimento, codiceDocente);
    new Registrazione().registraTutor(tutor);*/

  }

  @Test
  public void testControllaEsistenzaUser()
      throws ServletException, IOException, StartupCacheException {

  }

  @Test
  public void testRegistraStudente() {}

  @Test
  public void testRegistraTutor() throws StartupCacheException {

  }

}
