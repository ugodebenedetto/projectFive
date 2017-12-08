package it.tirociniosmart.model.tirocinio;

import java.util.ArrayList;

/**
 * Classe che applica il pattern proxy ed estende {@link TirocinioDAO}
 * @author UgoMaria
 * @version 0.1
 */

public class ProxyTirocinioDAO implements TirocinioDAO{
	/**
	 * La variabile realTirocinioDAO serve per realizzare il pattern proxy,
	 * sarà utile per le operazioni pesanti
	 */
	private RealTirocinioDAO realTirocinioDAO;
	
	/**
	 * Costruttore
	 */
	public ProxyTirocinioDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Metodo per inserire un Feedback
	 * @param feedback
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	public boolean insertFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Metodo per inserire un tirocinio
	 * @param tirocinio
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	boolean insertTirocinio(Tirocinio tirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Metodo che aggiorna un tirocinio
	 * @param newTirocinio
	 * @param oldTirocinio
	 * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
	 * @invariant not newTirocinio.equals(oldTirocinio)
	 */
	public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Metodo che inserisce una richiesta per un tirocinio
	 * @param richiestaTirocinio
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 */
	public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	/**
	 * Metodo che aggiorna una richiesta per un tirocinio
	 * @param newRichiesta
	 * @param oldRichiesta
	 * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
	 * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
	 */
	public boolean updateRichiestaTirocinio(RichiestaTirocinio newRichiesta, RichiestaTirocinio oldRichiesta) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * Metodo che utilizza la cache per avere la lista dei tirocini
	 * @return lista di tirocini
	 */
	public ArrayList<Tirocinio> selectTirocinio(){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere la lista dei feedback
	 * @return lista di feedback
	 */
	public ArrayList<Feedback> selectFeedback(){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere la lista dei tirocini
	 * @return lista di richiestaTirocinio
	 */
	public ArrayList<RichiestaTirocinio> selectRichiestaTirocinio(){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere la richiesta di un tirocinio in base ad uno studente
	 * @param studente
	 * @return richiestaTirocinio
	 */
	public RichiestaTirocinio findRichiestaTirocinioForUser(Studente studente){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere la richiesta di un tirocinio in base ad un Tirocinio
	 * @param tirocinio
	 * @return RichiestaTirocinio
	 */
	public RichiestaTirocinio findRichiestaTirocinioForTirocinio(Tirocinio tirocinio){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere un Tirocinio in base al suo tutorAccademico
	 * @param tutorAccademico
	 * @return Tirocinio
	 */
	public Tirocinio findTirocinioForTutorAccademico(TutorAccademico tutorAccademico){
		return null;
	}
	/**
	 * Metodo che utilizza la cache per avere un feedback in base al tirocinio
	 * @param tirocinio
	 * @return
	 * @pre Feedback.Tirocinio(includes tirocinio)
	 */
	public Feedback findFeedbackForTirocinio(Tirocinio tirocinio){
		return null;
	}
	/**
	 * Getter della variabile realTirocinioDAO
	 * @return realTirocinioDao
	 */
	public RealTirocinioDAO getRealTirocinioDAO() {
		return realTirocinioDAO;
	}
	/**
	 * Setter della variabile realTirocinioDAO
	 * @param realTirocinioDAO
	 */
	public void setRealTirocinioDAO(RealTirocinioDAO realTirocinioDAO) {
		this.realTirocinioDAO = realTirocinioDAO;
	}

}
