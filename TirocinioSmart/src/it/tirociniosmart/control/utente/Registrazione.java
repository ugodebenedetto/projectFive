
/**
 * Servelt che permete all'utente di registrarsi al sito e quindi al servizio
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
public class Registrazione extends HttpServlet{

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
	

	/** Questo metodo permette di controllare che l'utente non sia presente nel DB

    * @param email
    * @return boolean

   */
	
	public boolean controllaEsistenzaUser(String email) {}
	
	
	
	/** Questo metodo permette la regisrazione di un utente all'applicazione tramite form
	 * 
	 * @pre L'utente non è registrato
	 * @post L'utente è registrato
	 * 
	 * @pre Nome è una stringa di caratterei alfabetici.
	 * @pre Cognome è una stringa di caratterei alfabetici.
	 * @pre data di nascita deve controllare che l'utente sia maggiorenne.
	 * @pre Residenza è una stringa di caratterei alfabetici.
	 * @pre C.F Stringa di caratteri alfanumerici, numero caratteri==16.
	 * @pre Numero telefono, stinga di caratteri numerici.
	 * @pre Email Stringa con carettere speciale "@".
	 * @pre Password: Stringa di almeno 8 caratteri, di cui almeno una cifra e almeno una lettera.
	 * @pre ConfermaPassword: Stringa formato analogo alla password.
	 * @pre Matricola: Stringa numerica
	 * 
	 * @pre tutti i campi del form sono obbligaori.
	    
	 * @return utente

	   */
	public static Utente registra(Utente utente) {}
	
}
