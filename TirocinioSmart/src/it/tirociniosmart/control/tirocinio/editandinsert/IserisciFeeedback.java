/**
 * Servelt che permette allo studente di lasciare un feedback
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

public class IserisciFeeedback extends HttpServlet {
	 /** Gestisce il metodo HTTP GET.
     * @param request 
     * @param response 
    */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * In questo metodo sara gestita la richiesta di inserimento feedback
	 * 
	 * @pre studente ha finito questo tirocinio
	 * @post studente lascia un feedback
	 * @param request 
	 * @param response 
    */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	/** Questo metodo permette l'inserimento di un feedback da parte di uno sudente che ha sosenuto un tirocinio nel DB
	    * @param Feedback
	    * @return Feedback
	    */
	public Feedback inserisciFeedback(Feedback feedback) {
		
	}
}
