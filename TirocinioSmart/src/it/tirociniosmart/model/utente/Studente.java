package it.tirociniosmart.model.utente;

/**
 * Studente
 * 
 * @author ClaudioAmato Questa classe rappresenta uno Studente che � una specializzazione di Utente
 * @version 0.1
 */
public class Studente extends Utente {

  // Variabili di istanza
  /**
   * Variabile d'istanza che rappresenta la matricola di uno studente.
   * 
   */
  private String matricola;

  /**
   * Variabile d'istanza che rappresenta il tipo di laurea di uno studente.
   * 
   */
  private String tipoLaurea;


  /**
   * costruttore.
   * 
   * @param email email
   * @param codiceFiscale codice fiscale
   * @param nome nome 
   * @param cognome cognome
   * @param luogoNascita luogo di nascita
   * @param dataNascita data di nascita
   * @param password password
   * @param sesso sesso
   * @param residenza residenza
   * @param via via
   * @param telefono telefono
   * @param matricola matricola
   * @param tipoLaurea tipo di laurea
   */
  public Studente(String email, String codiceFiscale, String nome, String cognome,
      String luogoNascita, String dataNascita, String password, String sesso, String residenza,
      String via, String telefono, String matricola, String tipoLaurea) {
    super(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita, password, sesso,
        residenza, via, telefono);
    this.matricola = matricola;
    this.tipoLaurea = tipoLaurea;
  }

  // Getters
  /**
   * Ottieni matricola studente.
   * 
   * @return la matricola dello studente
   */
  public String getMatricola() {
    return matricola;
  }

  /**
   * Ottieni tipo laurea studente.
   * 
   * @return il tipo di laurea dello studente
   */
  public String getTipoLaurea() {
    return tipoLaurea;
  }

  // Setters
  /**
   * Assegna una matricola.
   * 
   * @param matricola la matricola da assegnare allo studente
   */
  public void setMatricola(String matricola) {
    this.matricola = matricola;
  }

  /**
   * Assegna un tipo laurea.
   * 
   * @param tipoLaurea il tipo di laurea da assegnare allo studente
   */
  public void setTipoLaurea(String tipoLaurea) {
    this.tipoLaurea = tipoLaurea;
  }


  // metodi object
  /**
   * Sovrascrizione del metodo toString di Object. Restituisce una stringa che rappresenta
   * testualmente questo oggetto.
   * 
   * @return una rappresentazione in formato stringa dell'oggetto.
   */
  @Override
  public String toString() {
    return super.toString() + "[matricola=" + matricola + ", tipoLaurea=" + tipoLaurea + "]";
  }

  /**
   * Sovrascrizione del metodo equals di Object Indica se qualche altro oggetto � "uguale a" questo.
   * 
   * @param obj l'oggetto di riferimento con cui confrontare.
   * @return true se questo oggetto � lo stesso dell'oggetto dell'argomento; false altrimenti.
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }
    Studente other = (Studente) obj;
    return (matricola.equals(other.matricola) && tipoLaurea.equals(other.tipoLaurea));
  }

  /**
   * Sovrascrizione del metodo clone di Object Crea e restituisce una copia di questo oggetto.
   * 
   * @return un clone di questa istanza.
   */
  @Override
  protected Studente clone() {
    Studente studenteCloned = (Studente) super.clone();
    studenteCloned.matricola = this.matricola;
    studenteCloned.tipoLaurea = this.tipoLaurea;
    return studenteCloned;
  }
}
