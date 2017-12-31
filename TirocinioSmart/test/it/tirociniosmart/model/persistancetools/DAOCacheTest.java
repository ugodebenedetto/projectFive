package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DAOCacheTest {

  private DAOCache dataSource;


  @Before
  public void setUp() throws Exception {
    dataSource = DAOCache.getIstance();
  }

 

  @Test
  public void testGetIstance() {
    DAOCache dataSource2 = null;

    dataSource2 = DAOCache.getIstance();

    assertSame(dataSource2, dataSource);
    assertNotNull(dataSource2);
    assertNotNull(dataSource);
  }
}
