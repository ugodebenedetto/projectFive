package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DBManagerTest {

  private DBManager dataSource;
  Connection con1;
  Connection con2;
  

  // inizializziamo il datasource
  @Before
  public void setUp() throws Exception {

    dataSource = DBManager.getIstance();

  }

  // Testiamo che l'istanza di singleton sia unica.
  @Test
  public void testGetIstance() {
    DBManager dataSource2=null;
    try {
      dataSource2 = DBManager.getIstance();
    
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      String errore = e.getMessage();
      fail(errore);
    }
    assertSame(dataSource2, dataSource);
    assertNotNull(dataSource2);
    assertNotNull(dataSource);

  }

  // Testiamo che la connessione non sia null e non la stessa e la chiusura.
  @Test
  public void testGetConnection() {
    try {

      con1 = dataSource.getConnection();
      con2 = dataSource.getConnection();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      String errore = e.getMessage();
      fail(errore);
    }

    assertNotNull(con1);
    assertNotNull(con2);
    assertNotSame(con1, con2);
    try {
      con1.close();
      con2.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      String errore = e.getMessage();
      fail(errore);

    }

  }
  

  

}
