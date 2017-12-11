/**
 * Servelt che permette all'utente TA di modificare un tirocinio
 * @author Clara Monaco
 */
package it.tirociniosmart.control.tirocinio.editandinsert;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *  @version

*/
public class ModificaTirocinio extends HttpServlet {
	
	 /** Gestisce il metodo HTTP GET.
    * @param request 
    * @param response 
   */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * @pre Utente è registrato con ruolo TA
	 * @pre Tirocinio esiste 
	 * @post Tirocinio modificato
	 * 
	 * @param request 
	 * @param response 
   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}

	/** Questo metodo permette la modifica di un tirocinio da perte del TA nel DB
	    * @param tirocinio oggetto 
	    * @return tirocinio 
	    */
	public Tirocinio inserisciTirocinio(Tirocinio tirocinio) {
		
	}
}
