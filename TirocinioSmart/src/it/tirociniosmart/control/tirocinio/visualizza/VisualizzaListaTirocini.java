/**
 * Servelt che permete di visualizzare la lista di tutti i tirocini
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

public class VisualizzaListaTirocini extends HttpServlet {
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
		
		/** Questo metodo visualizza tutti i tirocini
		 * @return ArrayList<tirocinio>
		
		 */
		public ArryList<Tirocinio> visualizzaListaTirocinio(Tirocinio tirocinio){
			
		}
}
