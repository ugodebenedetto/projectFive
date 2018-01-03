/**
 * Classe che permette di ottenere un oggetto TirocinioDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDao;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public class TirocinioDAOFactory extends AbstractFactory {
  /**
   * Override del metodo TirocinioDAO della classe astratta AbstractFactory.
   * 
   * @return TirocinioDAO
   */
  @Override
  public TirocinioDAO getTirocinioDao() {
    return (TirocinioDAO) new ProxyTirocinioDAO();

    // get an object of Shape Circle
  }

  /**
   * Override del metodo UtenteDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */
  @Override
  public UtenteDAO getUtenteDao() {
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
