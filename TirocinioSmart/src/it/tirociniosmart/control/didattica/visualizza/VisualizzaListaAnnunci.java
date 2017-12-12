/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli annunci
 * @author Clara Monaco
 */
package it.tirociniosmart.control.didattica.visualizza;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *  @version

*/

public class VisualizzaListaAnnunci extends HttpServlet {
	/** Gestisce il metodo HTTP GET.

     * @param request 
     * 
     * @param response 

    */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST. con questo metodo possiamo gestire la richiesta di controllo 
	 * lista annunci permettendo poi l'iterazione con essi
	

	 * @param request 

	 * @param response 

   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	

	/** Questo metodo visualizza tutti gli annunci 
		@return ArrayList<Annuncio>
	 */
	public ArryList<Annuncio> visualizzaListaAnnuncio(){
		
	}
}
