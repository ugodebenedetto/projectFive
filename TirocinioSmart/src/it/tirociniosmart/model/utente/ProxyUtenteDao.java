package it.tirociniosmart.model.utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.DBManager;

/**
 * ProxyUtenteDAO
 * 
 * @author ClaudioAmato Questa classe rappresenta ...
 * @version 0.1
 */

public class ProxyUtenteDao implements UtenteDao {

  // Variabili di istanza
  private RealUtenteDao realUtenteDao;
  private DAOCache cache;

  // Costruttore
  public ProxyUtenteDao() {
    cache = DAOCache.getIstance();
  }
  /**
   * Costruttore.
   * 
   * @param realUtenteDao annuncio
   */


  // Getters
  /**
   * Ottieni ...
   * 
   * @return realAnnuncioDao
   */
  public RealUtenteDao getRealUtenteDao() {
    return realUtenteDao;
  }

  /**
   * Assegna ...
   * 
   * @param realUtenteDao annuncio
   */
  // Setters
  public void setRealUtenteDao(RealUtenteDao realUtenteDao) {
    this.realUtenteDao = realUtenteDao;
  }


  // Metodi dell'interfaccia UtendeDAO
  @Override
  public boolean inserStudente(Studente studente) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean updateStudente(Studente newStudente, Studente oldStudente) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean inserTutorAccademico(TutorAccademico tutorAccademico) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean updateTutorAccademico(TutorAccademico newTutorAccademico,
      TutorAccademico oldTutorAccademico) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean updateDidattica(Didattica newDidattica, Didattica oldDidattica) {
    // TODO Auto-generated method stub
    return false;
  }

  // metodi di classe
  /**
   * Questo metodo seleziona tutti gli studenti dal database.
   * 
   * @return l'arraylist degli studenti selezionati
   * @throws SQLException
   */
  public ArrayList<Studente> selectStudente() throws SQLException {
    ResultSet array = cache.getStudente();
    boolean moreElements = false;
    moreElements = array.next();
    ArrayList<Studente> studenti = new ArrayList<Studente>();
    if (moreElements) {
      Studente x;
      while (moreElements) {
        x = new Studente();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setMatricola(array.getString("matricola"));
        x.setTipoLaurea(array.getString("tipoLaurea"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setMatricola(array.getString("matricola"));
        x.setTipoLaurea(array.getString("tipoLaurea"));
        x.setTelefono(array.getString("telefono"));
        studenti.add(x);
      }
      return studenti;
    } else
      return null;

  }

  /**
   * Questo metodo seleziona tutti i tutor accademici dal database.
   * 
   * @return l'arraylist dei tutor accademici selezionati
   * @throws SQLException
   */
  public ArrayList<TutorAccademico> selectTutorAccademico() throws SQLException {
    ResultSet array = cache.getTutorAccademico();
    boolean moreElements = false;
    moreElements = array.next();
    ArrayList<TutorAccademico> tutorAccademici = new ArrayList<TutorAccademico>();
    if (moreElements) {
      TutorAccademico x;
      while (moreElements) {
        x = new TutorAccademico();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setDipartimento(array.getString("dipartimento"));
        x.setCodiceDocente(array.getString("codiceDocente"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setTelefono(array.getString("telefono"));
        tutorAccademici.add(x);
      }
      return tutorAccademici;
    } else
      return null;

  }

  /**
   * Questo metodo seleziona tutta la didattica dal database.
   * 
   * @return l'arraylist di didattica selezionata
   * @throws SQLException
   */
  public ArrayList<Didattica> selectDidattica() throws SQLException {
    ResultSet array = cache.getDidattica();
    boolean moreElements = false;
    moreElements = array.next();
    ArrayList<Didattica> arrayDidattica = new ArrayList<Didattica>();
    if (moreElements) {
      Didattica x;
      while (moreElements) {
        x = new Didattica();
        x.setCodiceFiscale(array.getString("codiceFiscale"));
        x.setNome(array.getString("nome"));
        x.setCognome(array.getString("cognome"));
        x.setDataNascita(array.getString("dataNascita"));
        x.setLuogoNascita(array.getString("luogoNascita"));
        x.setEmail(array.getString("email"));
        x.setPassword(array.getString("password"));
        x.setDirettore(array.getBoolean("direttore"));
        x.setVia(array.getString("via"));
        x.setResidenza(array.getString("residenza"));
        x.setSesso(array.getString("sesso"));
        x.setTelefono(array.getString("telefono"));
        arrayDidattica.add(x);
      }
      return arrayDidattica;
    } else
      return null;

  }

  /**
   * Cerca uno studente all'interno del database.
   * 
   * @param studente lo studente da cercare
   * @return lo studente trovato (se esiste)
   */
  public Studente findStudente(Studente studente) {
    // TODO
    return null;
  }

  /**
   * Cerca una didattica all'interno del database.
   * 
   * @param didattica la didattica da cercare
   * @return la didattica trovata (se esiste)
   */
  public Didattica findDidattica(Didattica didattica) {
    // TODO
    return null;
  }

  /**
   * Cerca un tutor accademico all'interno del database.
   * 
   * @param tutorAccademico il tutor accademico da cercare
   * @return il tutor accademico trovato (se esiste)
   */
  public TutorAccademico findTutorAccademico(TutorAccademico tutorAccademico) {
    // TODO
    return null;
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
    return getClass().getName() + "[realUtenteDAO=" + realUtenteDao + "]";
  }

  /**
   * Sovrascrizione del metodo equals di Object Indica se qualche altro oggetto è "uguale a"
   * questo.
   * 
   * @param obj l'oggetto di riferimento con cui confrontare.
   * @return true se questo oggetto è lo stesso dell'oggetto dell'argomento; false altrimenti.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ProxyUtenteDao other = (ProxyUtenteDao) obj;
    return realUtenteDao.equals(other.realUtenteDao);
  }

  /**
   * Sovrascrizione del metodo clone di Object. Crea e restituisce una copia di questo oggetto.
   * 
   * @return un clone di questa istanza.
   */
  @Override
  protected Object clone() {
    try {
      return (ProxyUtenteDao) super.clone();
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
