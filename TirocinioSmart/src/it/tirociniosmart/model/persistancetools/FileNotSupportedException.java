/**
 * Eccezzione per segnalare i tipi di file non supportati durante l'upload.
 */

package it.tirociniosmart.model.persistancetools;

public class FileNotSupportedException extends Exception {

  public FileNotSupportedException() {
    super("Tipo di file non supportato");
  }

  public FileNotSupportedException(String tipiSupportati) {
    super("Tipo di file non supportato, i file supportati sono: " + tipiSupportati);
  }

}

