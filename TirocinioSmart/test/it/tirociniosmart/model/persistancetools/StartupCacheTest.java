package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;

public class StartupCacheTest {

  ProxyUtenteDAO dao = new ProxyUtenteDAO();
  DAOCache cache = DAOCache.getIstance();
  private static final String email = "example@live.it";
  private static final String secondEmail = "example1@live.it";
  private static final String updateEmail = "exampleUpdate@live.it";

  @Before
  public void setUp() throws Exception {

    StartupCache cache = new StartupCache();
    Studente studente = new Studente();
    studente.setNome("Stuente");
    studente.setEmail(email);

    dao.insertStudente(studente);



  }


  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    String sql = "DELETE FROM `mydb`.`studente` " + "WHERE `email`=?;";
    DBManager manager = DBManager.getIstance();
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      st.executeUpdate();
      st.setString(1, updateEmail);
      st.executeUpdate();

    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }


  }

  @Test
  public void testSetCacheStudente() throws StartupCacheException {
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

}
