package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckParametersLoginTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testCheckParameters() {
    new Login().checkParameters("a", "aaaaaaaaaaaaaaaaaaaaaaaaaa");
    new Login().checkParameters("222222", "xxxxxxxx");
    new Login().checkParameters("aaaaaa!!", "aaaaaaaa");
    new Login().checkParameters("aaaaaaaa", "aaaaaff4!");
  }

}
