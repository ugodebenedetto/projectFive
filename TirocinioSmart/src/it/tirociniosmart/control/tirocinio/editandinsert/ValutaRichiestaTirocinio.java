/**
 * Servelt che permette al TA di accettare o rifiutare richiesta di tirocinio
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

public class ValutaRichiestaTirocinio extends HttpServlet {
	 /** Gestisce il metodo HTTP GET.
     * @param request 
     * @param response 
    */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * In questo metodo sarà gestita la richiesta di tirocinio da parte del TA
	 * 
	 * @pre studente registrato
	 * 
	 *
    * @param request 
    * @param response 
    */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	/** accetta richiesta tirocinio da perte del TA
	 * @param tirocinio
	 * 
	 * 
	 * */
	public void accettaRichiestaTirocinio(RichiestaTirocinio tirocinio) {}
	
	/** rifiuta richiesta tirocinio da perte del TA
	 * @param tirocinio
	 * 
	 * 
	 * */
	public void rifiutaRichiestaTirocinio(RichiestaTirocinio tirocinio) {}
	
	
}
