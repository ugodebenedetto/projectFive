/**
 * Servelt che permete alla didattica di inserire un annuncio
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
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.utente.Didattica;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/it.tirociniosmart.view.didattica/InserisciAnnuncio")
public class InserisciAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private String url;
  private boolean flag;

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
    flag = true;
    url = "crea_annuncio_success.jsp";
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    Part part = request.getPart("file1");

    Date data = new Date();
    Didattica d = (Didattica) request.getSession().getAttribute("currentSessionUser");
    checkAnnunci(titolo);
    if (flag) {
      Annuncio ann = new Annuncio(titolo, d, data.toString(), body, part.getSubmittedFileName());
      inserisciAnnuncio(ann, request, "ok");
    }

    response.sendRedirect(url);

  }

  /**
   * Questo metodo gestisce la richiesta di inserimento annuncio e quindi di un insert nel DB.
   * 
   */


  public void inserisciAnnuncio(Annuncio annuncio, HttpServletRequest request, String path) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    try {
      annunci.insertAnnuncio(annuncio);
      annunci.insertFile(request, path);
    } catch (StartupCacheException e) {
      url = "crea_annuncio_failure.jsp";
      e.printStackTrace();
    }
  }

  /**
   * Questo metodo controlla che non esista già un annuncio con quel titolo.
   * 
   * @param titolo da controllare
   * 
   */
  public void checkAnnunci(String titolo) {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    HashMap<String, Annuncio> toCheck = annunci.selectAnnuncio();
    if (toCheck == null) {
      return;
    } else {
      for (String key : toCheck.keySet()) {
        if (toCheck.get(key).getTitolo().equalsIgnoreCase(titolo)) {
          url = "crea_annuncio_failure.jsp";
          flag = false;
          break;
        }
      }
    }
  }

}
