/**
 * Classe che permette di ottenere un oggetto TirocinioDAO 
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.factory;

public class TirocinioDAOFactory  extends AbstractFactory{
	/**
	 * Override del metodo TirocinioDAO della classe astratta AbstractFactory
	 * @return TirocinioDAO
	 */
		@Override
		public TirocinioDAO getTirocinioDAO() {
			
		}
	/**
	 * Override del metodo UtenteDAO della classe astratta AbstractFactory
	 * @return null
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
