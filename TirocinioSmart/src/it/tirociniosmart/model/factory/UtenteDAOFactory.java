/**
 * Classe che permette di ottenere un oggetto UtenteDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDao;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.ProxyUtenteDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public class UtenteDAOFactory extends AbstractFactory {
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
   * @return UtenteDAO
   */
  @Override
  public UtenteDAO getUtenteDao() {

    return (UtenteDAO) new ProxyUtenteDAO();

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
