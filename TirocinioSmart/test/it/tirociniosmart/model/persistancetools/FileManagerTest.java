package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileManagerTest {
  private FileManager dataSource;


  @Before
  public void setUp() throws Exception {
    dataSource = FileManager.getIstance();
  }

 

  @Test
  public void testGetIstance() {
    FileManager dataSource2 = null;

    dataSource2 = FileManager.getIstance();

    assertSame(dataSource2, dataSource);
    assertNotNull(dataSource2);
    assertNotNull(dataSource);
  }

}
