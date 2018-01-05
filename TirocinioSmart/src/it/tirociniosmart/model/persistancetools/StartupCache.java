package it.tirociniosmart.model.persistancetools;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.tirocinio.Feedback;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;



public class StartupCache {
  private DBManager manager;
  private DAOCache cache;

  /**
   * Costruttore StartupCache.
   */

  public StartupCache() {
    try {
      manager = DBManager.getIstance();
      cache = DAOCache.getIstance();
      this.setCacheStudente();
      this.setCacheTutorAccademico();
      this.setCacheDidattica();
      this.setCacheTirocinio();
      this.setCacheFeedback();
      this.setCacheRichiestaTirocinio();
      this.setCacheAnnunci();

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Metodo per settare la cache di studente.
   */

  public void setCacheStudente() {

    String sql = "SELECT * FROM mydb.studente;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      ResultSet array = st.executeQuery();
      boolean moreElements = false;
      HashMap<String, Studente> studenti = new HashMap<String, Studente>();

      Studente x;
      while (array.next()) {

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

  /**
   * Metodo per settare la cache di richiesta tirocinio.
   */

  public void setCacheRichiestaTirocinio() {
    cache.setRichiestaTirocinio(new HashMap<Integer, RichiestaTirocinio>());
    String sql = "SELECT * FROM mydb.`richieste tirocinio`;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      ResultSet array = st.executeQuery();
      HashMap<Integer, RichiestaTirocinio> richieste = new HashMap<Integer, RichiestaTirocinio>();
      RichiestaTirocinio x;
      while (array.next()) {
        x = new RichiestaTirocinio();
        x.setId(array.getInt("id"));
        x.setStato(array.getString("stato"));
        x.setDataRichiesta(array.getString("dataInvio"));
        x.setDataRisposta(array.getString("dataAccettazione"));
        x.setTirocinio(this.findTirocinio(array.getInt("tirocinio")));
        x.setRichiedente(this.findStudente(array.getString("studente")));
        richieste.put(x.getId(), x);

      }
      cache.setRichiestaTirocinio(richieste);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }

  }

  /**
   * Metodo per settare la cache di tirocinio.
   */

  public void setCacheTirocinio() {
    cache.setTirocinio(new HashMap<Integer, Tirocinio>());
    String sql = "SELECT * FROM mydb.tirocinio;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      ResultSet array = st.executeQuery();
      HashMap<Integer, Tirocinio> tirocini = new HashMap<Integer, Tirocinio>();
      int id = 0;
      while (array.next()) {
        id = array.getInt("id");
        tirocini.put(id, this.findTirocinio(id));

      }
      cache.setTirocinio(tirocini);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }

  }

  /**
   * Metodo per settare la cache di feedback.
   */

  public void setCacheFeedback() {
    cache.setFeedback(new HashMap<Integer, Feedback>());
    String sql = "SELECT * FROM mydb.feedback ;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      ResultSet array = st.executeQuery();
      HashMap<Integer, Feedback> feedback;
      feedback = new HashMap<Integer, Feedback>();
      Feedback x;
      while (array.next()) {
        x = new Feedback();
        x.setId(array.getInt("id"));
        x.setDataInvio(array.getString("data"));
        x.setCommento(array.getString("commento"));
        x.setValutazione(array.getInt("valutazione"));
        x.setTirocinio(this.findTirocinio(array.getInt("tirocinio")));
        x.setStudente(this.findStudente(array.getString("studente")));
        feedback.put(x.getId(), x);

      }
      cache.setFeedback(feedback);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  /**
   * Metodo per cercare un tirocnio.
   * 
   * @param id del tirocinio da cercare
   * @return Tirocinio cercato
   * @throws SQLException .
   */

  public Tirocinio findTirocinio(int id) throws SQLException {
    String sql = "SELECT * FROM mydb.tirocinio WHERE id=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setInt(1, id);
      ResultSet array = st.executeQuery();
      array.next();
      Tirocinio x = new Tirocinio();
      x.setId(array.getInt("id"));
      x.setStato(array.getString("stato"));
      x.setNome(array.getString("nome"));
      x.setObiettivi(array.getString("obiettivi"));
      x.setDescrizione(array.getString("descrizione"));
      x.setNumPost(array.getInt("numPosti"));
      x.setResponsabile(array.getString("responsabile"));
      x.setSede(array.getString("sede"));
      x.setTipo(array.getString("tipo"));
      x.setTutor(this.findTutor(array.getString("tutor")));
      return x;

    }


  }

  /**
   * Metodo per cercare uno studente.
   * 
   * @param email dello studente da cercare
   * @return Studente cercato
   * @throws SQLException .
   */

  public Studente findStudente(String email) throws SQLException {
    String sql = "SELECT * FROM mydb.studente WHERE email=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      ResultSet array = st.executeQuery();
      array.next();
      Studente x = new Studente();
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
      return x;
    }

  }

  /**
   * Metodo per cercare un tutor.
   * 
   * @param email del tutor da cercare.
   * @return Tutor cercato
   * @throws SQLException .
   */

  public TutorAccademico findTutor(String email) throws SQLException {
    String sql = "SELECT * FROM mydb.`tutor accademico` WHERE email=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);

      ResultSet array = st.executeQuery();
      array.next();
      TutorAccademico x = new TutorAccademico();
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
      return x;
    }

  }

  /**
   * Metodo per settare la cache della didattica.
   */

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

        if (array.getInt("direttore") == 0) {
          x.setDirettore(false);
        } else {
          x.setDirettore(true);
        }

        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setTelefono(array.getString("telefono"));
        arrayDidattica.put(x.getEmail(), x);
        moreElements = array.next();

      }

      cache.setDidattica(arrayDidattica);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  /**
   * Metodo per settare la cache del tutor accademico.
   */
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
        moreElements = array.next();

      }
      cache.setTutorAccademico(arrayTutor);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }

  /**
   * metodo per settare gli annunci inizialmente
   */

  public void setCacheAnnunci() {

    String sql = "SELECT * FROM mydb.annuncio;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      ResultSet array = st.executeQuery();
      HashMap<String, Annuncio> annunci = new HashMap<String, Annuncio>();
      Annuncio x;
      while (array.next()) {

        x = new Annuncio();
        x.setTitolo(array.getString("titolo"));
        x.setBody(array.getString("body"));
        x.setData(array.getString("data"));
        x.setFilePosition(array.getString("filePosition"));
        x.setAutore(this.findDidattica(array.getString("autore")));
        annunci.put(x.getTitolo(), x);

      }
      cache.setAnnunci(annunci);

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public Didattica findDidattica(String email) throws SQLException {
    String sql = "SELECT * FROM mydb.didattica WHERE email=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      ResultSet array = st.executeQuery();
      array.next();
      Didattica x = new Didattica();
      x.setCodiceFiscale(array.getString("codiceFiscale"));
      x.setNome(array.getString("nome"));
      x.setCognome(array.getString("cognome"));
      x.setDataNascita(array.getString("dataNascita"));
      x.setLuogoNascita(array.getString("luogoNascita"));
      x.setEmail(array.getString("email"));
      x.setPassword(array.getString("password"));

      if (array.getInt("direttore") == 0) {
        x.setDirettore(false);
      } else {
        x.setDirettore(true);
      }

      x.setVia(array.getString("via"));
      x.setResidenza(array.getString("residenza"));
      x.setSesso(array.getString("sesso"));
      x.setTelefono(array.getString("telefono"));
      return x;
    }

  }



}


