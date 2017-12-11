/**
 * Interfaccia DAO che definisce i metodi per le operazioni riguardanti gli annunci che � possibile effettuare interfacciandosi con il database..
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.annuncio;

public interface AnnuncioDAO {
/**
 * Possibilit� di inserire un annuncio
 * @param annuncio
 * @return boolean
 */
	public boolean insertAnnuncio(Annuncio annuncio) ;
	/**
	 * Possibilit� di rimuovere un annuncio
	 * @param annuncio
	 * @return boolean
	 */
	public boolean removeAnnuncio(Annuncio annuncio);
	/**
	 * Possibilit� di poter aggiornare un annuncio
	 * @param annuncio
	 * @return boolean
	 */
	public boolean updateAnnuncio(Annuncio annuncio);
	/**
	 * Possibilit� di poter inserire un file
	 * @param file
	 * @param path
	 * @return boolean
	 */
	public boolean insertFile(Part file,String path);
	/**
	 * Possibilit� di poter rimuovere un file
	 * @param path
	 * @return boolean
	 */
	public boolean removeFile(String path);
	/**
	 * Possibilit� di poter sostituire un file.
	 * @param newFile
	 * @param newPath
	 * @param oldPath
	 * @return boolean
	 */
	public boolean updateFile(Part newFile,String newPath,String oldPath);
	
	
	
}
