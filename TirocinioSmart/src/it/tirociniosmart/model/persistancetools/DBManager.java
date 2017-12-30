
/**
 * Classe che permette la gestione delle connessioni al database, si occupa di istanziarle e
 * gestirle in maniera efficiente, anche grazie al meccanismo di connection pool.
 * 
 * @author Armando Ferrara
 * 
 */

/**
 * Classe che permette la gestione delle connessioni al database, si occupa di istanziarle e
 * gestirle in maniera efficiente, anche grazie al meccanismo di connection pool.
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.persistancetools;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class DBManager {
  /**
   * Il DBManager deve essere consistente per tutte le classi. Si collega al connection pool di
   * tomcat.
   */
  private static volatile DBManager dataSource;
  private PoolProperties p;
  private DataSource dataS;
  /*
   * QUESTO BISOGNA MODIFICARLO IN BASE ALLE IMPOSTAZIONI DI MYSQL COMMUNITY
   */
  // url del collegamento a mysql
  private final String url = "jdbc:mysql://127.0.0.1:3306/?user=armando";
  // username di collegamento a mysql
  private final String username = "armando";
  // password utilizzata per collegarsi a mysql
  private final String password = "cazziTua";
  /*
   * FINE MODIFICHE DA EFFETTUARE
   */



  /**
   * costruttore privato perchè è un singleton.
   */
  private DBManager() {

  }

  /**
   * Permette di ottenere un istanza di DBManager.
   * 
   * @return DBManager
   */
  public static DBManager getIstance() throws SQLException {
    if (dataSource == null) {
      synchronized (DBManager.class) {
        if (dataSource == null) {
          dataSource = new DBManager();
          dataSource.setPoolProprietes();
          dataSource.setDataSource();

        }
      }
    }
    return dataSource;


  }

  /**
   * Restituisce una connessione al database.
   * 
   * @return Connection
   */
  public Connection getConnection() throws SQLException {


    return dataS.getConnection();


  }

  /**
   * Prendiamo il dataSource che ci servir� per richiedere connessioni al connection pool di tomcat.
   * 
   * @return DataSource
   */
  private void setPoolProprietes() {
    p = new PoolProperties();
    p.setUrl(url);
    p.setDriverClassName("com.mysql.jdbc.Driver");
    p.setUsername(username);
    p.setPassword(password);
    p.setJmxEnabled(true);
    p.setTestWhileIdle(false);
    p.setTestOnBorrow(true);
    p.setValidationQuery("SELECT 1");
    p.setTestOnReturn(false);
    p.setValidationInterval(30000);
    p.setTimeBetweenEvictionRunsMillis(30000);
    p.setMaxActive(400);
    p.setInitialSize(10);
    p.setMaxWait(10000);
    p.setRemoveAbandonedTimeout(60);
    p.setMinEvictableIdleTimeMillis(30000);
    p.setMinIdle(10);
    p.setLogAbandoned(true);
    p.setRemoveAbandoned(true);
    p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
        + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");

  }

  private void setDataSource() throws SQLException {
    dataS = new DataSource();
    dataS.setPoolProperties(p);

  }

  /**
   * Chiude la connessione al database.
   * 
   */
  public void closeConnection(Connection con) throws SQLException {

    con.close();
  }

}

