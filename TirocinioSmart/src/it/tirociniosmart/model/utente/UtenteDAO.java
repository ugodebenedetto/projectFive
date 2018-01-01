package it.tirociniosmart.model.utente;

import java.sql.SQLException;
import java.util.ArrayList;
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
   */
  public boolean insertStudente(Studente studente);

  /**
   * Metodo per l'aggiornamento di uno studente nel database.
   * 
   * @param newStudente il nuovo studente da inserire
   * @param oldStudente il vecchio studente che si deve aggiornare
   * @return true se l'aggiornamento è riuscito; false altrimenti
   */
  public boolean updateStudente(Studente newStudente, Studente oldStudente);

  /**
   * Metodo per l'inserimento di uno tutor accademico nel database.
   * 
   * @param tutorAccademico il tutor accademico da inserire nel database
   * @return true se l'inserimento � riuscito; false altrimenti
   */
  public boolean inserTutorAccademico(TutorAccademico tutorAccademico);

  /**
   * Metodo per l'aggiornamento di un tutor accademico nel database.
   * 
   * @param newTutorAccademico il nuovo tutor accademico da inserire
   * @param oldTutorAccademico il vecchio tutor accademico che si deve aggiornare
   * @return true se l'aggiornamento � riuscito; false altrimenti
   */
  public boolean updateTutorAccademico(TutorAccademico newTutorAccademico,
      TutorAccademico oldTutorAccademico);

  /**
   * Metodo per l'aggiornamento della didattica nel database.
   * 
   * @param newDidattica la nuova didattica da inserire
   * @param oldDidattica la vecchia didattica che si deve aggiornare
   * @return true se l'aggiornamento � riuscito; false altrimenti
   */
  public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica);

  /**
   * Seleziona tutti gli studenti
   * 
   * @return HashMap<String, Studente>
   */
  public HashMap<String, Studente> selectStudente();

  /**
   * Seleziona tutti i tutor accademici
   * 
   * @return HashMap<String, TutorAccademico>
   */
  public HashMap<String, TutorAccademico> selectTutorAccademico();

  /**
   * Seleziona tutti i membri della didattica
   * 
   * @return HashMap<String, Didattica>
   */
  public HashMap<String, Didattica> selectDidattica();

  /**
   * Ricerca uno studente
   * 
   * @param studente
   * @return Studente
   */
  public Studente findStudente(Studente studente);

  /**
   * Ricerca un membro della didattica
   * 
   * @param didattica
   * @return Didattica
   */
  public Didattica findDidattica(Didattica didattica);

  /**
   * Ricerca un tutor accademico
   * 
   * @param tutorAccademico
   * @return TutorAccademico
   */
  public TutorAccademico findTutorAccademico(TutorAccademico tutorAccademico);

}

