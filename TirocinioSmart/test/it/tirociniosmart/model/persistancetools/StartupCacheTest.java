package it.tirociniosmart.model.persistancetools;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.Studente;

public class StartupCacheTest {
  ProxyUtenteDAO dao = new ProxyUtenteDAO();

  @Before
  public void setUp() throws Exception {
    StartupCache cache = new StartupCache();
    Studente studente = new Studente();
    studente.setNome("Stuente");
    studente.setEmail("armando2@live.it");
    
    dao.insertStudente(studente);
     




  }

  @Test
  public void testSetCacheStudente() {
  

  }

}
