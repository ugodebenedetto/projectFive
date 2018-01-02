/**
 * Classe che contiene la cache temporanea dei dati presenti all'interno del sistema, viene
 * aggiornata ogni volta che qualche utente si interfaccia con il database per effetuare operazioni
 * di insert o update. Tale classe Ã¨ inevitabilmente un singleton
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.persistancetools;

import java.sql.ResultSet;
import java.util.HashMap;

import it.tirociniosmart.model.utente.Didattica;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

public class DAOCache {
  /**
   * La DAOCache deve essere consistente per tutte le classi.
   */
  public static volatile DAOCache dataSource;
  /**
   * Tutti gli studenti presenti all'interno del sistema .
   */
  private HashMap<String, Studente> studente;
  /**
   * Tutti i tutor accademici presenti all'interno del sistema.
   */
  private HashMap<String, TutorAccademico> tutorAccademico;

  /**
   * Tutti la didattica all'interno del sistema.
   */
  private HashMap<String, Didattica> didattica;
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

  /**
   * Permette di ottenere un istanza di DAOCache.
   * 
   * @return DAOCache
   */
  public static DAOCache getIstance() {
    if (dataSource == null) {
      synchronized (DAOCache.class) {
        if (dataSource == null) {
          dataSource = new DAOCache();

        }
      }
    }
    return dataSource;

  }

  /**
   * costruttore privato perchÃ¨ Ã¨ un singleton.
   */
  private DAOCache() {

  }

  /**
   *
   * Potrebbero esserci più aggiornamenti della cache, mettendo synchronized, rendo ciò sincrono fra
   * tutte le chiamate.
   * 
   * @throws StartupCacheException
   */
  public synchronized void updateStudente(String operation, String email, Studente st)
      throws StartupCacheException {
    if (studente == null) {
      throw new StartupCacheException(
          "La cache risulta vuota, ciò non è possibile perché inizializzata ad avvio server. Controlla i motivi.");
    }
    if (operation.equals("update")) {
      HashMap<String, Studente> tmp = studente;
      tmp.remove(email);
      tmp.put(st.getEmail(), st);
      this.setStudente(tmp);
    } else if (operation.equals("insert")) {
      HashMap<String, Studente> tmp = studente;
      tmp.put(email, st);
      this.setStudente(tmp);
    }

  }

  /**
   *
   * Potrebbero esserci più aggiornamenti della cache, mettendo synchronized, rendo ciò sincrono fra
   * tutte le chiamate.
   * 
   * @throws StartupCacheException
   */
  public synchronized void updateTutorAccademico(String operation, String email,
      TutorAccademico tutor) throws StartupCacheException {
    if (tutorAccademico == null) {
      throw new StartupCacheException(
          "La cache risulta vuota, ciò non è possibile perché inizializzata ad avvio server. Controlla i motivi.");
    }

    if (operation.equals("update")) {
      HashMap<String, TutorAccademico> tmp = tutorAccademico;
      tmp.remove(email);
      tmp.put(tutor.getEmail(), tutor);
      this.setTutorAccademico(tmp);
    } else if (operation.equals("insert")) {
      HashMap<String, TutorAccademico> tmp = tutorAccademico;
      tmp.put(email, tutor);
      this.setTutorAccademico(tmp);
    }
  }

  /**
   *
   * Potrebbero esserci più aggiornamenti della cache, mettendo synchronized, rendo ciò sincrono fra
   * tutte le chiamate.
   * 
   * @throws StartupCacheException
   */
  public synchronized void updateDidattica(String operation, String email, Didattica did)
      throws StartupCacheException {
    if (didattica == null) {

      throw new StartupCacheException(
          "La cache risulta vuota, ciò non è possibile perché inizializzata ad avvio server. Controlla i motivi.");
    }

    if (operation.equals("update")) {
      HashMap<String, Didattica> tmp = didattica;
      tmp.remove(email);
      tmp.put(did.getEmail(), did);
      this.setDidattica(tmp);
    } else if (operation.equals("insert")) {
      HashMap<String, Didattica> tmp = didattica;
      tmp.put(email, did);
      this.setDidattica(tmp);
    }
  }

  public HashMap<String, Studente> getStudente() {
    return studente;
  }

  public void setStudente(HashMap<String, Studente> studente) {
    this.studente = studente;
  }

  public HashMap<String, TutorAccademico> getTutorAccademico() {
    return tutorAccademico;
  }

  public void setTutorAccademico(HashMap<String, TutorAccademico> tutorAccademico) {
    this.tutorAccademico = tutorAccademico;
  }

  public HashMap<String, Didattica> getDidattica() {
    return didattica;
  }

  public void setDidattica(HashMap<String, Didattica> didattica) {
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
