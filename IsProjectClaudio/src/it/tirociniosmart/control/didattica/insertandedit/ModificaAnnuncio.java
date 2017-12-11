/**
 * Servelt che permete alla didattica di modificare un annuncio
 * @author Clara Monaco
 */
package it.tirociniosmart.control.didattica.insertandedit;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *  @version

*/
public class ModificaAnnuncio extends HttpServlet {
	/** Gestisce il metodo HTTP GET.

     * @param request 
     * 
     * @param response 

    */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * Gestisce la richiesta dell'utente di modificaAnnuncio

    * @param request 

    * @param response 

   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Questo metodo gestisce la richiesta di modificare un annuncioe di modificare DB
	 * 
	 *  @pre l'utente autenticato è nel ruolo della didattica
	 *  @pre l'annuncio da modificare esiste
	 *  @post l'annuncio viene modificato mantenendo id
    * 
    * 
    * 

   */
	public void inserisciAnnuncio(Annuncio annuncio) {}
}
