/**
 * Classe che contiene la cache temporanea dei dati presenti all'interno del sistema, viene
 * aggiornata ogni volta che qualche utente si interfaccia con il database per effetuare operazioni
 * di insert o update. Tale classe è inevitabilmente un singleton
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.persistancetools;

import java.sql.ResultSet;

public class DAOCache {
  /**
   * La DAOCache deve essere consistente per tutte le classi.
   */
  private volatile static  DAOCache dataSource;
  /**
   * Tutti gli studenti presenti all'interno del sistema .
   */
  private ResultSet studenti;
  /**
   * Tutti i tutor accademici presenti all'interno del sistema.
   */
  private ResultSet tutorAccademici;
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
  private ResultSet richiesteTirocinio;
  /**
   * Tutti i tirocini presenti all'interno del sistema.
   */
  private ResultSet tirocini;
  /**
   * Tutti i feedback presenti all'interno del sistema.
   */
  private ResultSet feedback;

  public static DAOCache getIstance() {
    if(dataSource==null){
      synchronized(DAOCache.class){
        if(dataSource==null){
          dataSource=new DAOCache();
        }
      }
    }
    return dataSource;

  }

  /**
   * costruttore privato perchè è un singleton.
   */
  private DAOCache() {

  }

  /**
   * Permette di ottenere un istanza di DAOCache.
   * 
   * @return DAOCache
   */

  public ResultSet getStudenti() {
    
    return studenti;
  }

  public void setStudenti(ResultSet studente) {
    studenti=studente;
  }

  public ResultSet getTutorAccademici() {
    return tutorAccademici;
  }

  public void setTutorAccademici(ResultSet tutorAccademico) {
    this.tutorAccademici = tutorAccademico;
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

  public ResultSet getRichiesteTirocinio() {
    return richiesteTirocinio;
  }

  public void setRichiesteTirocinio(ResultSet richiestaTirocinio) {
    this.richiesteTirocinio = richiestaTirocinio;
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
