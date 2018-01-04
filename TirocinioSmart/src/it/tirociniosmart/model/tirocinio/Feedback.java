package it.tirociniosmart.model.tirocinio;

import it.tirociniosmart.model.utente.Studente;

public class Feedback {
  /**
   * id
   *
   */

  private int id;


  /**
   * Tirocinio.
   */
  private Tirocinio tirocinio;

  /**
   * Studente.
   */
  private Studente studente;

  /**
   * Data invio feedback.
   * 
   * @invariant dataInvio >= CurrentDate
   */
  private String dataInvio;

  /**
   * Valutazione tirocinio.
   */
  private int valutazione;

  /**
   * Commento.
   */
  private String commento;


  /**
   * Costruttore.
   * 
   * @param tirocinio tirocinio a cui si riferisce il feedback
   * @param studente studente a cui si riferisce lo studente
   * @param dataInvio data di invio
   * @param valutazione valutazione
   * @param commento commento al feedback
   */
  public Feedback(int id, Tirocinio tirocinio, Studente studente, String dataInvio, int valutazione,
      String commento) {
    super();
    this.setId(id);
    this.tirocinio = tirocinio;
    this.studente = studente;
    this.dataInvio = dataInvio;
    this.valutazione = valutazione;
    this.commento = commento;
  }

  public Feedback(Tirocinio tirocinio, Studente studente, String dataInvio, int valutazione,
      String commento) {
    super();
    this.tirocinio = tirocinio;
    this.studente = studente;
    this.dataInvio = dataInvio;
    this.valutazione = valutazione;
    this.commento = commento;
  }

  public Feedback() {
    // TODO Auto-generated constructor stub
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


  public int getValutazione() {
    return valutazione;
  }


  public String getCommento() {
    return commento;
  }

  /**
   * Set tirocinio.
   * 
   * @param tirocinio da settare
   * @post tirocinio != null
   */
  public void setTirocinio(Tirocinio tirocinio) {
    this.tirocinio = tirocinio;
  }

  /**
   * set studente.
   * 
   * @param studente da settare
   * @post studente != null
   */
  public void setStudente(Studente studente) {
    this.studente = studente;
  }

  /**
   * set data.
   * 
   * @param dataInvio data da settare
   * @post dataInvio >= currentDate
   */
  public void setDataInvio(String dataInvio) {
    this.dataInvio = dataInvio;
  }

  /**
   * set valutazione.
   * 
   * @param valutazione valutazione da settare
   */
  public void setValutazione(int valutazione) {
    this.valutazione = valutazione;
  }

  /**
   * set commento.
   * 
   * @param commento commento da settare
   */
  public void setCommento(String commento) {
    this.commento = commento;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


}
