package it.tirociniosmart.model.persistancetools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class StartupCache {
  private DBManager manager;
  private DAOCache cache;

  public StartupCache() {
    try {
      manager = DBManager.getIstance();
      cache = DAOCache.getIstance();
      cache.setDidattica(new HashMap<String,Didattica>());
      cache.setStudente(new HashMap<String,Studente>());
      cache.setTutorAccademico(new HashMap<String,TutorAccademico>());
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public void setCacheStudente() {
    String sql = "SELECT * FROM mydb.studente;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      ResultSet array = st.executeQuery();
      boolean moreElements = false;
      moreElements = array.next();
      HashMap<String, Studente> studenti = new HashMap<String, Studente>();

      Studente x;
      while (moreElements) {
        x = new Studente();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setMatricola(array.getString("matricola"));
        x.setTipoLaurea(array.getString("tipoLaurea"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setMatricola(array.getString("matricola"));
        x.setTipoLaurea(array.getString("tipoLaurea"));
        x.setTelefono(array.getString("telefono"));
        studenti.put(x.getEmail(), x);
      }
      cache.setStudente(studenti);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }



  public void setCacheDidattica() {
    String sql = "SELECT * FROM mydb.didattica;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      ResultSet array = st.executeQuery();
      boolean moreElements = false;
      moreElements = array.next();
      HashMap<String, Didattica> arrayDidattica = new HashMap<String, Didattica>();
      Didattica x;
      while (moreElements) {
        x = new Didattica();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setDirettore(array.getBoolean("direttore"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setTelefono(array.getString("telefono"));
        arrayDidattica.put(x.getEmail(), x);
      }
      cache.setDidattica(arrayDidattica);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  public void setCacheTutorAccademico() {
    String sql = "SELECT * FROM mydb.`tutor accademico`;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      ResultSet array = st.executeQuery();
      boolean moreElements = false;
      moreElements = array.next();
      HashMap<String, TutorAccademico> arrayTutor = new HashMap<String, TutorAccademico>();
      TutorAccademico x;
      while (moreElements) {
        x = new TutorAccademico();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setDipartimento(array.getString("dipartimento"));
        x.setCodiceDocente(array.getString("codiceDocente"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setTelefono(array.getString("telefono"));
        arrayTutor.put(x.getEmail(), x);
      }
      cache.setTutorAccademico(arrayTutor);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }



}


