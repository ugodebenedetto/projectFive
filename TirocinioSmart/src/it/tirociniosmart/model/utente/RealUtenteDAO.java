package it.tirociniosmart.model.utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.tomcat.jdbc.pool.DataSource;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

/**
 * RealUtenteDAO
 * 
 * @author ClaudioAmato Questa classe rappresenta ...
 * @version 0.1
 */

public class RealUtenteDAO implements UtenteDAO {

  private DBManager manager;
  private DAOCache cache;

  public RealUtenteDAO() throws SQLException {
    manager = DBManager.getIstance();
    cache = DAOCache.getIstance();
  }

  // Metodi dell'interfaccia UtendeDAO



  @Override
  public boolean insertStudente(Studente studente) throws StartupCacheException {

    String sql = "INSERT INTO `mydb`.`studente` "
        + "(`email`, `luogoNascita`, `codiceFiscale`, `dataNascita`, "
        + "`cognome`, `nome`, `password`, `matricola`, `tipoLaurea`, `via`, "
        + "`residenza`, `sesso`, `telefono`) " + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, studente.getEmail());
      st.setString(2, studente.getLuogoNascita());
      st.setString(3, studente.getCodiceFiscale());
      st.setString(4, studente.getDataNascita());
      st.setString(5, studente.getCognome());
      st.setString(6, studente.getNome());
      st.setString(7, studente.getPassword());
      st.setString(8, studente.getMatricola());
      st.setString(9, studente.getTipoLaurea());
      st.setString(10, studente.getVia());
      st.setString(11, studente.getResidenza());
      st.setString(12, studente.getSesso());
      st.setString(13, studente.getTelefono());
      st.executeUpdate();
      cache.updateStudente("insert", studente.getEmail(), studente);
      return true;
    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }


  }

  @Override
  public boolean updateStudente(Studente newStudente, Studente oldStudente)
      throws StartupCacheException {
    String sql = "UPDATE `mydb`.`studente` SET "
        + "`email`=?, `luogoNascita`=?, `codiceFiscale`=?, `dataNascita`=?,"
        + " `cognome`=?, `nome`=?, `password`=?, `matricola`=?,"
        + " `tipoLaurea`=?, `via`=?, `residenza`=?, `sesso`=?, " + "`telefono`=? WHERE `email`=?;";


    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, newStudente.getEmail());
      st.setString(2, newStudente.getLuogoNascita());
      st.setString(3, newStudente.getCodiceFiscale());
      st.setString(4, newStudente.getDataNascita());
      st.setString(5, newStudente.getCognome());
      st.setString(6, newStudente.getNome());
      st.setString(7, newStudente.getPassword());
      st.setString(8, newStudente.getMatricola());
      st.setString(9, newStudente.getTipoLaurea());
      st.setString(10, newStudente.getVia());
      st.setString(11, newStudente.getResidenza());
      st.setString(12, newStudente.getSesso());
      st.setString(13, newStudente.getTelefono());
      st.setString(14, oldStudente.getEmail());
      st.executeUpdate();
      cache.updateStudente("update", oldStudente.getEmail(), newStudente);
      return true;
    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }


  }

  @Override
  public boolean inserTutorAccademico(TutorAccademico tutorAccademico)
      throws StartupCacheException {
    // TODO Auto-generated method stub
    String sql = "INSERT INTO `mydb`.`tutor accademico`"
        + " (`email`, `luogoNascita`, `codiceFiscale`, `dataNascita`,"
        + " `cognome`, `nome`, `password`, `dipartimento`, `telefono`, "
        + "`via`, `residenza`, `sesso`, `codiceDocente`) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, tutorAccademico.getEmail());
      st.setString(2, tutorAccademico.getLuogoNascita());
      st.setString(3, tutorAccademico.getCodiceFiscale());
      st.setString(4, tutorAccademico.getDataNascita());
      st.setString(5, tutorAccademico.getCognome());
      st.setString(6, tutorAccademico.getNome());
      st.setString(7, tutorAccademico.getPassword());
      st.setString(8, tutorAccademico.getDipartimento());
      st.setString(9, tutorAccademico.getTelefono());
      st.setString(10, tutorAccademico.getVia());
      st.setString(11, tutorAccademico.getResidenza());
      st.setString(12, tutorAccademico.getSesso());
      st.setString(13, tutorAccademico.getCodiceDocente());

      st.executeUpdate();
      cache.updateTutorAccademico("insert", tutorAccademico.getEmail(), tutorAccademico);
      return true;
    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean updateTutorAccademico(TutorAccademico newTutorAccademico,
      TutorAccademico oldTutorAccademico) throws StartupCacheException {
    // TODO Auto-generated method stub
    String sql = "UPDATE `mydb`.`tutor accademico`" + " SET `email`=?, `luogoNascita`=?, "
        + "`codiceFiscale`=?, `dataNascita`=?," + " `cognome`=?, `nome`=?, `password`=?, "
        + "`dipartimento`=?, `telefono`=?, `via`=?,"
        + " `residenza`=?, `sesso`=?, `codiceDocente`=?" + " WHERE `email`=?;";

    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, newTutorAccademico.getEmail());
      st.setString(2, newTutorAccademico.getLuogoNascita());
      st.setString(3, newTutorAccademico.getCodiceFiscale());
      st.setString(4, newTutorAccademico.getDataNascita());
      st.setString(5, newTutorAccademico.getCognome());
      st.setString(6, newTutorAccademico.getNome());
      st.setString(7, newTutorAccademico.getPassword());
      st.setString(8, newTutorAccademico.getDipartimento());
      st.setString(9, newTutorAccademico.getTelefono());
      st.setString(10, newTutorAccademico.getVia());
      st.setString(11, newTutorAccademico.getResidenza());
      st.setString(12, newTutorAccademico.getSesso());
      st.setString(13, newTutorAccademico.getCodiceDocente());
      st.setString(14, oldTutorAccademico.getEmail());

      st.executeUpdate();
      cache.updateTutorAccademico("update", oldTutorAccademico.getEmail(), newTutorAccademico);
      return true;
    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }
  }

  @Override
  public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica)
      throws StartupCacheException {
    String sql = "UPDATE `mydb`.`didattica` SET"
        + " `email`=?, `luogoNascita`=?, `codiceFiscale`=?, `password`=?, "
        + "`dataNascita`=?, `cognome`=?, `nome`=?, `direttore`=?, `via`=?,"
        + " `residenza`=?, `sesso`=?, `telefono`=? WHERE `email`=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {
      st.setString(1, newDidattica.getEmail());
      st.setString(2, newDidattica.getLuogoNascita());
      st.setString(3, newDidattica.getCodiceFiscale());
      st.setString(4, newDidattica.getPassword());
      st.setString(5, newDidattica.getDataNascita());
      st.setString(6, newDidattica.getCognome());
      st.setString(7, newDidattica.getNome());
      st.setBoolean(8, newDidattica.getDirettore());
      st.setString(9, newDidattica.getVia());
      st.setString(10, newDidattica.getResidenza());
      st.setString(11, newDidattica.getSesso());
      st.setString(12, newDidattica.getTelefono());
      st.setString(13, oldDidattica.getEmail());

      st.executeUpdate();
      cache.updateDidattica("update", oldDidattica.getEmail(), newDidattica);
      return true;
    }

    catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }

  }

  @Override
  public HashMap<String, Studente> selectStudente() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HashMap<String, TutorAccademico> selectTutorAccademico() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HashMap<String, Didattica> selectDidattica() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Studente findStudente(Studente studente) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Didattica findDidattica(Didattica didattica) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TutorAccademico findTutorAccademico(TutorAccademico tutorAccademico) {
    // TODO Auto-generated method stub
    return null;
  }
}
