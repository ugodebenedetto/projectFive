/**
 * Classe che permette la gestione del file system, si occupa di gestire gli inserimenti, le
 * cancellazioni e le creazioni di directory . Per efficienza tale classe è un Singleton v1.1
 * 
 * @author Armando Ferrara
 * 
 */

package it.tirociniosmart.model.persistancetools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;



public class FileManager {

  // MODIFICARE CON LA PROPRIA POSIZIONE DEL WORKSPACE
  private static final String URL_WORKSPACE =
      "C:\\Users\\Asus\\git\\projectFiveSd\\TirocinioSmart";


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
   * @param request file da salvare
   * @param path path dove salvare il file
   * @throws ServletException eccexione
   * @throws IOException eccezione
   * @throws FileNotSupportedException eccezione
   */
  public void saveFile(HttpServletRequest request, String path)
      throws IOException, ServletException, FileNotSupportedException {


    Part part = request.getPart("file1");

    String fileName = this.findFileType(part);
    if (fileName != null) {

      // creo il percorso se mancante, ora la cartella filesAnnunci
      String pathFile =
          URL_WORKSPACE + File.separator + "WebContent" + File.separator + "UsersFiles";

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

  /**
   * Salva un file nel path specificato come stringa, con il nome specificato.
   * 
   * @param fileNameToSave nome con cui salvare il file
   * @param request file da salvare
   * @param path path dove salvare il file
   * @throws ServletException eccexione
   * @throws IOException eccezione
   * @throws FileNotSupportedException eccezione
   */
  public void saveFile(HttpServletRequest request, String path, String fileNameToSave,
      String partFile) throws IOException, ServletException, FileNotSupportedException {


    Part part = request.getPart(partFile);

    String fileName = this.isPdf(part);
    if (fileName != null) {

      // creo il percorso se mancante, ora la cartella filesAnnunci
      String pathFile =
          URL_WORKSPACE + File.separator + "WebContent" + File.separator + "UsersFiles";

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
      File fileSaveDir = new File(path + fileNameToSave);
      part.write(pathFile + File.separator + fileNameToSave);



    }

  }


  /**
   * Elimina un file presente nella locazione path.
   * 
   * @param path path del file da eliminare
   * @return boolean
   * @throws IOException eccezione
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
   * Trova l'estensione del file, e vede se compatibile con quelle che sono ammesse dal sistema.
   * 
   * @pre typeOfFile.equals(".jpg") || typeOfFile.equals(".gif") || typeOfFile.equals(".png") ||
   *      typeOfFile.equals(".jpeg")|| typeOfFile.equals(".pdf")|| typeOfFile.equals(".zip")
   * @param file file da cui trovare l'estensione
   * @return String
   * @throws FileNotSupportedException eccezione
   * @throws FileNotFoundException eccezione
   */
  private String findFileType(Part file) throws FileNotSupportedException, FileNotFoundException {

    String typeOfFile = file.getContentType();
    System.out.println(typeOfFile);
    System.out.println(file.getSubmittedFileName());
    if (typeOfFile != null) {
      if (typeOfFile.equals("image/jpg") || typeOfFile.equals("image/gif")
          || typeOfFile.equals("image/png") || typeOfFile.equals("image/jpeg")
          || typeOfFile.equals("application/pdf") || typeOfFile.equals("application/zip")) {
        return file.getSubmittedFileName();
      } else {
        throw new FileNotSupportedException("zip, pdf, jpg, gif, jpeg, png.");
      }
    }

    throw new FileNotFoundException("File non trovato, controlla");
  }

  private String isPdf(Part file) throws FileNotSupportedException, FileNotFoundException {
    String typeOfFile = file.getContentType();
    System.out.println(typeOfFile);
    System.out.println(file.getSubmittedFileName());
    if (typeOfFile != null) {
      if (typeOfFile.equals("application/pdf")) {
        return file.getSubmittedFileName();
      } else {
        throw new FileNotSupportedException("pdf");
      }
    }

    throw new FileNotFoundException("File non trovato, controlla");
  }


}
