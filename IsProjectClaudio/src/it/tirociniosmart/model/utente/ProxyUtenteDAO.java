package it.tirociniosmart.model.utente;

import java.util.ArrayList;

/**
 * ProxyUtenteDAO
 * @author ClaudioAmato
 * Questa classe rappresenta ...
 * @version 0.1
 */
public class ProxyUtenteDAO implements UtenteDAO{

	//Variabili di istanza
	/**  */
	private RealUtenteDAO realAnnuncioDAO;
	
	//Costruttore
	/**
	 * 
	 * @param realAnnuncioDAO
	 */
	public ProxyUtenteDAO(RealUtenteDAO realAnnuncioDAO) {
		super();
		this.realAnnuncioDAO = realAnnuncioDAO;
	}

	//Getters
	/**
	 * Ottieni ...
	 * @return
	 */
	public RealUtenteDAO getRealAnnuncioDAO() {
		return realAnnuncioDAO;
	}

	/**
	 * Assegna ...
	 * @param realAnnuncioDAO
	 */
	//Setters
	public void setRealAnnuncioDAO(RealUtenteDAO realAnnuncioDAO) {
		this.realAnnuncioDAO = realAnnuncioDAO;
	}
	

	//Metodi dell'interfaccia UtendeDAO
	@Override
	public boolean inserStudente(Studente studente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudente(Studente newStudente, Studente oldStudente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inserTutorAccademico(TutorAccademico tutorAccademico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTutorAccademico(TutorAccademico newTutorAccademico, TutorAccademico oldTutorAccademico) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica) {
		// TODO Auto-generated method stub
		return false;
	}	

	//metodi di classe
	/**
	 * Questo metodo seleziona tutti gli studenti dal database
	 * @return l'arraylist degli studenti selezionati
	 */
	public ArrayList<Studente> selectStudente(){
		// TODO 
		return null;
	}
	
	/**
	 * Questo metodo seleziona tutti i tutor accademici dal database
	 * @return l'arraylist dei tutor accademici selezionati
	 */
	public ArrayList<TutorAccademico> selectTutorAccademico(){
		// TODO 
		return null;
	}
	
	/**
	 * Questo metodo seleziona tutta la didattica dal database
	 * @return l'arraylist di didattica selezionata
	 */
	public ArrayList<Didattica> selectDidattica(){
		// TODO 
		return null;
	}
	
	/**
	 * Cerca uno studente all'interno del database
	 * @param studente lo studente da cercare
	 * @return lo studente trovato (se esiste)
	 */
	public Studente findStudente(Studente studente){
		// TODO 
		return null;
	}
	
	/**
	 * Cerca un tutor accademico all'interno del database
	 * @param tutorAccademico il tutor accademico da cercare
	 * @return il tutor accademico trovato (se esiste)
	 */
	public Studente findTutorAccademico(TutorAccademico tutorAccademico){
		// TODO 
		return null;
	}
	
	/**
	 * Cerca una didattica all'interno del database
	 * @param didattica la didattica da cercare
	 * @return la didattica trovata (se esiste)
	 */
	public Studente findStudente(Didattica didattica){
		// TODO 
		return null;
	}
	
	
	
	//metodi object
	/**
	 * Sovrascrizione del metodo toString di Object.
	 * Restituisce una stringa che rappresenta testualmente questo oggetto.
	 * @return una rappresentazione in formato stringa dell'oggetto.
	 */
	@Override
	public String toString() {
		return getClass().getName()+"[realAnnuncioDAO=" + realAnnuncioDAO + "]";
	}
	
	/**
	 * Sovrascrizione del metodo equals di Object
	 * Indica se qualche altro oggetto è "uguale a" questo.
	 * @param obj l'oggetto di riferimento con cui confrontare.
	 * @return true se questo oggetto è lo stesso dell'oggetto dell'argomento; false altrimenti.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		ProxyUtenteDAO other = (ProxyUtenteDAO) obj;
		return realAnnuncioDAO.equals(other.realAnnuncioDAO);
	}
	
	/**
	 * Sovrascrizione del metodo clone di Object.
	 * Crea e restituisce una copia di questo oggetto.
	 * @return un clone di questa istanza.
	 */
	@Override
	protected Object clone() {
		try{
			return (ProxyUtenteDAO) super.clone();
		} 
		catch (CloneNotSupportedException e){
			return null;
		}
	}
}
