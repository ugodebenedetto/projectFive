package it.tirociniosmart.model.tirocinio;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * Classe che applica il pattern proxy ed estende {@link TirocinioDao}
 * 
 * @author UgoMaria
 * @version 0.1
 * 
 */

public class RealTirocinioDAO implements TirocinioDAO {
  private DBManager manager;
  private DAOCache cache;

  /**
   * Costruttore.
   * 
   * @throws SQLException .
   */
  public RealTirocinioDAO() throws SQLException {
    manager = DBManager.getIstance();
    cache = DAOCache.getIstance();

  }

  @Override
  /**
   * Metodo per inserire un Feedback
   * 
   * @param feedback
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */

  public boolean insertFeedback(Feedback feedback) throws StartupCacheException {

    String sql = "INSERT INTO `mydb`.`feedback` (`data`, `commento`, `valutazione`, "
        + "`tirocinio`, `studente`) VALUES " + "(?, ?, ?, ?, ?);";
    String getId = "SELECT LAST_INSERT_ID();";

    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        PreparedStatement stId = con.prepareStatement(getId);) {

      st.setString(1, feedback.getDataInvio());
      st.setString(2, feedback.getCommento());
      st.setInt(3, feedback.getValutazione());
      st.setInt(4, feedback.getTirocinio().getId());
      st.setString(5, feedback.getStudente().getEmail());
      st.executeUpdate();
      ResultSet tmpId = stId.executeQuery();
      tmpId.next();
      feedback.setId(tmpId.getInt(1));

      cache.updateFeedback("insert", feedback.getId(), feedback);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  /**
   * Metodo per inserire un tirocinio
   * 
   * @param tirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertTirocinio(Tirocinio tirocinio) throws StartupCacheException {

    String sql = "INSERT INTO `mydb`.`tirocinio` (`stato`, `nome`, `obiettivi`, "
        + "`descrizione`, `numPosti`, `responsabile`," + " `sede`, `tipo`, `tutor`)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    String getId = "SELECT LAST_INSERT_ID();";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        PreparedStatement stId = con.prepareStatement(getId);) {

      st.setString(1, tirocinio.getStato());
      st.setString(2, tirocinio.getNome());
      st.setString(3, tirocinio.getObiettivi());
      st.setString(4, tirocinio.getDescrizione());
      st.setInt(5, tirocinio.getNumPost());
      st.setString(6, tirocinio.getResponsabile());
      st.setString(7, tirocinio.getSede());
      st.setString(8, tirocinio.getTipo());
      st.setString(9, tirocinio.getTutor().getEmail());
      st.executeUpdate();
      ResultSet tmpId = stId.executeQuery();
      tmpId.next();
      tirocinio.setId(tmpId.getInt(1));

      cache.updateTirocinio("insert", tirocinio.getId(), tirocinio);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  /**
   * Metodo che aggiorna un tirocinio
   * 
   * @param newTirocinio
   * @param oldTirocinio
   * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
   * @invariant not newTirocinio.equals(oldTirocinio)
   */
  public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio)
      throws StartupCacheException {
    String sql = "UPDATE `mydb`.`tirocinio` SET "
        + "`stato`=?, `nome`=?, `obiettivi`=?, `descrizione`=?, `numPosti`=?, "
        + "`responsabile`=?, `sede`=?, `tipo`=?, `tutor`=? WHERE `id`=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, newTirocinio.getStato());
      st.setString(2, newTirocinio.getNome());
      st.setString(3, newTirocinio.getObiettivi());
      st.setString(4, newTirocinio.getDescrizione());
      st.setInt(5, newTirocinio.getNumPost());
      st.setString(6, newTirocinio.getResponsabile());
      st.setString(7, newTirocinio.getSede());
      st.setString(8, newTirocinio.getTipo());
      st.setString(9, newTirocinio.getTutor().getEmail());
      st.setInt(10, oldTirocinio.getId());
      st.executeUpdate();
      newTirocinio.setId(oldTirocinio.getId());
      cache.updateTirocinio("update", oldTirocinio.getId(), newTirocinio);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  /**
   * Metodo che inserisce una richiesta per un tirocinio
   * 
   * @param richiestaTirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio)
      throws StartupCacheException {
    String sql = "INSERT INTO `mydb`.`richieste tirocinio` "
        + "(`stato`, `dataInvio`, `dataAccettazione`, `tirocinio`, `studente`)"
        + " VALUES (?, ?, ?, ?, ?);";
    String getId = "SELECT LAST_INSERT_ID();";

    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);
        PreparedStatement stId = con.prepareStatement(getId);) {

      st.setString(1, richiestaTirocinio.getStato());
      st.setString(2, richiestaTirocinio.getDataRichiesta());
      st.setString(3, richiestaTirocinio.getDataRisposta());
      st.setInt(4, richiestaTirocinio.getTirocinio().getId());
      st.setString(5, richiestaTirocinio.getRichiedente().getEmail());
      st.executeUpdate();
      ResultSet tmpId = stId.executeQuery();
      tmpId.next();
      richiestaTirocinio.setId(tmpId.getInt(1));

      cache.updateRichiestaTirocinio("insert", richiestaTirocinio.getId(), richiestaTirocinio);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  /**
   * Metodo che aggiorna una richiesta per un tirocinio
   * 
   * @param newRichiesta
   * @param oldRichiesta
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
   */
  public boolean updateRichiestaTirocinio(RichiestaTirocinio richiesta, String stato)
      throws StartupCacheException {

    String sql =
        "UPDATE `mydb`.`richieste tirocinio`" + "SET `stato`=?, `dataAccettazione`=? WHERE `id`=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, stato);
      st.setString(2, richiesta.getDataRisposta());
      st.setInt(3, richiesta.getId());
      st.executeUpdate();
      richiesta.setStato(stato);
      cache.updateRichiestaTirocinio("update", richiesta.getId(), richiesta);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }


  /**
   * Metodo che ritorna le richieste di tirocinio per un singolo studente.
   * 
   * @param email dello studente
   * @return richieste effettuate dallo studente.
   */
  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForUser(String email)
      throws StartupCacheException {

    String sql = "SELECT * FROM mydb.`richieste tirocinio` WHERE studente=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      ResultSet array = st.executeQuery();
      ArrayList<RichiestaTirocinio> richieste = new ArrayList<RichiestaTirocinio>();
      RichiestaTirocinio x;
      while (array.next()) {
        x = new RichiestaTirocinio();
        x.setId(array.getInt("id"));
        x.setStato(array.getString("stato"));
        x.setDataRichiesta(array.getString("dataInvio"));
        x.setDataRisposta(array.getString("dataAccettazione"));
        x.setTirocinio(cache.getTirocinio().get(array.getInt("tirocinio")));
        x.setRichiedente(cache.getStudente().get(array.getString("studente")));
        richieste.add(x);

      }
      return richieste;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Metodo che restituisce le richieste di un tirocinio per un singolo tirocinio.
   * 
   * @param id del tirocinio
   * @return richieste di tirocinio
   */

  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForTirocinio(int id)
      throws StartupCacheException {

    String sql = "SELECT * FROM mydb.`richieste tirocinio` WHERE tirocinio=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setInt(1, id);
      ResultSet array = st.executeQuery();
      ArrayList<RichiestaTirocinio> richieste = new ArrayList<RichiestaTirocinio>();
      RichiestaTirocinio x;
      while (array.next()) {
        x = new RichiestaTirocinio();
        x.setId(array.getInt("id"));
        x.setStato(array.getString("stato"));
        x.setDataRichiesta(array.getString("dataInvio"));
        x.setDataRisposta(array.getString("dataAccettazione"));
        x.setTirocinio(cache.getTirocinio().get(array.getInt("tirocinio")));
        x.setRichiedente(cache.getStudente().get(array.getString("studente")));
        richieste.add(x);

      }
      return richieste;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }


  }

  /**
   * Metodo che restituisce tutti i tirocini di un singolo tutor accademico.
   * 
   * @param email del tutor.
   * @return tirocini associati al tutor
   */

  public ArrayList<Tirocinio> findTirocinioForTutorAccademico(String email)
      throws StartupCacheException {


    String sql = "SELECT * FROM mydb.tirocinio  WHERE tutor=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, email);
      ResultSet array = st.executeQuery();
      ArrayList<Tirocinio> tirocini = new ArrayList<Tirocinio>();
      Tirocinio x;
      while (array.next()) {
        x = new Tirocinio();
        x.setId(array.getInt("id"));
        x.setStato(array.getString("stato"));
        x.setNome(array.getString("nome"));
        x.setObiettivi(array.getString("obiettivi"));
        x.setDescrizione(array.getString("descrizione"));
        x.setNumPost(array.getInt("numPosti"));
        x.setResponsabile(array.getString("responsabile"));
        x.setSede(array.getString("sede"));
        x.setTipo(array.getString("tipo"));
        x.setTutor(cache.getTutorAccademico().get(array.getString("tutor")));

        tirocini.add(x);

      }
      return tirocini;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }

  }

  /**
   * Metodo che cerca i feedback per un tirocinio.
   * 
   * @param id del tirocinio
   * @return feedback di un tirocinio
   */

  public ArrayList<Feedback> findFeedbackForTirocinio(int id) throws StartupCacheException {

    String sql = "SELECT * FROM mydb.feedback WHERE tirocinio=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setInt(1, id);
      ResultSet array = st.executeQuery();
      ArrayList<Feedback> feedback = new ArrayList<Feedback>();
      Feedback x;
      while (array.next()) {
        x = new Feedback();
        x.setId(array.getInt("id"));
        x.setDataInvio(array.getString("data"));
        x.setCommento(array.getString("commento"));
        x.setValutazione(array.getInt("valutazione"));
        x.setTirocinio(cache.getTirocinio().get(array.getInt("tirocinio")));
        x.setStudente(cache.getStudente().get(array.getString("studente")));
        feedback.add(x);

      }
      return feedback;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }



  }

  @Override
  public HashMap<Integer, Tirocinio> selectTirocinio() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HashMap<Integer, Feedback> selectFeedback() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HashMap<Integer, RichiestaTirocinio> selectRichiestaTirocinio() {
    // TODO Auto-generated method stub
    return null;
  }


}
