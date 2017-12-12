/**
 * Servelt che permete alla didattica di inserire un annuncio
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
public class InserisciAnnuncio extends HttpServlet {


    /** Gestisce il metodo HTTP GET.

      * @param request 
      * 
      * @param response 

     */


	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * Gestisce la richiesta di creare un annuncio

     * @param request 

     * @param response 

    */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Questo metodo gestisce la richiesta di inserimento annuncio e quindi di un insert nel DB
	 * 
	 *  @pre l'utente autenticato è nel ruolo della didattica
	 *  @post l'annuncio viene creato
     * 
     * 
     * 

    */
	public void inserisciAnnuncio(Annuncio annuncio) {}
}
