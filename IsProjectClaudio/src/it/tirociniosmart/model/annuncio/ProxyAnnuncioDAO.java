/**
 * Classe proxy di AnnuncioDAO, permette la visualizzazione  degli annunci, per tutte le altre operazioni, fa riferimento all'oggetto "RealAnnuncioDAO"
 * che contiene i metodi per le operazioni riguardanti gli annunci che è possibile effettuare interfacciandosi con il database e il file system.
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.annuncio;

import java.util.ArrayList;

public class ProxyAnnuncioDAO implements AnnuncioDAO{
private	RealAnnuncioDAO realAnnuncioDao;
/**
 * Permette di selezionare gli annunci, prendendoli dalla cache che è sempre aggiornata con gli ultimi inserimenti.
 * @return ArrayList<Annuncio>
 */
public ArrayList<Annuncio> SelectAnnuncio(){
	
}
/**
 * Permette di ricercare un annuncio, tale operazioni viene svolta all'interno della cache, quindi non si interfaccia con il database.
 * @param annuncio
 * @return Annuncio
 */
public Annuncio findAnnuncio(Annuncio annuncio)
{
	
}
/**
 * Permette di inserire un annuncio, tale operazioni viene svolta interfacciandosi con il database, quindi si richiede una istanza di realAnnuncioDAO
 * @param annuncio
 * @return boolean
 */
@Override
public boolean insertAnnuncio(Annuncio annuncio) {
	
}
/**
 * Permette di rimuovere un annuncio, tale operazioni viene svolta interfacciandosi con il database, quindi si richiede una istanza di realAnnuncioDAO
 * @param annuncio
 * @return bolean
 */
@Override
public boolean removeAnnuncio(Annuncio annuncio) {

}
/**
 * Permette di aggiornare un annuncio, tale operazioni viene svolta interfacciandosi con il database, quindi si richiede una istanza di realAnnuncioDAO
 * @param annuncio
 * @return boolean
 */
@Override
public boolean updateAnnuncio(Annuncio annuncio) {
	
}
/**
 * Permette di aggiornare un annuncio, tale operazioni viene svolta interfacciandosi con il database, quindi si richiede una istanza di realAnnuncioDAO
 * @param path
 * @param file
 * @return boolean
 */
@Override
public boolean insertFile(Part file, String path) {
	
}
/**
 * Permette di rimuovere un file, tale operazioni viene svolta interfacciandosi con il file system, quindi si richiede una istanza di realAnnuncioDAO
 * @param path
 * @return boolean
 */
@Override
public boolean removeFile(String path) {
	
}
/**
 * Permette di sostituire un file, tale operazioni viene svolta interfacciandosi con il file system, quindi si richiede una istanza di realAnnuncioDAO
 * @param newFile
 * @param newPath
 * @param oldPath
 * @return boolean
 */
@Override
public boolean updateFile(Part newFile, String newPath, String oldPath) {

}


}
