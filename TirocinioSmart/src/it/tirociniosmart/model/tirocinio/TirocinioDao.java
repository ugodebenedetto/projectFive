package it.tirociniosmart.model.tirocinio;

/**
 * 
 * @author UgoMaria Interfaccia funzionale con metodi di insert e update
 * @version 0.1
 *
 */

public interface TirocinioDao {
  
  /**
   * Metodo per inserire un Feedback.
   * 
   * @param feedback feebback da inserire.
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertFeedback(Feedback feedback);

  /**
   * Metodo per inserire un tirocinio.
   * 
   * @param tirocinio tirocinio da aggiungere
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertTirocinio(Tirocinio tirocinio);

  /**
   * Metodo che aggiorna un tirocinio
   * 
   * @param newTirocinio nuovo tirocinio da aggiungere
   * @param oldTirocinio vecchio tirocinio da sostituire
   * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
   * @invariant not newTirocinio.equals(oldTirocinio)
   */
  public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio);

  /**
   * Metodo che inserisce una richiesta per un tirocinio.
   * 
   * @param richiestaTirocinio richiesta di tirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);

  /**
   * Metodo che aggiorna una richiesta per un tirocinio
   * 
   * @param newRichiesta nuova richiesta da aggiungere
   * @param oldRichiesta vecchia richiesta da sostituire
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
   */
  public boolean updateRichiestaTirocinio(RichiestaTirocinio newRichiesta,
      RichiestaTirocinio oldRichiesta);

}
