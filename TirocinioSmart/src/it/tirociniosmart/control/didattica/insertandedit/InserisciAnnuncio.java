/**
 * Servelt che permete alla didattica di inserire un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.persistancetools.FileManager;
import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.utente.Didattica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/InserisciAnnuncio")
public class InserisciAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private String filePosition = "";
  private String url = "it.tirociniosmart.view.didattica/crea_annuncio_success.jsp";
  private boolean flag = true;

  /**
   * Gestione richiesta doGet.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST. Gestisce la richiesta di creare un annuncio
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws IOException eccezione
   * @throws ServletException eccezione
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    Date data = new Date();
    // Didattica d = (Didattica) request.getSession().getAttribute("currentSessionUser");
    Didattica d = new Didattica("", "", "", "", "", "", "", "", "", "", "", false);
    Annuncio ann = new Annuncio(titolo, d, data.toString(), body, filePosition);
 


    // inserisciAnnuncio(ann);

  }

  /**
   * Questo metodo gestisce la richiesta di inserimento annuncio e quindi di un insert nel DB.
   * 
   */


  public void inserisciAnnuncio(Annuncio annuncio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyAnnuncioDao proxyAnnuncio = (ProxyAnnuncioDao) factory.getAnnuncioDao();
    proxyAnnuncio.insertAnnuncio(annuncio);
  }
}
