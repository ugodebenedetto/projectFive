
/**
 * Classe che permette la gestione delle connessioni al database, si occupa di istanziarle e
 * gestirle in maniera efficiente, anche grazie al meccanismo di connection pool.
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.persistancetools;

import it.tirociniosmart.model.factory.FactoryProducer;

public class DbManager {
  /**
   * Il DBManager deve essere consistente per tutte le classi.
   */
  private static volatile DbManager dataSource;

  /**
   * costruttore privato perchè è un singleton.
   */
  private DbManager() {

  }

  /**
   * Permette di ottenere un istanza di DBManager.
   * 
   * @return DBManager
   */
  public static DbManager getIstance() {
    return dataSource;

  }

  /**
   * Restituisce una connessione al database.
   * 
   * @return Connection
   */
  public Connection getConnection() {

  }

  /**
   * Chiude la connessione al database.
   * 
   */
  public void closeConnection(Connection con) {

  }
}


