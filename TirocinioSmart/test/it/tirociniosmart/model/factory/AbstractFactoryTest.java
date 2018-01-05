package it.tirociniosmart.model.factory;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public class AbstractFactoryTest {


  @Test
  public void testGetTirocinioDao() {
    FactoryProducer producer = FactoryProducer.getIstance();
    assertNotNull(producer);
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    assertNotNull(tirocinioFactory);
    TirocinioDAO tirocinio = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    assertNotNull(tirocinio);
  }

  @Test
  public void testGetUtenteDao() {
    FactoryProducer producer = FactoryProducer.getIstance();
    assertNotNull(producer);
    AbstractFactory utenteFactory = (UtenteDAOFactory) producer.getFactory("utenteDAO");
    assertNotNull(utenteFactory);
    UtenteDAO utente = (ProxyUtenteDAO) utenteFactory.getUtenteDao();
    assertNotNull(utente);
  }

  @Test
  public void testGetAnnuncioDao() {
    FactoryProducer producer = FactoryProducer.getIstance();
    assertNotNull(producer);
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    assertNotNull(annuncioFactory);
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    assertNotNull(annunci);
  }

}
