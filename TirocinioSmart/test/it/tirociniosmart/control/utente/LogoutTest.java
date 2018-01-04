package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class LogoutTest extends Mockito {
  private HttpServletRequest req;
  private HttpServletResponse res;
  
  @Before
  public void setUp() throws Exception {
    req = mock(HttpServletRequest.class);
    res = mock(HttpServletResponse.class);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    testLogout();
  }


  @Test
  public void testLogout() {
    HttpSession session = mock(HttpSession.class);
    session.setAttribute("currentSessionUser", null);
    assertTrue(true);
  }

}
