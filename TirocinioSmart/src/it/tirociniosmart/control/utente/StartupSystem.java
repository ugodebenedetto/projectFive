/**
 * Servlet che permete di visualizzare le info relative ai tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.utente;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.tirociniosmart.model.persistancetools.StartupCache;

@WebServlet(name = "StartupSystem", loadOnStartup = 1, urlPatterns = {"/StartupServlet"})
public class StartupSystem extends HttpServlet {

  private static final long serialVersionUID = 1L;


  public void init(ServletConfig config) throws ServletException {
    StartupCache start = new StartupCache();
    System.out.println("Startup Cache Singleton avviato !");
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}



}
