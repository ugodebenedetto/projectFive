package it.tirociniosmart.model.utente;

/**
 * Didattica
 * 
 * @author ClaudioAmato Questa classe rappresenta un Direttore che � una specializzazione di Utente
 * @version 0.2
 */
public class Didattica extends Utente {

  // Variabili di istanza
  /**
   * Variabile d'istanza che rappresenta la condizione se � direttore o didattica.
   * 
   */
  private boolean direttore;

  // Costruttore
  /**
   * Costruttore.
   * 
   * @param email mail
   * @param codiceFiscale codiceFisclae
   * @param nome nome
   * @param cognome cognome
   * @param luogoNascita luogo di nascita
   * @param dataNascita data di nascita
   * @param password password
   * @param sesso sesso
   * @param residenza residenza
   * @param via via
   * @param telefono telefono
   * @param direttore direttore
   */
  public Didattica(String email, String codiceFiscale, String nome, String cognome,
      String luogoNascita, String dataNascita, String password, String sesso, String residenza,
      String via, String telefono, boolean direttore) {
    super(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita, password, sesso,
        residenza, via, telefono);
    this.direttore = direttore;
  }

  public Didattica() {
    // TODO Auto-generated constructor stub
  }

  // Getters
  /**
   * Ottieni direttore.
   * 
   * @return true se � didattica; false se � direttore
   */
  public boolean getDirettore() {
    return direttore;
  }

  // Setters
  /**
   * Assegna didattica/direttore.
   * 
   * @param direttore la didattica se � true; il direttore se � false
   */
  public void setDirettore(boolean direttore) {
    this.direttore = direttore;
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
    return super.toString() + "[direttore=" + direttore + "]";
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
    Didattica other = (Didattica) obj;
    return (direttore == other.direttore);
  }

  /**
   * Sovrascrizione del metodo clone di Object Crea e restituisce una copia di questo oggetto.
   * 
   * @return un clone di questa istanza.
   */
  @Override
  protected Didattica clone() {
    Didattica didatticaCloned = (Didattica) super.clone();
    didatticaCloned.direttore = this.direttore;
    return didatticaCloned;
  }
}
