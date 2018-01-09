package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckParametersRegistrazioneTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testCheckParameters() {
    new Registrazione().checkParameters("dddddddddddddddd", "pippo", "pippoo", "quaaaaaaaa",
        "1998-05-035", "aaaaaaaa", "quiquoqua", "Via Roma, 125", "3333333333");
    new Registrazione().checkParameters("dddddddddddddd?d", "pippo!!", "pippoo??", "quaaaaaaaa?",
        "1998-05-03", "aaaaaaaa--", "quiquoqua?", "Via Roma, 125?", "333333333?");
  }

  @Test
  public void testCheckEmail() {
    new Registrazione().checkEmail("aaaaa!!");
    new Registrazione().checkEmail("a");
  }

}
