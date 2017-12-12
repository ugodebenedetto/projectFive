/**
 * Servelt che permette allo studente di inviare la richiesta di tirocinio
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

public class InviaRichiestaTirocinio extends HttpServlet  {
	 /** Gestisce il metodo HTTP GET.
     * @param request 
     * @param response 
    */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce il metodo HTTP POST.
	 * In questo metodo sara gestita la richiesta di tirocinio da parte dello studente
	 * 
	 * @pre studente registrato
	 * 
	 *
    * @param request 
    * @param response 
    */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {}
	
	
	/** Gestisce l'invio della richiesta tirocinio
	 * @param RTirocinio
	 * @return boolean
	 * 
	 * */
	
	public boolean inviaRichiesta(RichiestaTirocinio RTirocinio) {}

	/** Controlla la disponibilità del tirocinio
	 * @param Tirocinio
	 * @return boolean
	 * 
	 * */
	
	public boolean controllaDisponibilita(Tirocinio tirocinio) {}
	
	/** Controlla invio precedente
	 * @param Utente
	 * @return boolean
	 * 
	 * */
	public boolean controllaInvioPrecedente(RichiestaTirocinio tirocinio) {}
	
	
}
