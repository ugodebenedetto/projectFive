package it.tirociniosmart.control.didattica.insertandedit;

import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



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
      throws ServletException {
    url = "carica_modulo_success.jsp";
    String titolo = request.getParameter("nome");
    String body = request.getParameter("body");
    
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    annunci.insertFile(request, path);

    try {
      response.sendRedirect(url);
    } catch (IOException e) {
      url = "carica_modulo_failure.jsp";
      e.printStackTrace();
    }

  }

}
