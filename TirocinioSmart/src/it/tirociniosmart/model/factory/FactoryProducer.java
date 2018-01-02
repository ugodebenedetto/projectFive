
/**
 * Classe che permette di ottenere un oggetto producer di Factory per iniettare le classi DAO, è un
 * singleton.
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.factory;

import it.tirociniosmart.model.annuncio.AnnuncioDao;
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
    return dataSource;

  }

  public AbstractFactory getFactory(String choice) {

    if (choice.equalsIgnoreCase("utenteDAO")) {
      return (UtenteDAOFactory) new UtenteDAOFactory();
    } else
      return null;
  }


}
