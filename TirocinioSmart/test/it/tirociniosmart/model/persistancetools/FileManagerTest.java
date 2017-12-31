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

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetIstance() {
    FileManager dataSource2 = null;

    dataSource2 = FileManager.getIstance();

    assertSame(dataSource2, dataSource);
    assertNotNull(dataSource2);
    assertNotNull(dataSource);
  }

  @Test
  public void testSaveFile() {
  }

  @Test
  public void testDeleteFile() {
    fail("Not yet implemented");
  }

}
