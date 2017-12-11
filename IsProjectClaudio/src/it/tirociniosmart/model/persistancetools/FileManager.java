/**
 * Classe che permette la gestione del file system, si occupa di gestire gli inserimenti, le cancellazioni e le creazioni di directory .
 * Per efficienza tale classe è un Singleton
 * @author Armando Ferrara
 * 
 */
package it.tirociniosmart.model.persistancetools;

public class FileManager {

	/**
	 * Il FileManager deve essere consistente per tutte le classi.
	 */
		private volatile static FileManager dataSource;
		/**
		 * costruttore privato perché è un singleton
		 */
		private FileManager(){
			
		}
		/**
		 * Permette di ottenere un istanza di FileManager
		 * @return FileManager
		 */
		public static  FileManager getIstance()
		{
			
		}
		/**
		 * Salva un file nel path specificato come stringa.
		 * @param file
		 * @param path
		 * @return boolean
		 */
		public  boolean saveFile(Part file,String path)
		{
			
		}
		/**
		 * Elimina un file presente nella locazione path
		 * @param path
		 * @return boolean
		 */
		public boolean deleteFile(String path){
			
		}
		/**
		 * Crea la directory per contenere il file se non ancora è stata creata
		 * @param file
		 */
		private void createDirectoryIfMissing(File file){
			
		}
		/**
		 * Trova l'estensione del file, e vede se è compatibile con quelle che sono ammesse dal sistema.
		 * @param file
		 * @return String
		 */
		private String findFileType(Part file){
			
		}
}
