package it.tirociniosmart.model.tirocinio;

/**
 * Tirocinio
 * @author Davide
 * Questa classe rappresente l'entità tirocinio con i relativi attributi
 *
 */

public class Tirocinio {
	/**
	 * Titolo tirocinio
	 * @invariant !titolo.equals("") && titolo != null
	 */
	private String titolo;
	
	/**
	 * Descrizione
	 * @invariant !descrizione.equals("") && descrizione != null 
	 */
	private String descrizione;
	
	/**
	 * Numero posti
	 * @invariant numPost > 0
	 */
	private int numPost;
	
	/**
	 * Tutor accademico associato al tirocinio
	 * @invariant responsabile != null;
	 */
	private TutorAccademico responsabile;
	
	
	public Tirocinio(String titolo, String descrizione, int numPost, TutorAccademico responsabile) {
		super();
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.numPost = numPost;
		this.responsabile = responsabile;
	}


	public String getTitolo() {
		return titolo;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public int getNumPost() {
		return numPost;
	}


	public TutorAccademico getResponsabile() {
		return responsabile;
	}

	
	/**
	 * 
	 * @param titolo
	 * @post !titolo.equals("") && titolo != null
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	
	/**
	 * 
	 * @param descrizione
	 * @post !descrizione.equals("") && descrizione != null
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	
	/**
	 * 
	 * @param numPost
	 * @post numPost > 0
	 */
	public void setNumPost(int numPost) {
		this.numPost = numPost;
	}

	/**
	 * 
	 * @param responsabile
	 * @post responsabile != null
	 */
	public void setResponsabile(TutorAccademico responsabile) {
		this.responsabile = responsabile;
	}
	
	
	
	
}
