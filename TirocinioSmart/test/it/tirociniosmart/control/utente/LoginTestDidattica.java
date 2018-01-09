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

public class LoginTestDidattica extends Mockito {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  String email;
  String pass;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();

    Mockito.when(req.getParameter("email")).thenReturn("ddddd");
    Mockito.when(req.getParameter("password")).thenReturn("dddddddd");
    Mockito.when(req.getParameter("tipo")).thenReturn("didattica");
    Mockito.when(req.getSession()).thenReturn(session);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() throws ServletException, IOException {
    email = req.getParameter("email");
    pass = req.getParameter("pass");
    email = email + "@unisa.it";

    if (req.getParameter("tipo").equals("didattica")) {
      new Login().doPost(req, res);
      new Login().loginDidattica(email, pass);
      
    }
  }

  @Test
  public void testLoginDidattica() {}

}
