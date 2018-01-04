package it.tirociniosmart.control.didattica.insertandedit;

import static org.junit.Assert.*;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.utente.Didattica;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class ModificaAnnuncioTest extends Mockito {

  private HttpServletRequest request;
  private HttpServletResponse response;
  private ArrayList<Annuncio> annunci;
  private Annuncio ann;

  /**
   * Metodo setUp.
   * 
   * @throws Exception eccezione
   */

  @Before
  public void setUp() throws Exception {
    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    annunci = new ArrayList<Annuncio>();
    ann = new Annuncio();
    Didattica d = new Didattica("", "", "", "", "", "", "", "", "", "", "", false);
    Annuncio a = new Annuncio("title", d, "", "", "");
    annunci.add(a);
    when(request.getParameter("nome")).thenReturn("me");
    when(request.getParameter("body")).thenReturn("secret");
    when(request.getParameter("title")).thenReturn("title");
    when(request.getParameter("file1")).thenReturn("file");
  }

  @After
  public void tearDown() throws Exception {}


  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() {

    String ot = request.getParameter("title");
    for (Annuncio a : annunci) {
      if (a.getTitolo().equalsIgnoreCase(ot)) {
        ann = a;
        annunci.remove(a);
        break;
      }
    }
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    String part = request.getParameter("file1");

    assertEquals(titolo, "me");
    assertEquals(body, "secret");
    assertEquals(part, "file");
    assertEquals(ot, "title");

    Didattica d = new Didattica("ad", "ad", "ad", "ad", "a", "a", "a", "a", "a", "a", "a", false);
    Date data = new Date();
    ann.setAutore(d);
    ann.setTitolo(titolo);
    ann.setBody(body);
    ann.setData(data.toString());
    ann.setFilePosition(part);



  }

  @Test
  public void testModificaAnnuncio() {
    annunci.remove(0);
    annunci.add(ann);
    assertEquals(ann, annunci.get(0));

  }

}
