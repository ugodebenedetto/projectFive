/**
 * Servelt che permete all'utente di autenticarsi per accedere al servizio
 * @author Clara Monaco
 */
package it.tirociniosmart.control.utente;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *  @version

*/
public class Login extends HttpServlet{


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
	
	/** Questo metodo gestisce la richiesta dell'utente di loggarsi per accedere al servizio
	 * 
	 * I parametri controllati
     * @param username;
     * @param password
     * 
     * @invariant:Password Stringa di almeno 8 caratteri, di cui almeno una cifra e almeno una lettera
     * @return Utente

    */
	public static Utente login(String username, String password ) {
		
	}
}
