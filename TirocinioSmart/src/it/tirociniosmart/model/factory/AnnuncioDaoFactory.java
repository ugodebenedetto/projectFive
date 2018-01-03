/**
 * Classe che permette di ottenere un oggetto AnnuncioDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public class AnnuncioDaoFactory extends AbstractFactory {
  /**
   * Override del metodo TirocinioDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public TirocinioDAO getTirocinioDao() {
    return null;

  }

  /**
   * Override del metodo UtenteDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public UtenteDAO getUtenteDAO() {
    return null;

  }

  /**
   * Override del metodo AnnuncioDAO della classe astratta AbstractFactory.
   * 
   * @return AnnuncioDAO
   */
  @Override
  public AnnuncioDAO getAnnuncioDao() {
    return null;
  }
}
