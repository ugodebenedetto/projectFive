/**
 * Classe che permette di ottenere un oggetto AnnuncioDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;


public class AnnuncioDaoFactory extends AbstractFactory {
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
