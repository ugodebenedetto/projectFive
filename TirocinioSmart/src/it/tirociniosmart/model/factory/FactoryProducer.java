
/**
 * Classe che permette di ottenere un oggetto producer di Factory per iniettare le classi DAO, è un
 * singleton.
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.utente.UtenteDAO;


public class FactoryProducer {
  /**
   * Il FactoryProducer deve essere consistente per tutte le classi.
   */

  private static volatile FactoryProducer dataSource;

  /**
   * costruttore privato perchè è un singleton.
   */
  private FactoryProducer() {

  }

  /**
   * Permette di ottenere un istanza di FactoryProducer.
   * 
   * @return FactoryProducer
   */
  public static FactoryProducer getIstance() {
    if (dataSource == null) {
      synchronized (DBManager.class) {
        if (dataSource == null) {
          dataSource = new FactoryProducer();


        }
      }
    }
    return dataSource;
  }

  public AbstractFactory getFactory(String choice) {

    if (choice.equalsIgnoreCase("utenteDAO")) {
      return (UtenteDAOFactory) new UtenteDAOFactory();
    } else if (choice.equalsIgnoreCase("tirocinioDAO")) {
      return (TirocinioDAOFactory) new TirocinioDAOFactory();
    } else if (choice.equalsIgnoreCase("annuncioDAO")) {
      return (AnnuncioDAOFactory) new AnnuncioDAOFactory();
    } else {
      return null;
    }
  }


}
