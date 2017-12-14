package it.tirociniosmart.model.tirocinio;

import it.tirociniosmart.model.utente.TutorAccademico;

/**
 * Tirocinio.
 * 
 * @author Davide Questa classe rappresente l'entità tirocinio con i relativi attributi
 *
 */

public class Tirocinio {
  /**
   * Titolo tirocinio
   * 
   * @invariant !titolo.equals("") && titolo != null
   */
  private String titolo;

  /**
   * Descrizione
   * 
   * @invariant !descrizione.equals("") && descrizione != null
   */
  private String descrizione;

  /**
   * Numero posti.
   * 
   * @invariant numPost > 0
   */
  private int numPost;

  /**
   * Tutor accademico associato al tirocinio.
   * 
   * @invariant responsabile != null;
   */
  private TutorAccademico responsabile;

  /**
   * Costruttore.
   * 
   * @param titolo titolo
   * @param descrizione descrizione
   * @param numPost numposti
   * @param responsabile responsabile
   */
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
   * Inserisce il titolo al tirocinio.
   * @param titolo titolo tirocinio da aggiungere
   * @post !titolo.equals("") && titolo != null
   */
  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }


  /**
   * Inserisce la descrizione al tirocinio.
   * @param descrizione descrizione tirocinio da aggiungere
   * @post !descrizione.equals("") && descrizione != null
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }


  /**
   * Inserisce il numero di posti del tirocinio.
   * @param numPost numero posti tirocinio
   * @post numPost > 0
   */
  public void setNumPost(int numPost) {
    this.numPost = numPost;
  }

  /**
   * Inserisce il tutor accademico responsabile del tirocinio.
   * @param responsabile tutor accademico responsabile del tirocinio.
   * @post responsabile != null
   */
  public void setResponsabile(TutorAccademico responsabile) {
    this.responsabile = responsabile;
  }



}
