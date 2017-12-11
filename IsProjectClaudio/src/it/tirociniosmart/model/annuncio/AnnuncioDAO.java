/**
 * Interfaccia DAO che definisce i metodi per le operazioni riguardanti gli annunci che è possibile effettuare interfacciandosi con il database..
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.annuncio;

public interface AnnuncioDAO {
/**
 * Possibilità di inserire un annuncio
 * @param annuncio
 * @return boolean
 */
	public boolean insertAnnuncio(Annuncio annuncio) ;
	/**
	 * Possibilità di rimuovere un annuncio
	 * @param annuncio
	 * @return boolean
	 */
	public boolean removeAnnuncio(Annuncio annuncio);
	/**
	 * Possibilità di poter aggiornare un annuncio
	 * @param annuncio
	 * @return boolean
	 */
	public boolean updateAnnuncio(Annuncio annuncio);
	/**
	 * Possibilità di poter inserire un file
	 * @param file
	 * @param path
	 * @return boolean
	 */
	public boolean insertFile(Part file,String path);
	/**
	 * Possibilità di poter rimuovere un file
	 * @param path
	 * @return boolean
	 */
	public boolean removeFile(String path);
	/**
	 * Possibilità di poter sostituire un file.
	 * @param newFile
	 * @param newPath
	 * @param oldPath
	 * @return boolean
	 */
	public boolean updateFile(Part newFile,String newPath,String oldPath);
	
	
	
}
