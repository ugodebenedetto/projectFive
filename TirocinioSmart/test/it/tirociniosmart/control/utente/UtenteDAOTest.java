package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;
import it.tirociniosmart.model.utente.UtenteDAO;


public class UtenteDAOTest {
  static UtenteDAO dao;
  public static final String email1 = "email1Example@studente.it";
  private static final String email2 = "email2Example@studente.it";
  private static final String emailUpdate = "emailUpdate@studente.it";
  Studente studente1;
  Studente studente2;
  Studente studenteUpdate;
  TutorAccademico tutor1;
  TutorAccademico tutor2;
  TutorAccademico tutorUpdate;
  Didattica didattica1;
  Didattica didattica2;
  Didattica didatticaUpdate;
  DAOCache cache = DAOCache.getIstance();



  @BeforeClass
  public static void setUp() throws Exception {
    dao = (ProxyUtenteDAO) new ProxyUtenteDAO();
    StartupCache x = new StartupCache();



  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    String sqlStudente = "DELETE FROM `mydb`.`studente` " + "WHERE `email`=?;";
    String sqlTutor = "DELETE FROM `mydb`.`tutor accademico` " + "WHERE `email`=?;";
    String sqlDidattica = "DELETE FROM `mydb`.`didattica` " + "WHERE `email`=?;";

    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement stStudente = con.prepareStatement(sqlStudente);
        PreparedStatement stTutor = con.prepareStatement(sqlTutor);
        PreparedStatement stDidattica = con.prepareStatement(sqlDidattica);) {
      stStudente.setString(1, email1);
      stStudente.executeUpdate();
      stStudente.setString(1, emailUpdate);
      stStudente.executeUpdate();

      stTutor.setString(1, email1);
      stTutor.executeUpdate();
      stTutor.setString(1, emailUpdate);
      stTutor.executeUpdate();

      stDidattica.setString(1, email1);
      stDidattica.executeUpdate();
      stDidattica.setString(1, emailUpdate);
      stDidattica.executeUpdate();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }

  }


  @Test
  public void StudenteCRUD() throws StartupCacheException {
    this.testInsertStudente();
    this.testUpdateStudente();
    this.testSelectStudente();
    this.testFindStudente();
  }

  @Test
  public void TutorCRUD() throws StartupCacheException {
    this.testInserTutorAccademico();
    this.testUpdateTutorAccademico();
    this.testSelectTutorAccademico();
    this.testFindTutorAccademico();
  }

  @Test
  public void DidatticaCRUD() throws SQLException, StartupCacheException {
    this.insertDidattica();
    this.testUpdateDidattica();
    this.testSelectDidattica();
    this.testFindDidattica();
  }

  public void testInsertStudente() throws StartupCacheException {

    studente1 = new Studente();
    studente2 = new Studente();
    studente1.setEmail(email1);
    studente2.setEmail(email2);
    dao.insertStudente(studente1);
    dao.insertStudente(studente2);

  }


  public void testUpdateStudente() throws StartupCacheException {
    studenteUpdate = new Studente();
    studenteUpdate.setEmail(emailUpdate);

    dao.updateStudente(studenteUpdate, studente2);
  }

  public void testInserTutorAccademico() throws StartupCacheException {

    tutor1 = new TutorAccademico();
    tutor2 = new TutorAccademico();

    tutor1.setEmail(email1);
    tutor2.setEmail(email2);
    dao.inserTutorAccademico(tutor1);
    dao.inserTutorAccademico(tutor2);

  }

  public void testUpdateTutorAccademico() throws StartupCacheException {
    tutorUpdate = new TutorAccademico();
    tutorUpdate.setEmail(emailUpdate);
    dao.updateTutorAccademico(tutorUpdate, tutor2);

  }

  public void testUpdateDidattica() throws StartupCacheException {
    didatticaUpdate = new Didattica();
    didatticaUpdate.setEmail(emailUpdate);
    dao.updateDidattica(didatticaUpdate, didattica2);
  }


  public void testSelectStudente() {
    HashMap<String, Studente> tmp = dao.selectStudente();
    assertNotNull(tmp.get(email1));
    assertNotNull(tmp.get(emailUpdate));

  }

  public void testSelectTutorAccademico() {
    HashMap<String, TutorAccademico> tmp = dao.selectTutorAccademico();
    assertNotNull(tmp.get(email1));
    assertNotNull(tmp.get(emailUpdate));
  }

  public void testSelectDidattica() {
    HashMap<String, Didattica> tmp = dao.selectDidattica();
    assertNotNull(tmp.get(email1));

    assertNotNull(tmp.get(emailUpdate));
  }

  public void testFindStudente() {
    Studente findStudent = new Studente();
    findStudent.setEmail(email1);
    assertNotNull(dao.findStudente(findStudent));
    findStudent.setEmail(email2);
    assertNull(dao.findStudente(findStudent));
  }

  public void insertDidattica() throws SQLException, StartupCacheException {

    didattica1 = new Didattica();
    didattica1.setEmail(email1);
    didattica2 = new Didattica();
    didattica2.setEmail(email2);

    String sql = "INSERT INTO `mydb`.`didattica` (`email`) VALUES (?);";
    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email1);
      st.executeUpdate();
      DAOCache cache = DAOCache.getIstance();
      cache.updateDidattica("insert", didattica1.getEmail(), didattica1);
      st.setString(1, email2);
      st.executeUpdate();
      cache.updateDidattica("insert", didattica2.getEmail(), didattica2);

    } catch (

    SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }

  }

  public void testFindDidattica() {
    Didattica findDidattica = new Didattica();
    findDidattica.setEmail(email1);
    assertNotNull(dao.findDidattica(findDidattica));
    findDidattica.setEmail(email2);
    assertNull(dao.findDidattica(findDidattica));
  }


  public void testFindTutorAccademico() {
    TutorAccademico findTutor = new TutorAccademico();
    findTutor.setEmail(email1);
    assertNotNull(dao.findTutorAccademico(findTutor));
    findTutor.setEmail(email2);
    assertNull(dao.findTutorAccademico(findTutor));
  }

}
