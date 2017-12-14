package it.tirociniosmart.model.tirocinio;

/**
 * Classe che applica il pattern proxy ed estende {@link TirocinioDao}
 * 
 * @author UgoMaria
 * @version 0.1
 * 
 */

public class RealTirocinioDao implements TirocinioDao {

  /**
   * Costruttore.
   */
  public RealTirocinioDao() {
    // TODO Auto-generated constructor stub
  }

  @Override
  /**
   * Metodo per inserire un Feedback
   * 
   * @param feedback
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertFeedback(Feedback feedback) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  /**
   * Metodo per inserire un tirocinio
   * 
   * @param tirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertTirocinio(Tirocinio tirocinio) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  /**
   * Metodo che aggiorna un tirocinio
   * 
   * @param newTirocinio
   * @param oldTirocinio
   * @return true quando l'aggiornamento viene effettuata con successo; false altrimenti
   * @invariant not newTirocinio.equals(oldTirocinio)
   */
  public boolean updateTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  /**
   * Metodo che inserisce una richiesta per un tirocinio
   * 
   * @param richiestaTirocinio
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   */
  public boolean insertRichiestaTirocinio(RichiestaTirocinio richiestaTirocinio) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  /**
   * Metodo che aggiorna una richiesta per un tirocinio
   * 
   * @param newRichiesta
   * @param oldRichiesta
   * @return true quando l'aggiunta viene effettuata con successo; false altrimenti
   * @invariant not newRichiesta.stato.equals(oldRichiesta.stato)
   */
  public boolean updateRichiestaTirocinio(RichiestaTirocinio newRichiesta,
      RichiestaTirocinio oldRichiesta) {
    // TODO Auto-generated method stub
    return false;
  }

}
