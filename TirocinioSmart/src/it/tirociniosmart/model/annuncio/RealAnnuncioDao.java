/**
 * Classe che contiene i metodi per le operazioni riguardanti gli annunci che è possibile effettuare
 * interfacciandosi con il database e il file system.
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.annuncio;

public class RealAnnuncioDao implements AnnuncioDao {
  /**
   * Permette di inserire un annuncio, tale operazioni viene svolta all'interno del database quindi
   * bisogna interfacciarsi con il database. Una volta inserito l'annuncio, bisogna aggiornare la
   * cache per mantenere coerente l'interno sistema.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().add(annuncio)
   */
  @Override
  public boolean insertAnnuncio(Annuncio annuncio) {
    return false;

  }

  /**
   * Permette di rimuovere un annuncio, tale operazioni viene svolta all'interno del database quindi
   * bisogna interfacciarsi con il database. Una volta rimosso l'annuncio, bisogna aggiornare la
   * cache per mantenere coerente l'interno sistema.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().remove(annuncio)
   */
  @Override
  public boolean removeAnnuncio(Annuncio annuncio) {

  }

  /**
   * Permette di aggiornare un annuncio, tale operazioni viene svolta all'interno del database
   * quindi bisogna interfacciarsi con il database. Una volta aggiornato l'annuncio , bisogna
   * aggiornare la cache per mantenere coerente l'interno sistema.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().update(annuncio)
   */
  @Override
  public boolean updateAnnuncio(Annuncio annuncio) {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * Permette di inserire un file, tale operazioni viene svolta all'interno del file system quindi
   * bisogna interfacciarsi con il il file system.
   * 
   * @param file file da inserire
   * @param path path dove inserire il file
   * @return boolean
   */
  @Override
  public boolean insertFile(Part file, String path) {

  }

  /**
   * Permette di rimuovere un file, tale operazioni viene svolta all'interno del file system quindi
   * bisogna interfacciarsi con il il file system.
   * 
   * @param path path del file da rimuovere
   * @return boolean
   */
  @Override
  public boolean removeFile(String path) {

  }

  /**
   * Permette di sostituire un file, tale operazioni viene svolta all'interno del file system quindi
   * bisogna interfacciarsi con il il file system.
   * 
   * @param newFile nuovo file
   * @param newPath nuovo path del file
   * @param oldPath vecchio path
   * @return boolean
   */
  @Override
  public boolean updateFile(Part newFile, String newPath, String oldPath) {

  }

}
