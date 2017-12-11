/**
 * Classe che permette di ottenere un oggetto AnnuncioDAO
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.factory;

public class AnnuncioDAOFactory {
	/**
	 * Override del metodo TirocinioDAO della classe astratta AbstractFactory
	 * @return null
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
		 * @return AnnuncioDAO
		 */
		@Override
		public AnnuncioDAO getAnnuncioDAO() {
		
		}
}
