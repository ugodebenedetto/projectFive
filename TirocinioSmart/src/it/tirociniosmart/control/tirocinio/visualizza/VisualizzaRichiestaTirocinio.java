/**
 * Servelt che permete di visualizzare la lista di tutte le richieste di tirocini
 * @author Clara Monaco
 */
package it.tirociniosmart.control.tirocinio.visualizza;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;




/**
 *  @version

*/

public class VisualizzaRichiestaTirocinio extends HttpServlet {
	/**Gestisce il metodo HTTP GET.
     * @param request
     * @param response 
    */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * @param request 
	 * @param response 
   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Visualizza lo stato della richiesta tirocinio svolta da uno studente
	 * @param Studente
	 * @return RichiestaTirocinio
   */
	public RichiestaTirocinio visualizzaStatoRichiestaTirocinio(Studente studente) {}
}
