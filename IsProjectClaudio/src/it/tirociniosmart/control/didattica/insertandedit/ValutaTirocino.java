/**
 * Servelt che permete alla didattica avviare e concludere un tirocinio
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
public class ValutaTirocino extends HttpServlet {
	/** Gestisce il metodo HTTP GET.

     * @param request 
     * 
     * @param response 

    */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 

	 * @param request 

	 * @param response 

   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Questo metodo serve permete alla didattica di avviare un tirocinio 
	 * 
	 * @pre Tutor Accademico ha accettato la richiesta
	 * 
	 * @post Tirocinio avviato
	 * 
	 * @param accettazione boolean, paramentro che sta ad indicare se il tutor ha accettato la richiesta
	 * 
	 * 

   */
	public void avviaTirocinio(Tirocinio tirocinio) {}
	
	

	/** Questo metodo serve permete alla didattica di porre fine ad un tirocinio 
	 * 
	 * @pre studente ha terminato le sue ore e compilato tutti i documenti
	 * 
	 * @post Tirocinio convalidato
	 * 
	 * 
	 * 
	 * 

   */
	public void fineTirocinio(Tirocinio tirocinio) {}
}
