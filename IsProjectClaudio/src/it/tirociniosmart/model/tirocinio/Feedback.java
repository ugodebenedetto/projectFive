package it.tirociniosmart.model.tirocinio;

public class Feedback {
	
	/**
	 * Tirocinio
	 */
	private Tirocinio tirocinio;
	
	/**
	 * Studente
	 */
	private Studente studente;
	
	/**
	 * Data invio feedback
	 * @invariant  dataInvio >= CurrentDate
	 */
	private String dataInvio;
	
	/**
	 * Valutazione tirocinio
	 */
	private String valutazione;
	
	/**
	 * Commento
	 */
	private String commento;
	
	
	public Feedback(Tirocinio tirocinio, Studente studente, String dataInvio, String valutazione, String commento) {
		super();
		this.tirocinio = tirocinio;
		this.studente = studente;
		this.dataInvio = dataInvio;
		this.valutazione = valutazione;
		this.commento = commento;
	}


	public Tirocinio getTirocinio() {
		return tirocinio;
	}


	public Studente getStudente() {
		return studente;
	}


	public String getDataInvio() {
		return dataInvio;
	}


	public String getValutazione() {
		return valutazione;
	}


	public String getCommento() {
		return commento;
	}

	/**
	 * 
	 * @param tirocinio
	 * @post tirocinio != null
	 */
	public void setTirocinio(Tirocinio tirocinio) {
		this.tirocinio = tirocinio;
	}

	/**
	 * 
	 * @param studente
	 * @post studente != null
	 */
	public void setStudente(Studente studente) {
		this.studente = studente;
	}

	/**
	 * 
	 * @param dataInvio
	 * @post dataInvio >= currentDate
	 */
	public void setDataInvio(String dataInvio) {
		this.dataInvio = dataInvio;
	}

	/**
	 * 
	 * @param valutazione
	 */
	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}

	/**
	 * 
	 * @param commento
	 */
	public void setCommento(String commento) {
		this.commento = commento;
	}
	
	
}
