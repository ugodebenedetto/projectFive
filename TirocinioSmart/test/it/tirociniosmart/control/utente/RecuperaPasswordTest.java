package it.tirociniosmart.control.utente;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RecuperaPasswordTest {
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);

  }

  @After
  public void tearDown() throws Exception {
    new RecuperaPassword().doGet(req, res);
  }

  @Test
  public void testDoGetHttpServletRequestHttpServletResponse() {
    new RecuperaPassword().doPost(req, res);
  }

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {
    assertTrue(true);
  }

}
