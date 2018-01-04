/**
 * Classe astratta che permette una adeguata astrazione fra i livelli relativi alle classi DAO e
 * quello del control.
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.UtenteDAO;

public abstract class AbstractFactory {

  /**
   * Consente l'iniezione di un oggetto TirocinioDAO per gestire le operazioni con il database.
   * 
   * @return TirocinioDAO
   */
  public abstract TirocinioDAO getTirocinioDao();

  /**
   * Consente l'iniezione di un oggetto UtenteDAO per gestire le operazioni con il database.
   * 
   * @return UtenteDAO
   */
  public abstract UtenteDAO getUtenteDao();

  /**
   * Consente l'iniezione di un oggetto AnnuncioDAO per gestire le operazioni con il database.
   * 
   * @return AnnuncioDAO
   */
  public abstract AnnuncioDAO getAnnuncioDao();


}
