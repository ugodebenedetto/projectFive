/**
 * Servelt che permete alla didattica di modificare un annuncio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
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

@MultipartConfig
@WebServlet("/it.tirociniosmart.view.didattica/ModificaAnnuncio")
public class ModificaAnnuncio extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private String filePosition = "ok";
  private String url;
  private boolean flag;


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
   */

  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    flag = true;
    url = "crea_annuncio_success.jsp";
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    String ot = request.getParameter("title");
    Date data = new Date();
    Annuncio annuncio = new Annuncio();
    // Didattica d = (Didattica) request.getSession().getAttribute("currentSessionUser");
    Didattica d = new Didattica("", "", "", "", "", "", "", "", "", "", "", false);
    ArrayList<Annuncio> annunci =
        (ArrayList<Annuncio>) request.getSession().getAttribute("annunci");
    for (Annuncio a : annunci) {
      if (a.getTitolo().equalsIgnoreCase(ot)) {
        annuncio = a;
        annunci.remove(a);
        break;
      }
    }
    if (flag) {
      annuncio.setAutore(d);
      annuncio.setTitolo(titolo);
      annuncio.setBody(body);
      annuncio.setData(data.toString());
      annuncio.setFilePosition(filePosition);

      FileManager filemanager = FileManager.getIstance();
      try {
        filemanager.saveFile(request, filePosition);
        annunci.add(annuncio);
      } catch (FileNotSupportedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (ServletException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    request.getSession().setAttribute("annunci", annunci);
    response.sendRedirect(url);
    /*
     * FactoryProducer factory = FactoryProducer.getIstance(); ProxyAnnuncioDao proxyAnnuncio =
     * (ProxyAnnuncioDao) factory.getAnnuncioDao(); Annuncio annuncio =
     * proxyAnnuncio.findAnnuncio(null); // prendo i dati dalla form e creo un nuovo annuncio
     * 
     * modificaAnnuncio(null, null);
     */

  }


  /**
   * Questo metodo gestisce la richiesta di modificare un annuncioe di modificare DB.
   * 
   */

  public void modificaAnnuncio(Annuncio annuncioOld, Annuncio annuncioNew) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyAnnuncioDao proxyAnnuncio = (ProxyAnnuncioDao) factory.getAnnuncioDao();
    proxyAnnuncio.updateAnnuncio(annuncioNew);
  }
}
