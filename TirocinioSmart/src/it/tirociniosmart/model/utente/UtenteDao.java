package it.tirociniosmart.model.utente;

/**
 * UtenteDAO
 * 
 * @author ClaudioAmato Interfaccia funzionale con metodi di insert e update
 * @version 0.1
 *
 */
public interface UtenteDao {


  /**
   * Metodo per l'inserimento di uno studente nel database.
   * 
   * @param studente lo studente da inserire nel database
   * @return true se l'inserimento è riuscito; false altrimenti
   */
  public boolean inserStudente(Studente studente);

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

}
