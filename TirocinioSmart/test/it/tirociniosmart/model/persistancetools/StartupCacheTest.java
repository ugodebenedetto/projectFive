package it.tirociniosmart.model.persistancetools;

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

import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class StartupCacheTest {

  static ProxyUtenteDAO dao = new ProxyUtenteDAO();
  static DAOCache cache = DAOCache.getIstance();
  static Didattica secondDidattica = new Didattica();

  private static final String email = "example@live.it";
  private static final String secondEmail = "example1@live.it";
  private static final String updateEmail = "exampleUpdate@live.it";

  @BeforeClass
  public static void setUp() throws Exception {
    StartupCache cache1 = new StartupCache();

    Didattica didatticaI = new Didattica();
    secondDidattica = new Didattica();
    secondDidattica.setEmail(secondEmail);
    didatticaI.setEmail(email);
    String sql = "INSERT INTO `mydb`.`didattica` (`email`) VALUES (?);";
    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      st.executeUpdate();
      st.setString(1, secondEmail);

      cache.updateDidattica("insert", didatticaI.getEmail(), didatticaI);
      cache.updateDidattica("insert", secondDidattica.getEmail(), secondDidattica);

    } catch (

    SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }
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
      stStudente.setString(1, email);
      stStudente.executeUpdate();
      stStudente.setString(1, updateEmail);
      stStudente.executeUpdate();
      stTutor.setString(1, email);
      stTutor.executeUpdate();
      stTutor.setString(1, updateEmail);
      stTutor.executeUpdate();

      stDidattica.setString(1, email);
      stDidattica.executeUpdate();


    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }

  }

  @Test
  public void testSetCacheStudente() throws StartupCacheException {
    Studente studenteI = new Studente();
    studenteI.setEmail(email);
    dao.insertStudente(studenteI);
    HashMap<String, Studente> tmp = cache.getStudente();
    assertNotNull(tmp.get(email));
    Studente secondStudent = new Studente();
    secondStudent.setEmail(secondEmail);
    dao.insertStudente(secondStudent);
    tmp = cache.getStudente();
    assertNotNull(tmp.get(secondEmail));
    Studente updateStudent = new Studente();
    updateStudent.setEmail(updateEmail);
    dao.updateStudente(updateStudent, secondStudent);
    tmp = cache.getStudente();
    assertNotNull(tmp.get(updateEmail));



  }

  @Test
  public void testSetCacheTutorAccademico() throws StartupCacheException {

    TutorAccademico tutorI = new TutorAccademico();
    tutorI.setEmail(email);
    dao.inserTutorAccademico(tutorI);
    HashMap<String, TutorAccademico> tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(email));
    TutorAccademico secondTutor = new TutorAccademico();
    secondTutor.setEmail(secondEmail);
    dao.inserTutorAccademico(secondTutor);
    tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(secondEmail));
    TutorAccademico updateTutor = new TutorAccademico();
    updateTutor.setEmail(updateEmail);
    dao.updateTutorAccademico(updateTutor, secondTutor);
    tmp = cache.getTutorAccademico();
    assertNotNull(tmp.get(updateEmail));

  }

  @Test
  public void testSetCacheDidattica() throws StartupCacheException {

    HashMap<String, Didattica> tmp = cache.getDidattica();
    assertNotNull(tmp.get(email));
    tmp = cache.getDidattica();
    assertNotNull(tmp.get(secondEmail));
    Didattica updateDidattica = new Didattica();
    updateDidattica.setEmail(updateEmail);
    dao.updateDidattica(updateDidattica, secondDidattica);
    tmp = cache.getDidattica();
    assertNotNull(tmp.get(updateEmail));

  }

}
