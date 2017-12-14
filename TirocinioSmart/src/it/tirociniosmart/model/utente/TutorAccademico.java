package it.tirociniosmart.model.utente;

/**
 * TutorAccademico
 * 
 * @author ClaudioAmato Questa classe rappresenta un TutorAccademico che è una specializzazione di
 *         Utente
 * @version 0.1
 */
public class TutorAccademico extends Utente {

  // Variabili di istanza
  /** Variabile d'istanza che rappresenta il dipartimento del tutor accademico.
   * 
   */
  private String dipartimento;

  // Costruttore
  /**
   * Costruttore.
   * @param email mail 
   * @param codiceFiscale codiceFiscale
   * @param nome nome
   * @param cognome cognome
   * @param luogoNascita luogo nascita
   * @param dataNascita data nascita
   * @param password password
   * @param dipartimento dipartimento
   */
  public TutorAccademico(String email, String codiceFiscale, String nome, String cognome,
      String luogoNascita, String dataNascita, String password, String dipartimento) {
    super(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita, password);
    this.dipartimento = dipartimento;
  }

  // Getters
  /**
   * Ottieni un dipartimento.
   * 
   * @return il dipartimento del tutor accademico
   */
  public String getDipartimento() {
    return dipartimento;
  }

  // Setters
  /**
   * Assegna un dipartimento.
   * 
   * @param dipartimento il dipartimento da assegnare al tutor accademico
   */
  public void setDipartimento(String dipartimento) {
    this.dipartimento = dipartimento;
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
    return super.toString() + "[dipartimento=" + dipartimento + "]";
  }

  /**
   * Sovrascrizione del metodo equals di Object Indica se qualche altro oggetto è "uguale a" questo.
   * 
   * @param obj l'oggetto di riferimento con cui confrontare.
   * @return true se questo oggetto è lo stesso dell'oggetto dell'argomento; false altrimenti.
   */
  @Override
  public boolean equals(Object obj) {
    if (!super.equals(obj)) {
      return false;
    }
    TutorAccademico other = (TutorAccademico) obj;
    return dipartimento.equals(other.dipartimento);
  }

  /**
   * Sovrascrizione del metodo clone di Object Crea e restituisce una copia di questo oggetto.
   * 
   * @return un clone di questa istanza.
   */
  @Override
  protected TutorAccademico clone() {
    TutorAccademico tutorAccademicoCloned = (TutorAccademico) super.clone();
    tutorAccademicoCloned.dipartimento = this.dipartimento;
    return tutorAccademicoCloned;
  }
}
