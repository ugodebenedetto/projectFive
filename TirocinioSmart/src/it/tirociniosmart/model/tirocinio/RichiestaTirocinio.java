package it.tirociniosmart.model.tirocinio;

import it.tirociniosmart.model.utente.Studente;

/**
 * RichiestaTirocinio
 * 
 * @author UgoMaria Questa classe mantiene le informazioni su una richiesta di tirocinio
 * @version 0.1
 * 
 */
public class RichiestaTirocinio {


  /**
   * Costruttore.
   * @param stato stato
   * @param dataRichiesta datarichiesta
   * @param dataRisposta dataRisposta
   * @param richiedente studente richiedente
   * @param tirocinio tirocinio a cui fa riferimento
   */
  public RichiestaTirocinio(String stato, String dataRichiesta, String dataRisposta,
      Studente richiedente, Tirocinio tirocinio) {
    super();
    this.stato = stato;
    this.dataRichiesta = dataRichiesta;
    this.dataRisposta = dataRisposta;
    this.richiedente = richiedente;
    this.tirocinio = tirocinio;
  }

  /**
   * La variabile "stato" può essere associato a tre categorie: inFaseDiApprovazione;
   * richiestaAccettata; richiestaNonAccettata;
   * 
   * @invariant stato.equals(inFaseDiApprovazione) || stato.equals(richiestaAccettata) ||
   *            stato.equals(richiestaNonAccettata)
   */
  private String stato;
  /**
   * dataRichiesta dev'essere maggiore o uguale della data attuale.
   * 
   * @invariant dataRichiesta >= CurrentDate
   */
  private String dataRichiesta;
  private String dataRisposta;
  /**
   * la variabile Studente.
   * 
   * @invariant (richiestaTirocinio.stato.equals(richiestaAccettata) &&
   *            richiestaTirocinio.richiedente)-> not includes(studente)
   */
  private Studente richiedente;
  /**
   * La variabile "tirocinio.numPosti" dev'essere maggiore di 0
   * 
   * @invariant tirocinio.numPosti > 0
   */
  private Tirocinio tirocinio;

  public String getStato() {
    return stato;
  }

  public String getDataRichiesta() {
    return dataRichiesta;
  }

  public String getDataRisposta() {
    return dataRisposta;
  }

  public Studente getRichiedente() {
    return richiedente;
  }

  public Tirocinio getTirocinio() {
    return tirocinio;
  }

  /**
   * 
   * @param stato stato da settare
   * @post stato.equals(inFaseDiApprovazione) || stato.equals(richiestaAccettata) ||
   *       stato.equals(richiestaNonAccettata)
   */
  public void setStato(String stato) {
    this.stato = stato;
  }

  /**
   * setter data.
   * 
   * @param dataRichiesta data richiesta da settare
   */
  public void setDataRichiesta(String dataRichiesta) {
    this.dataRichiesta = dataRichiesta;
  }

  public void setDataRisposta(String dataRisposta) {
    this.dataRisposta = dataRisposta;
  }

  /**
   * set richiedente.
   * 
   * @param richiedente richiedente da settare
   */
  public void setRichiedente(Studente richiedente) {
    this.richiedente = richiedente;
  }

  public void setTirocinio(Tirocinio tirocinio) {
    this.tirocinio = tirocinio;
  }



}
