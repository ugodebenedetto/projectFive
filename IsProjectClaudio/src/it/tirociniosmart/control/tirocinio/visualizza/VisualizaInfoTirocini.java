/**
 * Servelt che permete di visualizzare le info relative ai tirocini
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
public class VisualizaInfoTirocini extends HttpServlet {
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
	
	
	/** Questo metodo visualizza tutti gli studenti tirocinanti ad un tirocinio
	 * @param tirocinio
	 * @return ArrayList<Studenti>
	
	 */
	public ArryList<Studenti> visualizzaTirocinanti(Tirocinio tirocinio){
		
	}
	
	/** Questo metodo visualizza tirocinio
	 * @param tirocinio
	 * @return Tirocinio
	
	 */	
	public Tirocinio visualizzaTirocinio(Tirocinio tirocinio) {}
}
