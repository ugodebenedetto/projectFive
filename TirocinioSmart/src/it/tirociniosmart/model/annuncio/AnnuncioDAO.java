/**
 * Interfaccia DAO che definisce i metodi per le operazioni riguardanti gli annunci che �
 * possibile effettuare interfacciandosi con il database..
 * 
 * @author Armando Ferrara
 */

package it.tirociniosmart.model.annuncio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.persistancetools.StartupCacheException;

public interface AnnuncioDAO {
  /**
   * Possibilità di inserire un annuncio.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @throws StartupCacheException
   */
  public boolean insertAnnuncio(Annuncio annuncio) throws StartupCacheException;

  /**
   * Possibilità di rimuovere un annuncio.
   * 
   * @param annuncio un annuncio
   * @return boolean
   * @throws IOException
   */
  public boolean removeAnnuncio(String titolo) throws StartupCacheException;

  /**
   * Possibilità di poter aggiornare un annuncio.
   * 
   * @param annuncio un annuncio
   * @return boolean
   */
  public boolean updateAnnuncio(Annuncio newAnnuncio, Annuncio oldAnnuncio)
      throws StartupCacheException;

  /**
   * Possibilità di poter inserire un file.
   * 
   * @param file file da inserire
   * @param path path dove inserire il file
   * @return boolean
   */
  public boolean insertFile(HttpServletRequest request, String path);

  /**
   * Inserisce file per i moduli fra tirocinante e tutor
   * 
   * @param request
   * @param path
   * @param fileNameToSave
   * @param partFile
   * @return
   * @throws IOException
   * @throws ServletException
   * @throws FileNotSupportedException
   */
  public boolean insertFile(HttpServletRequest request, String path, String fileNameToSave,
      String partFile) throws IOException, ServletException, FileNotSupportedException;


  public HashMap<String, Annuncio> selectAnnuncio();

  public Annuncio findAnnuncio(String titolo);


  /**
   * Possibilità di poter rimuovere un file.
   * 
   * @param path path dove inserire il file
   * @return boolean
   */
  public boolean removeFile(String path);

  /**
   * Possibilità di poter sostituire un file.
   * 
   * @param newFile nuovo file da inserire
   * @param newPath nuovo path del file
   * @param oldPath vecchio path del file
   * @return boolean
   */
  public boolean updateFile(HttpServletRequest newFile, String newPath, String oldPath);


}
