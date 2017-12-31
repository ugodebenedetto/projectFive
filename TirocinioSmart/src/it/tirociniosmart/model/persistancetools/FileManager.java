/**
 * Classe che permette la gestione del file system, si occupa di gestire gli inserimenti, le
 * cancellazioni e le creazioni di directory . Per efficienza tale classe Ã¨ un Singleton
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.persistancetools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import javax.servlet.*;
import javax.servlet.http.*;

public class FileManager {

  /**
   * Il FileManager deve essere consistente per tutte le classi.
   */
  private static volatile FileManager dataSource;

  /**
   * costruttore privato perchÃ¨ Ã¨ un singleton.
   */
  private FileManager() {

  }

  /**
   * Permette di ottenere un istanza di FileManager.
   * 
   * @return FileManager
   */
  public static FileManager getIstance() {
    if (dataSource == null) {
      synchronized (DBManager.class) {
        if (dataSource == null) {
          dataSource = new FileManager();

        }
      }
    }
    return dataSource;

  }

  /**
   * Salva un file nel path specificato come stringa.
   * 
   * @param file file da salvare
   * @param path path dove salvare il file
   * @return boolean
   * @throws ServletException
   * @throws IOException
   * @throws FileNotSupportedException
   */
  public void saveFile(HttpServletRequest request, String path)
      throws IOException, ServletException, FileNotSupportedException {

    if (request.getParts().size() > 0) {
      int i = 0;
      Collection<Part> parts = request.getParts();
      for (Part part : parts) {
        String fileName = this.findFileType(part);
        if (fileName != null) {
          i++;

          String pathFile = request.getServletContext().getRealPath("") + File.separator
              + "filesAnnunci" + File.separator + "files" + File.separator + path;
          File cartella = new File(pathFile);
          this.createDirectoryIfMissing(cartella);
          File fileSaveDir = new File(path + fileName);
          part.write(pathFile + File.separator + fileName);


        }
      }
    }

  }

  /**
   * Elimina un file presente nella locazione path.
   * 
   * @param path path del file da eliminare
   * @return boolean
   * @throws IOException
   */
  public boolean deleteFile(String path) throws IOException {
    File file = new File(path);
    return Files.deleteIfExists(file.toPath());

  }

  /**
   * Crea la directory per contenere il file se non ancora è stata creata.
   * 
   * @param file file da salvare
   */
  private void createDirectoryIfMissing(File file) {

    if (!file.exists()) {
      file.mkdir();
    }
  }

  /**
   * Trova l'estensione del file, e vede se è compatibile con quelle che sono ammesse dal sistema.
   * 
   * @pre typeOfFile.equals(".jpg") || typeOfFile.equals(".gif") || typeOfFile.equals(".png") ||
   *      typeOfFile.equals(".jpeg")|| typeOfFile.equals(".pdf")|| typeOfFile.equals(".zip")
   * @param file file da cui trovare l'estensione
   * @return String
   * @throws FileNotSupportedException
   * @throws FileNotFoundException
   */
  private String findFileType(Part file) throws FileNotSupportedException, FileNotFoundException {

    String content = file.getHeader("content-disposition");
    String[] items = content.split(";");
    for (int i = 0; i < items.length; i++) {
      if (items[i].trim().startsWith("filename")) {
        String filename = items[i].substring(items[i].indexOf("=") + 2, items[i].length() - 1);
        if (!(filename == null || filename.equals(""))) {
          String typeOfFile = filename.substring(filename.indexOf("."), filename.length());
          if (typeOfFile.equals(".jpg") || typeOfFile.equals(".gif") || typeOfFile.equals(".png")
              || typeOfFile.equals(".jpeg") || typeOfFile.equals(".pdf")
              || typeOfFile.equals(".zip")) {
            return filename;
          }
        } else {
          throw new FileNotSupportedException("zip, pdf, jpg, gif, jpeg, png.");
        }
      }
    }
    throw new FileNotFoundException("Nessun file caricato, controlla.");
  }
}
