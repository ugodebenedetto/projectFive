/**
 * Classe proxy di AnnuncioDAO, permette la visualizzazione degli annunci, per tutte le altre
 * operazioni, fa riferimento all'oggetto "RealAnnuncioDAO" che contiene i metodi per le operazioni
 * riguardanti gli annunci che è possibile effettuare interfacciandosi con il database e il file
 * system.
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.annuncio;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ProxyAnnuncioDAO implements AnnuncioDAO {
  private RealAnnuncioDAO realAnnuncioDao;
  private DAOCache cache;


  public ProxyAnnuncioDAO() {
    cache = DAOCache.getIstance();

  }

  /**
   * Permette di selezionare gli annunci, prendendoli dalla cache che è sempre aggiornata con gli
   * ultimi inserimenti.
   * 
   * @return ArrayListAnnuncio
   */
  @Override

  public HashMap<String, Annuncio> selectAnnuncio() {
    return cache.getAnnunci();

  }



  /**
   * Permette di ricercare un annuncio, tale operazioni viene svolta all'interno della cache, quindi
   * non si interfaccia con il database.
   * 
   * @param titolo di un annuncio
   * @return Annuncio
   */
  @Override

  public Annuncio findAnnuncio(String titolo) {
    return cache.getAnnunci().get("titolo");
  }

  /**
   * Permette di inserire un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @throws StartupCacheException .
   */
  @Override
  public boolean insertAnnuncio(Annuncio annuncio) throws StartupCacheException {
    return this.getRealAnnuncioDao().insertAnnuncio(annuncio);

  }

  @Override
  public boolean removeAnnuncio(String titolo) throws StartupCacheException {
    // TODO Auto-generated method stub
    return this.getRealAnnuncioDao().removeAnnuncio(titolo);

  }

  @Override
  public boolean updateAnnuncio(Annuncio newAnnuncio, Annuncio oldAnnuncio)
      throws StartupCacheException {
    return this.getRealAnnuncioDao().updateAnnuncio(newAnnuncio, oldAnnuncio);
  }

  @Override
  public boolean insertFile(HttpServletRequest request, String path) {
    // TODO Auto-generated method stub
    return this.getRealAnnuncioDao().insertFile(request, path);
  }

  @Override
  public boolean insertFile(HttpServletRequest request, String path, String fileNameToSave,
      String partFile) throws IOException, ServletException, FileNotSupportedException {
    // TODO Auto-generated method stub
    return this.getRealAnnuncioDao().insertFile(request, path, fileNameToSave, partFile);
  }

  @Override
  public boolean removeFile(String path) {
    // TODO Auto-generated method stub
    return this.getRealAnnuncioDao().removeFile(path);
  }

  @Override
  public boolean updateFile(HttpServletRequest newFile, String newPath, String oldPath) {
    // TODO Auto-generated method stub
    return this.getRealAnnuncioDao().updateFile(newFile, newPath, oldPath);
  }
  /**
   * metodo che restituisce un RealAnnuncioDAO.
   * @return RealAnnuncio DAO
   * @exception SQLException .
   */
  
  public RealAnnuncioDAO getRealAnnuncioDao() {
    if (realAnnuncioDao == null) {
      try {
        this.setRealAnnuncioDao(new RealAnnuncioDAO());
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        System.out.println(e.getMessage());
      }
    }

    return this.realAnnuncioDao;
  }

  public void setRealAnnuncioDao(RealAnnuncioDAO realAnnuncioDao) {
    this.realAnnuncioDao = realAnnuncioDao;
  }

  /**
   * Permette di rimuovere un annuncio, tale operazioni viene svolta interfacciandosi con il
   * database, quindi si richiede una istanza di realAnnuncioDAO.
   * 
   * @param annuncio un annuncio
   * @return bolean
   */
}
