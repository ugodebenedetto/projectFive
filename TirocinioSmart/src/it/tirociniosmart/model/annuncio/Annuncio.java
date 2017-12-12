/**
 * Classe del model che rappresenta l'oggetto persistente Annuncio, fa parte del model e contiene tutti gli attributi comuni all'oggetto Annuncio.
 * @author Armando Ferrara
 */
package it.tirociniosmart.model.annuncio;

public class Annuncio {
	/**
	 * Attributo che contiene il titolo dell'annuncio che funge anche da chiave primaria nel database.
	 */
private String titolo;
/**
 * Attributo che contiene l'autore dell'annuncio appartenente alla Didattica.
 */
private Didattica autore;
/**
 * Attributo che contiene la data dell'annuncio.
 */
private String data;
/**
 * Attributo che contiene il corpo dell'annuncio.
 */
private String body;
/**
 * Attributo che contiene la posizione del file all'interno del fileSystem.
 */
private String filePosition;

public Annuncio() {
}

public Annuncio(String titolo, String autore, String data, String body, String filePosition) {
	
	this.titolo = titolo;
	this.autore = autore;
	this.data = data;
	this.body = body;
	this.filePosition = filePosition;
}

public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}

public Didattica getAutore() {
	return autore;
}

public void setAutore(Didattica autore) {
	this.autore = autore;
}

public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getBody() {
	return body;
}
public void setBody(String body) {
	this.body = body;
}
public String getFilePosition() {
	return filePosition;
}
public void setFilePosition(String filePosition) {
	this.filePosition = filePosition;
}

	
}
