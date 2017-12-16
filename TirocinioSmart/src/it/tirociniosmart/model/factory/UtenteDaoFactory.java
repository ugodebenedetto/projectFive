/**
 * Classe che permette di ottenere un oggetto UtenteDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDao;
import it.tirociniosmart.model.utente.UtenteDao;

public class UtenteDaoFactory extends AbstractFactory {
  /**
   * Override del metodo TirocinioDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public TirocinioDao getTirocinioDao() {
    return null;

  }

  /**
   * Override del metodo UtenteDAO della classe astratta AbstractFactory.
   * 
   * @return UtenteDAO
   */
  @Override
  public UtenteDao getUtenteDao() {
    return null;

  }

  /**
   * Override del metodo AnnuncioDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public AnnuncioDao getAnnuncioDao() {
    return null;

  }

}
