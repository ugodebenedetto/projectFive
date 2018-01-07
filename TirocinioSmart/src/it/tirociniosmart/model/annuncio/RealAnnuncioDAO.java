/**
 * Classe che contiene i metodi per le operazioni riguardanti gli annunci che è possibile
 * effettuare interfacciandosi con il database e il file system.
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.annuncio;

import it.tirociniosmart.model.persistancetools.DAOCache;
import it.tirociniosmart.model.persistancetools.DBManager;
import it.tirociniosmart.model.persistancetools.FileManager;
import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class RealAnnuncioDAO implements AnnuncioDAO {


  private DBManager manager;
  private DAOCache cache;
  private FileManager fmanager;

  /**
   * costruttore di RealAnnuncioDAO.
   * 
   * @throws SQLException .
   */

  public RealAnnuncioDAO() throws SQLException {
    manager = DBManager.getIstance();
    cache = DAOCache.getIstance();
    fmanager = FileManager.getIstance();
  }

  /**
   * Permette di inserire un annuncio, tale operazioni viene svolta all'interno del database quindi
   * bisogna interfacciarsi con il database. Una volta inserito l'annuncio, bisogna aggiornare la
   * cache per mantenere coerente l'interno sistema.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @throws StartupCacheException .
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().add(annuncio)
   */
  @Override
  public boolean insertAnnuncio(Annuncio annuncio) throws StartupCacheException {

    String sql =
        "INSERT INTO `mydb`.`annuncio` (`titolo`, `body`, `data`, `filePosition`, `autore`) "
            + "VALUES (?, ?, ?, ?, ?);";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, annuncio.getTitolo());
      st.setString(2, annuncio.getBody());
      st.setString(3, annuncio.getData());
      st.setString(4, annuncio.getFilePosition());
      st.setString(5, annuncio.getAutore().getEmail());
      st.executeUpdate();

      cache.updateAnnuncio("insert", annuncio.getTitolo(), annuncio);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }


  }

  /**
   * Permette di rimuovere un annuncio, tale operazioni viene svolta all'interno del database quindi
   * bisogna interfacciarsi con il database. Una volta rimosso l'annuncio, bisogna aggiornare la
   * cache per mantenere coerente l'interno sistema.
   * 
   * @param titolo diun annuncio
   * @return boolean
   * @throws StartupCacheException .
   * @throws IOException .
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().remove(annuncio)
   */
  @Override
  public boolean removeAnnuncio(String titolo) throws StartupCacheException {
    String sql = "DELETE FROM `mydb`.`annuncio` WHERE `titolo`=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, titolo);
      st.executeUpdate();
      cache.updateAnnuncio("remove", titolo);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }

  }

  /**
   * Permette di aggiornare un annuncio, tale operazioni viene svolta all'interno del database
   * quindi bisogna interfacciarsi con il database. Una volta aggiornato l'annuncio , bisogna
   * aggiornare la cache per mantenere coerente l'interno sistema.
   * 
   * @param newAnnuncio nuovo annuncio
   * @param oldAnnuncio annuncio da sostituire
   * @return boolean
   * @throws StartupCacheException .
   * @post DAOCache.getAnnunci()=DAOCache.getAnnunci().update(annuncio)
   */
  @Override
  public boolean updateAnnuncio(Annuncio newAnnuncio, Annuncio oldAnnuncio)
      throws StartupCacheException {
    String sql = "UPDATE `mydb`.`annuncio` SET "
        + "`titolo`=?, `body`=?, `data`=?, `filePosition`=?," + " `autore`=? WHERE `titolo`=?;";
    try (Connection con = manager.getConnection();
        PreparedStatement st = con.prepareStatement(sql);) {

      st.setString(1, newAnnuncio.getTitolo());
      st.setString(2, newAnnuncio.getBody());
      st.setString(3, newAnnuncio.getData());
      st.setString(4, newAnnuncio.getFilePosition());
      st.setString(5, newAnnuncio.getAutore().getEmail());
      st.setString(6, oldAnnuncio.getTitolo());
      st.executeUpdate();
      cache.updateAnnuncio("update", oldAnnuncio.getTitolo(), newAnnuncio);
      return true;
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
      return false;
    }

  }

  /**
   * Permette di inserire un file, tale operazioni viene svolta all'interno del file system quindi
   * bisogna interfacciarsi con il il file system.
   * 
   * @param request http request
   * @param path path dove inserire il file
   * @return boolean
   */
  @Override
  public boolean insertFile(HttpServletRequest request, String path) {
    try {
      fmanager.saveFile(request, path);
      return true;
    } catch (IOException | ServletException | FileNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }

  }

  @Override
  public boolean insertFile(HttpServletRequest request, String path, String fileNameToSave,
      String partFile) throws IOException, ServletException, FileNotSupportedException {
    try {
      fmanager.saveFile(request, path, fileNameToSave, partFile);
      return true;
    } catch (IOException | ServletException | FileNotSupportedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
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
    try {
      return fmanager.deleteFile(path);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
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
  public boolean updateFile(HttpServletRequest newFile, String newPath, String oldPath) {
    boolean rimozione = this.removeFile(oldPath);
    if (rimozione == true) {
      return this.insertFile(newFile, newPath);

    } else {
      return false;
    }
  }



  @Override
  public HashMap<String, Annuncio> selectAnnuncio() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Annuncio findAnnuncio(String titolo) {
    // TODO Auto-generated method stub
    return null;
  }



}
