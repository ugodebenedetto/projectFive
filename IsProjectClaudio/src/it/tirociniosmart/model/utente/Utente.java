package it.tirociniosmart.model.utente;

/**
 * Utente
 * @author ClaudioAmato
 * Questa classe rappresenta la generalizzazione di utente
 * @version 0.1
 * 
 */
public abstract class Utente {

	//Variabili di istanza
	/**Variabile d'istanza che rappresenta l'email di un utente */
	private String email;
	
	/**
	 * Variabile d'istanza che rappresenta il codice fiscale di un utente 
	 * @invariant codiceFiscale.lenght() == 16
	 */
	private String codiceFiscale;
	
	/**Variabile d'istanza che rappresenta il nome di un utente */
	private String nome;
	
	/**Variabile d'istanza che rappresenta il cognome di un utente */
	private String cognome;
	
	/**Variabile d'istanza che rappresenta il luogo di nascita di un utente */
	private String luogoNascita;
	
	/**Variabile d'istanza che rappresenta la data di nascita di un utente */
	private String dataNascita;
	
	/**
	 * Variabile d'istanza che rappresenta la password di un utente 
	 * @invariant password.lenght() >= 8
	 */
	private String password;

	/**Variabile d'istanza che rappresenta il sesso di un utente */
	private String sesso;
	
	/**Variabile d'istanza che rappresenta la residenza di un utente */
	private String residenza;
	
	/**Variabile d'istanza che rappresenta la via di un utente */
	private String via;
	
	/**Variabile d'istanza che rappresenta il numero di telefono di un utente */
	private String telefono;

	
	//Costruttore
	/**
	 * @param email
	 * @param codiceFiscale
	 * @param nome
	 * @param cognome
	 * @param luogoNascita
	 * @param dataNascita
	 * @param password
	 */
	public Utente(String email, String codiceFiscale, String nome, String cognome, String luogoNascita, String dataNascita, String password) {
		this.email = email;
		this.codiceFiscale = codiceFiscale;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.dataNascita = dataNascita;
		this.password = password;
	}

	
	//Getters
	/**
	 * Ottieni e-mail utente
	 * @return l'email dell'utente
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Ottieni codice fiscale utente
	 * @return il codice fiscale dell'utente
	 */
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	/**
	 * Ottieni nome utente
	 * @return il nome dell'utente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Ottieni nome utente
	 * @return il codice fiscale dell'utente
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Ottieni luogo nascita utente
	 * @return il luogo di nascita dell'utente
	 */
	public String getLuogoNascita() {
		return luogoNascita;
	}
	
	/**
	 * Ottieni data nascita utente
	 * @return la data di nascita dell'utente
	 */
	public String getDataNascita() {
		return dataNascita;
	}
	
	/**
	 * Ottieni password utente
	 * @return la password dell'utente
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Ottieni sesso utente
	 * @return il sesso dell'utente
	 */
	public String getSesso() {
		return sesso;
	}

	/**
	 * Ottieni residenza utente
	 * @return la residenza dell'utente
	 */
	public String getResidenza() {
		return residenza;
	}

	/**
	 * Ottieni via utente
	 * @return la via dell'utente
	 */
	public String getVia() {
		return via;
	}

	/**
	 * Ottieni numero di telefono utente
	 * @return il numero di telefono dell'utente
	 */
	public String getTelefono() {
		return telefono;
	}


	//Setters
	/**
	 * Assegna una e-mail
	 * @param email l'email da assegnare all'utente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Assegna un codice fiscale
	 * @param codiceFiscale il codice fiscale da assegnare all'utente
	 * @invariant codiceFiscale.lenght() == 16
	 */
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Assegna un nome
	 * @param nome il nome da assegnare all'utente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Assegna un cognome
	 * @param cognome il cognome da assegnare all'utente
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * Assegna luogo di nascita
	 * @param luogoNascita il luogo di nascita da assegnare all'utente
	 */
	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	/**
	 * Assegna data di nascita
	 * @param dataNascita la data di nascita da assegnare all'utente
	 */
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}

	/**
	 * Assegna password
	 * @param password la password da assegnare all'utente
	 * @invariant password.lenght() >= 8
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Assegna sesso
	 * @param sesso il sesso da assegnare all'utente
	 */
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	/**
	 * Assegna residenza
	 * @param residenza la residenza da assegnare all'utente
	 */
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	/**
	 * Assegna via
	 * @param via la via da assegnare all'utente
	 */
	public void setVia(String via) {
		this.via = via;
	}

	/**
	 * Assegna telefono
	 * @param telefono il numero di telefono da assegnare all'utente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	//metodi object
	/**
	 * Sovrascrizione del metodo toString di Object.
	 * Restituisce una stringa che rappresenta testualmente questo oggetto.
	 * @return una rappresentazione in formato stringa dell'oggetto.
	 */
	@Override
	public String toString() {
		return getClass().getName()+"[email=" + email + ", codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome
				+ ", luogoNascita=" + luogoNascita + ", dataNascita=" + dataNascita + ", password=" + password
				+ ", sesso=" + sesso + ", residenza=" + residenza + ", via=" + via + ", telefono=" + telefono + "]";
	}
	
	/**
	 * Sovrascrizione del metodo equals di Object.
	 * Indica se qualche altro oggetto � "uguale a" questo.
	 * @param obj l'oggetto di riferimento con cui confrontare.
	 * @return true se questo oggetto � lo stesso dell'oggetto dell'argomento; false altrimenti.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Utente other = (Utente) obj;
		return (codiceFiscale.equals(other.codiceFiscale) && 
				cognome.equals(other.cognome) &&
			    dataNascita.equals(other.dataNascita) &&
			    email.equals(other.email) &&
			    luogoNascita.equals(other.luogoNascita) &&
			    nome.equals(other.nome) &&
			    password.equals(other.password)) &&
				sesso.equals(other.sesso) &&
				residenza.equals(other.residenza) &&
				via.equals(other.via) &&
				telefono.equals(other.telefono);
	}


	/**
	 * Sovrascrizione del metodo clone di Object.
	 * Crea e restituisce una copia di questo oggetto.
	 * @return un clone di questa istanza.
	 */
	@Override
	protected Utente clone() {
		try{
			return (Utente) super.clone();
		} 
		catch (CloneNotSupportedException e){
			return null;
		}
	}
}
