/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.Studente;

public class InserisciFeedbackTest extends Mockito {
  
  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  
  FactoryProducer producer;
  AbstractFactory tirocinioFactory;
  TirocinioDAO tiroc;
  HashMap<Integer, Feedback> feedbackList;
  
  Studente studente, studente2;
  Tirocinio tirocinio;
  Feedback feedback;
  Feedback f1, f2, f3;
  
  boolean check;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    check = true;
    
    
    studente = new Studente("abcd@studenti","abdijid","abcd","cdvba","Roma","01/02/01","aaaaaaaa","m","Milano","Via boh","0897474","84834837","Magistrale");
    tirocinio = new Tirocinio("Tirocinio", "obiettivi", "descrizione", 5, null, "Sede", "tipo", "respons");
    producer = FactoryProducer.getIstance();
    tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    feedbackList = tiroc.selectFeedback();
    
    f1 = new Feedback(1, tirocinio, studente, "", 89, "boh");
    f2 = new Feedback(2, tirocinio, studente, "", 89, "boh");
    
    when(req.getParameter("dataInvio")).thenReturn("2000/12/01");
    when(req.getParameter("valutazione")).thenReturn("79");
    when(req.getParameter("messages")).thenReturn("ciao");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(studente);
    
    feedbackList.put(f1.getId(), f1);
    feedbackList.put(f2.getId(), f2);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testDoPostHttpServletRequestHttpServletResponse() throws IOException, StartupCacheException {
    /*String dataInvio = req.getParameter("dataInvio");
    int valutazione = Integer.parseInt(req.getParameter("valutazione"));
    String commento = req.getParameter("messages");*/
    
    studente = (Studente) req.getSession().getAttribute("currentSessionUser");
    tirocinio = (Tirocinio) req.getSession().getAttribute("tirocinioStudente");
    new InserisciFeedback().doPost(req, res);
    /*assertEquals(dataInvio, "2000/12/01");
    assertEquals(valutazione, 79);
    assertEquals(commento, "ciao");*/
    /*
    Feedback feedback = new Feedback(tirocinio, studente, dataInvio, valutazione, commento);
    Iterator<Entry<Integer, Feedback>> it = feedbackList.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      Feedback singleFeedback = (Feedback) pair.getValue();
      if (singleFeedback.getStudente().getEmail().equals(studente.getEmail())) {
        check = false;
      }
    }*/
    if (check) {
      new InserisciFeedback().inserisciFeedback(feedback);
      //verify(res).sendRedirect("tirocinio_studente.jsp");
    } else {
      //verify(res).sendRedirect("feedbackGiaInviato.jsp");
    }
    
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(studente);
  }

  @Test
  public void testInserisciFeedback() {
    
  }

}
