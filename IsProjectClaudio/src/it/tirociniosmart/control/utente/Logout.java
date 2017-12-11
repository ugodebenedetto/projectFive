/**
 * Servelt che permete all'utente di abbandonare la propria sessione
 * @author Clara Monaco
 */
package it.tirociniosmart.control.utente;
/**
 *  @version

*/
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Logout extends HttpServlet {


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
	
	/** Questo metodo gestisce la richiesta dell'utente di abbandonare la sessioone

     * 
	 * @param sessione
	 * */
	public void logout(HttpSession sessione) {
		
	}
}
