package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.utente.Didattica;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;

import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;


public class InserisciAnnuncioTest extends Mockito {

  @Mock
  HttpServletRequest req;
  @Mock
  HttpServletResponse res;
  @Mock
  HttpSession session;
  FactoryProducer producer;
  AbstractFactory annuncioFactory;
  AnnuncioDAO annunci;
  Annuncio ann;
  HashMap<String,Annuncio> toCheck;
  Didattica dida;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    StartupCache x = new StartupCache();
    dida = new Didattica("", "", "", "", "", "", "", "", "", "", "", false);
    
    producer = FactoryProducer.getIstance();
    annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    toCheck = annunci.selectAnnuncio();
    if(toCheck == null){
      ann = new Annuncio("Titolo", dida, "data", "body", "filepos");
      toCheck = new HashMap<String, Annuncio>();
      toCheck.put("Titolo", ann);
    }
    when(req.getParameter("nome")).thenReturn("me");
    when(req.getParameter("body")).thenReturn("secret");
    when(req.getParameter("file1")).thenReturn("file");
    when(req.getSession()).thenReturn(session);
    when(req.getSession().getAttribute("currentSessionUser")).thenReturn(dida);
  }

  @After
  public void tearDown() throws Exception {}


  @Test
  public void testDoPostHttpServletRequestHttpServletResponse()
      throws IOException, ServletException {
    
    new InserisciAnnuncio().doPost(req, res);
    
  }


  @Test
  public void testInserisciAnnuncio() {
    }


}
