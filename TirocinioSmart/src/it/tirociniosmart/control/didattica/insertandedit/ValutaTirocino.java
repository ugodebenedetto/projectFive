/**
 * Servelt che permete alla didattica avviare e concludere un tirocinio
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.persistancetools.FileManager;
import it.tirociniosmart.model.persistancetools.FileNotSupportedException;
import it.tirociniosmart.model.persistancetools.StartupCache;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet("/it.tirociniosmart.view.didattica/ValutaTirocinio")
public class ValutaTirocino extends HttpServlet {

  private String url;
  private String name;
  private String file;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {


    // prendo tirocinio dalla session
    // a seconda del bottone premuto chiamo avvia o fine
    // avviaTirocinio(tirocinio);


  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws ServletException eccezione
   * @throws IOException
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    StartupCache cache = new StartupCache();
    url = "carica_modulo_success.jsp";
    String matricola = request.getParameter("matricola");
    file = request.getParameter("file");
    
    addModule(request, matricola);

    response.sendRedirect(url);

  }

  /**
   * Metodo che aggiunge un file.
   * 
   * @param request httprequest
   * @param matricola nome della cartella
   * @throws IOException eccezione
   * @throws ServletException eccezione
   */
  public void addModule(HttpServletRequest request, String matricola)
      throws IOException, ServletException {
    
    ArrayList<Part> lista = (ArrayList<Part>) request.getParts();
    for (Part p : lista) {
      if (p != null) {
        if (p.getSubmittedFileName() != null && p.getSubmittedFileName().length() != 0) {
          file = p.getName();
          break;
        }
      }
    }

    if (file.equals("file1")) {
      name = "Progetto Formativo.pdf";
    } else if (file.equals("file2")) {
      name = "Registro Ore.pdf";
    } else if (file.equals("file3")) {
      name = "Valutazione.pdf";
    }
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    try {
      annunci.insertFile(request, matricola, name, file);
    } catch (FileNotSupportedException e) {
      url = "carica_modulo_failure.jsp";
      e.printStackTrace();
    }

  }

}
