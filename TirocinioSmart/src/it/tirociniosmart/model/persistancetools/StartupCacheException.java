/**
 * Eccezione che si lancia quando fallisce l'inizializzazione della cache.
 */

package it.tirociniosmart.model.persistancetools;

public class StartupCacheException  extends Exception{

  public StartupCacheException() {
    super("Errore nella inizializzazione della cache");
  }

  public StartupCacheException(String messaggio) {
    super("Errore nella inizializzazione della cache, motivo: " + messaggio);
  }


}
