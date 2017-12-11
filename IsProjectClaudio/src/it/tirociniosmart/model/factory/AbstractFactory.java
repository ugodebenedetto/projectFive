/**
 * Classe astratta che permette una adeguata astrazione fra i livelli relativi alle classi DAO  e quello del control. 
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.factory;
public abstract class AbstractFactory {

	/**
	 * Consente l'iniezione di un oggetto TirocinioDAO per gestire le  operazioni con il database.
	 * @return TirocinioDAO
	 */
	abstract public  TirocinioDAO getTirocinioDAO();
	/**
	 * Consente l'iniezione di un oggetto UtenteDAO per gestire le  operazioni con il database.
	 * @return UtenteDAO
	 */
	abstract public  UtenteDAO getUtenteDAO();
	/**
	 * Consente l'iniezione di un oggetto AnnuncioDAO per gestire le  operazioni con il database.
	 * @return AnnuncioDAO
	 */
	abstract public AnnuncioDAO getAnnuncioDAO();
	
	
}
