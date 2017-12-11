/**
 * Servelt che permete all'utente richiedere supporto.
 * Fornisce la possibilità di inviare una e-mail all’assistenza
 * tecnica del dipartimento d’Informatica dell’Università degli Studi di Salerno,
 * per richiedere delle informazioni.
 * 
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


public class RichiediSupporto extends HttpServlet {
	/** Gestisce il metodo HTTP GET.

     * @param request 
     * 
     * @param response 
     * 
     * @param emailDestinatario
     * @param emailMittente

    */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.

    * @param request 

    * @param response 

   */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
}
