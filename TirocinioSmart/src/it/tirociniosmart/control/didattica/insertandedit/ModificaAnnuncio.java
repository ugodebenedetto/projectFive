/**
 * Servelt che permete alla didattica di modificare un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.persistancetools.FileManager;
import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
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
@WebServlet("/it.tirociniosmart.view.didattica/ModificaAnnuncio")
public class ModificaAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private String filePosition = "ok";
  private String url;


  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   */

  public void doGet(HttpServletRequest request, HttpServletResponse response) {}

  /**
   * Gestisce il metodo HTTP POST. Gestisce la richiesta dell'utente di modificaAnnuncio
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws IOException eccezione
   * @throws ServletException eccezione
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    url = "crea_annuncio_success.jsp";   
    String ot = request.getParameter("title");

    Annuncio annuncio = new Annuncio();
    Annuncio old = new Annuncio();
    old.setTitolo(ot);
    Didattica d = (Didattica) request.getSession().getAttribute("currentSessionUser");
    Date data = new Date();
    Part part = request.getPart("file1");
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");

    annuncio.setAutore(d);
    annuncio.setTitolo(titolo);
    annuncio.setBody(body);
    annuncio.setData(data.toString());
    annuncio.setFilePosition(part.getSubmittedFileName());

    modificaAnnuncio(old, annuncio);


    response.sendRedirect(url);


  }


  /**
   * Questo metodo gestisce la richiesta di modificare un annuncioe di modificare DB.
   * 
   */

  public void modificaAnnuncio(Annuncio annuncioOld, Annuncio annuncioNew) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    try {
      annunci.updateAnnuncio(annuncioNew, annuncioOld);
    } catch (StartupCacheException e) {
      url = "crea_annuncio_failure.jsp";
      e.printStackTrace();
    }
  }
}
