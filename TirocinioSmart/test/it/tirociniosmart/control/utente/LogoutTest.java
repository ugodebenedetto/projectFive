package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.utente.Studente;

public class LogoutTest extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  Studente stu;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();

    when(req.getSession()).thenReturn(session);
    stu = new Studente();
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(stu);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse()
      throws ServletException, IOException {
    new Logout().doGet(req, res);
    if (req.getSession().getAttribute("currentSessionUser") != null) {
      new Logout().logout(session);
    }

  }


  @Test
  public void testLogout() {}

}
