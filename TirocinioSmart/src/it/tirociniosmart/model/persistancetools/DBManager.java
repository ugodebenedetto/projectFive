
/**
 * Classe che permette la gestione delle connessioni al database, si occupa di istanziarle e gestirle in maniera efficiente, anche grazie
 * al meccanismo di connection pool.
 * @author Armando Ferrara
 * 
 */
package it.tirociniosmart.model.persistancetools;

import it.tirociniosmart.model.factory.FactoryProducer;

public class DBManager {
	/**
	 * Il DBManager deve essere consistente per tutte le classi.
	 */
		private volatile static DBManager dataSource;
		/**
		 * costruttore privato perché è un singleton
		 */
		private DBManager(){
			
		}
		/**
		 * Permette di ottenere un istanza di DBManager
		 * @return DBManager
		 */
		public static  DBManager getIstance()
		{
			
		}
		/**
		 * Restituisce una connessione al database
		 * @return Connection
		 */
		public  Connection getConnection()
		{
			
		}
		/**
		 * Chiude la connessione al database
		 * 
		 */
		public void closeConnection(Connection con){
			
		}
	}


