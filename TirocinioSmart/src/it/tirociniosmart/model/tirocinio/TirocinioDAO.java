package it.tirociniosmart.model.tirocinio;

import java.util.ArrayList;
import java.util.HashMap;

import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

/**
 * 
 * @author UgoMaria Interfaccia funzionale con metodi di insert e update
 * @version 0.1
 *
 */

public interface TirocinioDAO {

  /**
   * Metodo per inserire un Feedback.
   * 
   * @param feedback feebback da inserire.
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertFeedback(Feedback feedback) throws StartupCacheException;

  /**
   * Metodo per inserire un tirocinio.
   * 
   * @param tirocinio tirocinio da aggiungere
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertTirocinio(Tirocinio tirocinio) throws StartupCacheException;

  /**
   * Metodo che aggiorna un tirocinio
   * 
   * @param newTirocinio nuovo tirocinio da aggiungere
   * @param oldTirocinio vecchio tirocinio da sostituire
   * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
   * @invariant not newTirocinio.equals(oldTirocinio)
   */
  public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio)
      throws StartupCacheException;

  /**
   * Metodo che inserisce una richiesta per un tirocinio.
   * 
   * @param richiestaTirocinio richiesta di tirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio)
      throws StartupCacheException;

  /**
   * Metodo che aggiorna una richiesta per un tirocinio
   * 
   * @param newRichiesta nuova richiesta da aggiungere
   * @param oldRichiesta vecchia richiesta da sostituire
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
   */
  public boolean updateRichiestaTirocinio(RichiestaTirocinio richiesta, String stato)
      throws StartupCacheException;

  public HashMap<Integer, Tirocinio> selectTirocinio();

  public HashMap<Integer, Feedback> selectFeedback();

  public HashMap<Integer, RichiestaTirocinio> selectRichiestaTirocinio();

  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForUser(String email)
      throws StartupCacheException;

  public ArrayList<RichiestaTirocinio> findRichiestaTirocinioForTirocinio(int id)
      throws StartupCacheException;

  public ArrayList<Tirocinio> findTirocinioForTutorAccademico(String email)
      throws StartupCacheException;

  public ArrayList<Feedback> findFeedbackForTirocinio(int id) throws StartupCacheException;


}
