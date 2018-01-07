package it.tirociniosmart.model.utente;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

import java.sql.SQLException;
import java.util.HashMap;


/**
 * ProxyUtenteDAO
 * 
 * @author ClaudioAmato Questa classe rappresenta ...
 * @version 0.1
 */

public class ProxyUtenteDAO implements UtenteDAO {

  // Variabili di istanza
  private RealUtenteDAO realUtenteDao;
  private DAOCache cache;

  // Costruttore
  public ProxyUtenteDAO() {
    cache = DAOCache.getIstance();
  }
  /**
   * Costruttore.
   * 
   * @param realUtenteDao annuncio
   */


  // Getters
  /**
   * Ottieni UtenteDAO.
   * 
   * @return realAnnuncioDao
   */
  public RealUtenteDAO getRealUtenteDAO() {
    if (realUtenteDao == null) {
      try {
        this.setRealUtenteDAO();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
      }
    }

    return this.realUtenteDao;
  }

  /**
   * Assegna RealUtenteDAO.
   * 
   * @param realUtenteDao annuncio
   * @throws SQLException .
   */
  // Setters
  private void setRealUtenteDAO() throws SQLException {
    this.realUtenteDao = new RealUtenteDAO();
  }


  // Metodi dell'interfaccia UtendeDAO
  @Override
  public boolean insertStudente(Studente studente) throws StartupCacheException {
    realUtenteDao = this.getRealUtenteDAO();
    return realUtenteDao.insertStudente(studente);
  }

  @Override
  public boolean updateStudente(Studente newStudente, Studente oldStudente)
      throws StartupCacheException {
    realUtenteDao = this.getRealUtenteDAO();
    return realUtenteDao.updateStudente(newStudente, oldStudente);
  }

  @Override
  public boolean inserTutorAccademico(TutorAccademico tutorAccademico)
      throws StartupCacheException {
    realUtenteDao = this.getRealUtenteDAO();
    return realUtenteDao.inserTutorAccademico(tutorAccademico);
  }

  @Override
  public boolean updateTutorAccademico(TutorAccademico newTutorAccademico,
      TutorAccademico oldTutorAccademico) throws StartupCacheException {
    realUtenteDao = this.getRealUtenteDAO();
    return realUtenteDao.updateTutorAccademico(newTutorAccademico, oldTutorAccademico);
  }

  @Override
  public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica)
      throws StartupCacheException {
    realUtenteDao = this.getRealUtenteDAO();
    return realUtenteDao.updateDidattica(newDidattica, oldDidattica);
  }

  // metodi di classe
  /**
   * Questo metodo seleziona tutti gli studenti dal database.
   * 
   * @return l'arraylist degli studenti selezionati
   */
  public HashMap<String, Studente> selectStudente() {
    return cache.getStudente();

  }

  /**
   * Questo metodo seleziona tutti i tutor accademici dal database.
   * 
   * @return l'arraylist dei tutor accademici selezionati
   */
  public HashMap<String, TutorAccademico> selectTutorAccademico() {
    return cache.getTutorAccademico();

  }

  /**
   * Questo metodo seleziona tutta la didattica dal database.
   * 
   * @return l'arraylist di didattica selezionata
   */
  public HashMap<String, Didattica> selectDidattica() {
    return cache.getDidattica();
  }

  /**
   * Cerca uno studente all'interno del database.
   * 
   * @param studente lo studente da cercare
   * @return lo studente trovato (se esiste)
   */
  public Studente findStudente(Studente studente) {
    return cache.getStudente().get(studente.getEmail());
  }

  /**
   * Cerca una didattica all'interno del database.
   * 
   * @param didattica la didattica da cercare
   * @return la didattica trovata (se esiste)
   */
  public Didattica findDidattica(Didattica didattica) {
    return cache.getDidattica().get(didattica.getEmail());
  }

  /**
   * Cerca un tutor accademico all'interno del database.
   * 
   * @param tutorAccademico il tutor accademico da cercare
   * @return il tutor accademico trovato (se esiste)
   */
  public TutorAccademico findTutorAccademico(TutorAccademico tutorAccademico) {
    return cache.getTutorAccademico().get(tutorAccademico.getEmail());
  }



}
