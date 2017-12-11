/**
 * Classe che permette di ottenere un oggetto UtenteDAO 
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.factory;

public class UtenteDAOFactory extends AbstractFactory {
/**
 * Override del metodo TirocinioDAO della classe astratta AbstractFactory
 * @return null
 */
	@Override
	public TirocinioDAO getTirocinioDAO() {
		
	}
/**
 * Override del metodo UtenteDAO della classe astratta AbstractFactory
 * @return UtenteDAO
 */
	@Override
	public UtenteDAO getUtenteDAO() {
		
	}
	/**
	 * Override del metodo AnnuncioDAO della classe astratta AbstractFactory
	 * @return null
	 */
	@Override
	public AnnuncioDAO getAnnuncioDAO() {
	
	}

}
