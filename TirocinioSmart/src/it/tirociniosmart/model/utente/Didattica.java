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



}
