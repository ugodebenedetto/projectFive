package it.tirociniosmart.model.tirocinio;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.RealUtenteDAO;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Classe che applica il pattern proxy ed estende {@link TirocinioDao}
 * 
 * @author UgoMaria
 * @version 0.1
 */

public class ProxyTirocinioDAO implements TirocinioDAO {
  /**
   * La variabile realTirocinioDAO serve per realizzare il pattern proxy, sarà utile per le
   * operazioni pesanti.
   */
  private RealTirocinioDAO realTirocinioDao;
  private DAOCache cache;

  // Costruttore
  public ProxyTirocinioDAO() {
    cache = DAOCache.getIstance();
  }

  public RealTirocinioDAO getRealUtenteDAO() {
    if (realTirocinioDao == null) {
      try {
        this.setRealTirocinioDao(new RealTirocinioDAO());
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
      }
    }

    return this.getRealTirocinioDao();
  }



  @Override
  /**
   * Metodo per inserire un Feedback
   * 
   * @param feedback
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertFeedback(Feedback feedback) throws StartupCacheException {
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.insertFeedback(feedback);
  }

  @Override
  /**
   * Metodo per inserire un tirocinio
   * 
   * @param tirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertTirocinio(Tirocinio tirocinio) throws StartupCacheException {
    realTirocinioDao = this.getRealTirocinioDao();

    return realTirocinioDao.insertTirocinio(tirocinio);
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
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.updateTirocinio(newTirocinio, oldTirocinio);
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
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.insertRichiestaTirocinio(richiestaTirocinio);
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
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.updateRichiestaTirocinio(richiesta, stato);
  }

  /**
   * Metodo che utilizza la cache per avere la lista dei tirocini.
   * 
   * @return lista di tirocini
   */
  public HashMap<Integer, Tirocinio> selectTirocinio() {
    return cache.getTirocinio();
  }

  /**
   * Metodo che utilizza la cache per avere la lista dei feedback.
   * 
   * @return lista di feedback
   */
  public HashMap<Integer, Feedback> selectFeedback() {
    return cache.getFeedback();
  }

  /**
   * Metodo che utilizza la cache per avere la lista dei tirocini.
   * 
   * @return lista di richiestaTirocinio
   */
  public HashMap<Integer, RichiestaTirocinio> selectRichiestaTirocinio() {
    return cache.getRichiestaTirocinio();
  }

  /**
   * Metodo che utilizza la cache per avere la richiesta di un tirocinio in base ad uno studente.
   * 
   * @param studente studente a cui è associata la richiesta da trovare
   * @return richiestaTirocinio
   */
  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForUser(String email)
      throws StartupCacheException {
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.findRichiestaTirocinioForUser(email);

  }

  /**
   * Metodo che utilizza la cache per avere la richiesta di un tirocinio in base ad un Tirocinio.
   * 
   * @param tirocinio tirocinio a cui è associata la richiesta da trovare
   * @return RichiestaTirocinio
   */
  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForTirocinio(int id)
      throws StartupCacheException {
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.findRichiestaTirocinioForTirocinio(id);
  }

  /**
   * Metodo che utilizza la cache per avere un Tirocinio in base al suo tutorAccademico.
   * 
   * @param email email del tutor Accademico a cui è associata la richiesta da trovare
   * @return Tirocinio
   */
  public ArrayList<Tirocinio> findTirocinioForTutorAccademico(String email)
      throws StartupCacheException {

    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.findTirocinioForTutorAccademico(email);
  }

  /**
   * Metodo che utilizza la cache per avere un feedback in base al tirocinio
   * 
   * @param tirocinio tirocinio su cui cercare il feedback
   * @return Feedback
   * @pre Feedback.Tirocinio(includes tirocinio)
   */
  public ArrayList<Feedback> findFeedbackForTirocinio(int id) throws StartupCacheException {
    realTirocinioDao = this.getRealTirocinioDao();
    return realTirocinioDao.findFeedbackForTirocinio(id);

  }

  /**
   * Getter della variabile realTirocinioDAO.
   * 
   * @return realTirocinioDao
   */
  public RealTirocinioDAO getRealTirocinioDao() {
    if (realTirocinioDao == null) {
      try {
        this.setRealTirocinioDao(new RealTirocinioDAO());
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
      }
    }

    return this.realTirocinioDao;
  }

  public void setRealTirocinioDao(RealTirocinioDAO realTirocinioDao) {
    this.realTirocinioDao = realTirocinioDao;
  }

  /**
   * Setter della variabile realTiroinioDAO.
   * 
   * @param realTirocinioDao tirocinio da settare
   */

}
