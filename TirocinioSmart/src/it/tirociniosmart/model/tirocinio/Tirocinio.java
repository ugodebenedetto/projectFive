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
   * @invariant !nome.equals("") && titolo != null
   */
  private String nome;
  private String obiettivi;

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
  private int id;
  /**
   * Tutor accademico associato al tirocinio.
   * 
   * @invariant responsabile != null;
   */
  private TutorAccademico tutor;
  private String sede;
  private String tipo;
  private String responsabile;
  private String stato;
  /**
   * Costruttore.
   * 
   * @param titolo titolo
   * @param descrizione descrizione
   * @param numPost numposti
   * @param responsabile responsabile
   */



  public String getNome() {
    return nome;
  }


  public Tirocinio(String nome, String obiettivi, String descrizione, int numPost, int id,
      TutorAccademico tutor, String sede, String tipo, String responsabile) {
    super();
    this.nome = nome;
    this.obiettivi = obiettivi;
    this.descrizione = descrizione;
    this.numPost = numPost;
    this.id = id;
    this.tutor = tutor;
    this.sede = sede;
    this.tipo = tipo;
    this.responsabile = responsabile;
  }


  public Tirocinio(String nome, String obiettivi, String descrizione, int numPost,
      TutorAccademico tutor, String sede, String tipo, String responsabile) {
    super();
    this.nome = nome;
    this.obiettivi = obiettivi;
    this.descrizione = descrizione;
    this.numPost = numPost;
    this.tutor = tutor;
    this.sede = sede;
    this.tipo = tipo;
    this.responsabile = responsabile;
  }

  public Tirocinio() {
    // TODO Auto-generated constructor stub
  }


  public String getObiettivi() {
    return obiettivi;
  }


  public void setObiettivi(String obiettivi) {
    this.obiettivi = obiettivi;
  }


  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public TutorAccademico getTutor() {
    return tutor;
  }


  public void setTutor(TutorAccademico tutor) {
    this.tutor = tutor;
  }


  public String getSede() {
    return sede;
  }


  public void setSede(String sede) {
    this.sede = sede;
  }


  public String getTipo() {
    return tipo;
  }


  public void setTipo(String tipo) {
    this.tipo = tipo;
  }


  public String getDescrizione() {
    return descrizione;
  }


  public int getNumPost() {
    return numPost;
  }


  public String getResponsabile() {
    return responsabile;
  }


  /**
   * Inserisce il titolo al tirocinio.
   * 
   * @param titolo titolo tirocinio da aggiungere
   * @post !titolo.equals("") && titolo != null
   */
  public void setNome(String nome) {
    this.nome = nome;
  }


  /**
   * Inserisce la descrizione al tirocinio.
   * 
   * @param descrizione descrizione tirocinio da aggiungere
   * @post !descrizione.equals("") && descrizione != null
   */
  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }


  /**
   * Inserisce il numero di posti del tirocinio.
   * 
   * @param numPost numero posti tirocinio
   * @post numPost > 0
   */
  public void setNumPost(int numPost) {
    this.numPost = numPost;
  }

  /**
   * Inserisce il tutor accademico responsabile del tirocinio.
   * 
   * @param responsabile tutor accademico responsabile del tirocinio.
   * @post responsabile != null
   */
  public void setResponsabile(String responsabile) {
    this.responsabile = responsabile;
  }


  public String getStato() {
    return stato;
  }


  public void setStato(String stato) {
    this.stato = stato;
  }



}
