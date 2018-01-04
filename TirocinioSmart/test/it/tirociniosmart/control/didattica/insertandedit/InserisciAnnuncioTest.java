package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.utente.Didattica;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class InserisciAnnuncioTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Annuncio> annunci;
  private Annuncio ann;

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    annunci = new ArrayList<Annuncio>();
    when(request.getParameter("nome")).thenReturn("me");
    when(request.getParameter("body")).thenReturn("secret");
    when(request.getParameter("file1")).thenReturn("file");
  }

  @After
  public void tearDown() throws Exception {}


  @Test
  public void testDoPostHttpServletRequestHttpServletResponse()
      throws IOException, ServletException {

   

    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    String part = request.getParameter("file1");
    assertEquals(titolo, "me");
    assertEquals(body, "secret");
    assertEquals(part, "file");

    Date data = new Date();
    Didattica d = new Didattica("", "", "", "", "", "", "", "", "", "", "", false);
    ann = new Annuncio(titolo, d, data.toString(), body, part);
    
  }


  @Test
  public void testInserisciAnnuncio() {
    annunci.add(ann);
    assertEquals(ann, annunci.get(0));
  }

}
