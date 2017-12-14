/**
 * Classe che contiene la cache temporanea dei dati presenti all'interno del sistema, viene
 * aggiornata ogni volta che qualche utente si interfaccia con il database per effetuare operazioni
 * di insert o update. Tale classe è inevitabilmente un singleton
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.persistancetools;

import java.sql.ResultSet;

public class DaoCache {
  /**
   * La DAOCache deve essere consistente per tutte le classi.
   */
  public static volatile DaoCache dataSource;
  /**
   * Tutti gli studenti presenti all'interno del sistema .
   */
  private ResultSet studente;
  /**
   * Tutti i tutor accademici presenti all'interno del sistema.
   */
  private ResultSet tutorAccademico;
  /**
   * Tutti la didattica all'interno del sistema.
   */
  private ResultSet didattica;
  /**
   * Tutti gli annunci presenti all'interno del sistema.
   */
  private ResultSet annunci;
  /**
   * Tutte le richieste tirocinio presenti all'interno del sistema.
   */
  private ResultSet richiestaTirocinio;
  /**
   * Tutti i tirocini presenti all'interno del sistema.
   */
  private ResultSet tirocini;
  /**
   * Tutti i feedback presenti all'interno del sistema.
   */
  private ResultSet feedback;

  public static DaoCache getIstance() {

  }

  /**
   * costruttore privato perché è un singleton.
   */
  private DaoCache() {

  }

  /**
   * Permette di ottenere un istanza di DAOCache.
   * 
   * @return DAOCache
   */
  public static DaoCache getIstance() {}

  public ResultSet getStudente() {
    return studente;
  }

  public void setStudente(ResultSet studente) {
    this.studente = studente;
  }

  public ResultSet getTutorAccademico() {
    return tutorAccademico;
  }

  public void setTutorAccademico(ResultSet tutorAccademico) {
    this.tutorAccademico = tutorAccademico;
  }

  public ResultSet getDidattica() {
    return didattica;
  }

  public void setDidattica(ResultSet didattica) {
    this.didattica = didattica;
  }

  public ResultSet getAnnunci() {
    return annunci;
  }

  public void setAnnunci(ResultSet annunci) {
    this.annunci = annunci;
  }

  public ResultSet getRichiestaTirocinio() {
    return richiestaTirocinio;
  }

  public void setRichiestaTirocinio(ResultSet richiestaTirocinio) {
    this.richiestaTirocinio = richiestaTirocinio;
  }

  public ResultSet getTirocini() {
    return tirocini;
  }

  public void setTirocini(ResultSet tirocini) {
    this.tirocini = tirocini;
  }

  public ResultSet getFeedback() {
    return feedback;
  }

  public void setFeedback(ResultSet feedback) {
    this.feedback = feedback;
  }

}
