/**
 * Classe che permette di ottenere un oggetto AnnuncioDAO
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public class AnnuncioDAOFactory extends AbstractFactory {
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
   * Override del metodo AnnuncioDAO della classe astratta AbstractFactory.
   * 
   * @return AnnuncioDAO
   */
  @Override
  public AnnuncioDAO getAnnuncioDao() {
    return (AnnuncioDAO) new ProxyAnnuncioDAO();

  }

  /**
   * Override del metodo UtenteDAO della classe astratta AbstractFactory.
   * 
   * @return null
   */

  @Override
  public UtenteDAO getUtenteDao() {
    // TODO Auto-generated method stub
    return null;
  }
}
