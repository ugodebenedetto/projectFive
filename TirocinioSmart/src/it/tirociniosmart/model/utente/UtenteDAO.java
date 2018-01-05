package it.tirociniosmart.model.utente;

import it.tirociniosmart.model.persistancetools.StartupCacheException;

import java.util.HashMap;


/**
 * UtenteDAO
 * 
 * @author ClaudioAmato Interfaccia funzionale con metodi di insert e update
 * @version 0.1
 *
 */
public interface UtenteDAO {



  /**
   * Metodo per l'inserimento di uno studente nel database.
   * 
   * @param studente lo studente da inserire nel database
   * @return true se l'inserimento è riuscito; false altrimenti
   * @throws StartupCacheException .
   */
  public boolean insertStudente(Studente studente) throws StartupCacheException;

  /**
   * Metodo per l'aggiornamento di uno studente nel database.
   * 
   * @param newStudente il nuovo studente da inserire
   * @param oldStudente il vecchio studente che si deve aggiornare
   * @return true se l'aggiornamento Ã¨ riuscito; false altrimenti
   * @throws StartupCacheException .
   */
  public boolean updateStudente(Studente newStudente, Studente oldStudente)
      throws StartupCacheException;

  /**
   * Metodo per l'inserimento di uno tutor accademico nel database.
   * 
   * @param tutorAccademico il tutor accademico da inserire nel database
   * @return true se l'inserimento è riuscito; false altrimenti
   * @throws StartupCacheException .
   */
  public boolean inserTutorAccademico(TutorAccademico tutorAccademico) throws StartupCacheException;

  /**
   * Metodo per l'aggiornamento di un tutor accademico nel database.
   * 
   * @param newTutorAccademico il nuovo tutor accademico da inserire
   * @param oldTutorAccademico il vecchio tutor accademico che si deve aggiornare
   * @return true se l'aggiornamento è riuscito; false altrimenti
   * @throws StartupCacheException .
   */
  public boolean updateTutorAccademico(TutorAccademico newTutorAccademico,
      TutorAccademico oldTutorAccademico) throws StartupCacheException;

  /**
   * Metodo per l'aggiornamento della didattica nel database.
   * 
   * @param newDidattica la nuova didattica da inserire
   * @param oldDidattica la vecchia didattica che si deve aggiornare
   * @return true se l'aggiornamento è riuscito; false altrimenti
   * @throws StartupCacheException .
   */
  public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica)
      throws StartupCacheException;

  /**
   * Seleziona tutti gli studenti.
   * 
   * @return ritorna tutti gli studenti.
   */
  public HashMap<String, Studente> selectStudente();

  /**
   * Seleziona tutti i tutor accademici
   * 
   * @return ritorna tutti i tutor
   */
  public HashMap<String, TutorAccademico> selectTutorAccademico();

  /**
   * Seleziona tutti i membri della didattica
   * 
   * @return ritorna tutti gli utenti di tipo didattica
   */
  public HashMap<String, Didattica> selectDidattica();

  /**
   * Ricerca uno studente.
   * 
   * @param studente che si cerca
   * @return Studente cercato
   */
  public Studente findStudente(Studente studente);

  /**
   * Ricerca un membro della didattica.
   * 
   * @param didattica che si cerca
   * @return Didattica cercata
   */
  public Didattica findDidattica(Didattica didattica);

  /**
   * Ricerca un tutor accademico.
   * 
   * @param tutorAccademico che si cerca
   * @return TutorAccademico cercato
   */
  public TutorAccademico findTutorAccademico(TutorAccademico tutorAccademico);

}

