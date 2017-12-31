/**
 * Classe che permette la gestione del file system, si occupa di gestire gli inserimenti, le
 * cancellazioni e le creazioni di directory . Per efficienza tale classe è un Singleton v1.1
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

  // MODIFICARE CON LA PROPRIA POSIZIONE DEL WORKSPACE
  private static final String URL_WORKSPACE =
      "C:\\Users\\Claudio\\git\\projectFive\\TirocinioSmart";


  /**
   * Il FileManager deve essere consistente per tutte le classi.
   */
  private static volatile FileManager dataSource;

  /**
   * costruttore privato perchè è un singleton.
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
          // creo il percorso se mancante, ora la cartella filesAnnunci
          String pathFile = URL_WORKSPACE + File.separator + "UsersImages";

          File cartella = new File(pathFile);
          this.createDirectoryIfMissing(cartella);
          // creo il percorso se mancante, ora la cartella files
          pathFile += File.separator + "files";
          cartella = new File(pathFile);
          this.createDirectoryIfMissing(cartella);
          // ora quella desiderata con il parametro path
          pathFile += File.separator + path;

          cartella = new File(pathFile);
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
    File file = new File(URL_WORKSPACE + File.separator + path);
    return Files.deleteIfExists(file.toPath());

  }

  /**
   * Crea la directory per contenere il file se non ancora 衳tata creata.
   * 
   * @param file file da salvare
   */
  private void createDirectoryIfMissing(File file) {

    if (!file.exists()) {
      file.mkdir();
    }
  }

  /**
   * Trova l'estensione del file, e vede se 衣ompatibile con quelle che sono ammesse dal sistema.
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
    if (items[2].trim().startsWith("filename")) {
      String filename = items[2].substring(items[2].indexOf("=") + 2, items[2].length() - 1);
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
    throw new FileNotFoundException("File non trovato, controlla");
  }


}
