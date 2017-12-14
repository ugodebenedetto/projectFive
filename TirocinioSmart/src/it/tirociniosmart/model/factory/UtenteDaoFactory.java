/**
 * Classe che permette di ottenere un oggetto UtenteDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

public class UtenteDaoFactory extends AbstractFactory {
  /**
   * Override del metodo TirocinioDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public TirocinioDao getTirocinioDao() {

  }

  /**
   * Override del metodo UtenteDAO della classe astratta AbstractFactory.
   * 
   * @return UtenteDAO
   */
  @Override
  public UtenteDao getUtenteDao() {

  }

  /**
   * Override del metodo AnnuncioDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public AnnuncioDao getAnnuncioDao() {

  }

}
