/**
 * Classe proxy di AnnuncioDAO, permette la visualizzazione degli annunci, per tutte le altre
 * operazioni, fa riferimento all'oggetto "RealAnnuncioDAO" che contiene i metodi per le operazioni
 * riguardanti gli annunci che è possibile effettuare interfacciandosi con il database e il file
 * system.
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.annuncio;

import java.util.ArrayList;

public class ProxyAnnuncioDao implements AnnuncioDao {
  private RealAnnuncioDao realAnnuncioDao;

  /**
   * Permette di selezionare gli annunci, prendendoli dalla cache che è sempre aggiornata con gli
   * ultimi inserimenti.
   * 
   * @return ArrayListAnnuncio
   */
  public ArrayList<Annuncio> selectAnnuncio() {
    return null;

  }

  /**
   * Permette di ricercare un annuncio, tale operazioni viene svolta all'interno della cache, quindi
   * non si interfaccia con il database.
   * 
   * @param annuncio un annuncio
   * @return Annuncio
   */

  public Annuncio findAnnuncio(Annuncio annuncio) {
    return annuncio;

  }

  /**
   * Permette di inserire un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param annuncio un annuncio
   * @return boolean
   */
  @Override
  public boolean insertAnnuncio(Annuncio annuncio) {
    return false;

  }

  /**
   * Permette di rimuovere un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param annuncio un annuncio
   * @return bolean
   */
  @Override
  public boolean removeAnnuncio(Annuncio annuncio) {
    return false;

  }

  /**
   * Permette di aggiornare un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param annuncio un annuncio
   * @return boolean
   */
  @Override
  public boolean updateAnnuncio(Annuncio annuncio) {
    return false;

  }

  /**
   * Permette di aggiornare un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param path path del file
   * @param file file da inserire
   * @return boolean
   */
  @Override
  public boolean insertFile(Part file, String path) {

  }

  /**
   * Permette di rimuovere un file, tale operazioni viene svolta interfacciandosi con il file
   * system, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param path path del file da rimuovere
   * @return boolean
   */
  @Override
  public boolean removeFile(String path) {
    return false;

  }

  /**
   * Permette di sostituire un file, tale operazioni viene svolta interfacciandosi con il file
   * system, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param newFile nuovo file da inserire
   * @param newPath nuovo path in cui inserirlo
   * @param oldPath vecchio path del file
   * @return boolean
   */
  @Override
  public boolean updateFile(Part newFile, String newPath, String oldPath) {

  }


}
