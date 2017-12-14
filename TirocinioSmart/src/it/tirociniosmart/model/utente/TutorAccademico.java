package it.tirociniosmart.model.utente;

/**
 * TutorAccademico
 * 
 * @author ClaudioAmato Questa classe rappresenta un TutorAccademico che è una specializzazione di
 *         Utente
 * @version 0.2
 */
public class TutorAccademico extends Utente {

  // Variabili di istanza
  /**
   * Variabile d'istanza che rappresenta il dipartimento del tutor accademico.
   * 
   */
  private String dipartimento;

  /**
   * Variabile d'istanza che rappresenta il codice del docente
   * 
   */
  private String codiceDocente;

  // Costruttore
  /**
   * costruttore.
   * 
   * @param email
   * @param codiceFiscale
   * @param nome
   * @param cognome
   * @param luogoNascita
   * @param dataNascita
   * @param password
   * @param sesso
   * @param residenza
   * @param via
   * @param telefono
   * @param dipartimento
   * @param codiceDocente
   */
  public TutorAccademico(String email, String codiceFiscale, String nome, String cognome,
      String luogoNascita, String dataNascita, String password, String sesso, String residenza,
      String via, String telefono, String dipartimento, String codiceDocente) {
    super(email, codiceFiscale, nome, cognome, luogoNascita, dataNascita, password, sesso,
        residenza, via, telefono);
    this.dipartimento = dipartimento;
    this.codiceDocente = codiceDocente;
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

  /**
   * Ottieni un codice docente.
   * 
   * @return il codice docente del tutor accademico
   */
  public String getCodiceDocente() {
    return codiceDocente;
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

  /**
   * Assegna un codice docente.
   * 
   * @param codiceDocente il da assegnare al tutor accademico
   */
  public void setCodiceDocente(String codiceDocente) {
    this.codiceDocente = codiceDocente;
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
    return super.toString() + "[dipartimento=" + dipartimento + ", codiceDocente=" + codiceDocente
        + "]";
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
    return (dipartimento.equals(other.dipartimento) && codiceDocente.equals(other.codiceDocente));
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
    tutorAccademicoCloned.codiceDocente = this.codiceDocente;
    return tutorAccademicoCloned;
  }
}
