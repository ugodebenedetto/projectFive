package it.tirociniosmart.model.tirocinio;
/**
 * 
 * @author UgoMaria
 * Interfaccia funzionale con metodi di insert e update
 * @version 0.1
 *
 */

public interface TirocinioDAO {
	/**
	 * Metodo per inserire un Feedback
	 * @param feedback
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	public boolean insertFeedback(Feedback feedback);
	/**
	 * Metodo per inserire un tirocinio
	 * @param tirocinio
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	public boolean insertTirocinio(Tirocinio tirocinio);
	/**
	 * Metodo che aggiorna un tirocinio
	 * @param newTirocinio
	 * @param oldTirocinio
	 * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
	 * @invariant not newTirocinio.equals(oldTirocinio)
	 */
	public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio);
	/**
	 * Metodo che inserisce una richiesta per un tirocinio
	 * @param richiestaTirocinio
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio);
	/**
	 * Metodo che aggiorna una richiesta per un tirocinio
	 * @param newRichiesta
	 * @param oldRichiesta
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
	 */
	public boolean updateRichiestaTirocinio(RichiestaTirocinio newRichiesta, RichiestaTirocinio oldRichiesta);

}
