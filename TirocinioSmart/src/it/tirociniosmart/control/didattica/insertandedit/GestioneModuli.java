package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.Annuncio;
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



/**
 * Servlet implementation class GestioneModuli.
 */
@MultipartConfig
@WebServlet("/it.tirociniosmart.view.direttore/GestioneModuli")
public class GestioneModuli extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private String url;
  private String path = "moduli";

  /**
   * .
   * 
   * @see HttpServlet#HttpServlet()
   */
  public GestioneModuli() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * doGet.
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * doPost.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    url = "carica_modulo_success.jsp";
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");

    FileManager filemanager = FileManager.getIstance();
    try {
      filemanager.saveFile(request, path);
    } catch (FileNotSupportedException e) {
      url = "carica_modulo_failure.jsp";
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      url = "carica_modulo_failure.jsp";
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ServletException e) {
      url = "carica_modulo_failure.jsp";
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    response.sendRedirect(url);

  }

}