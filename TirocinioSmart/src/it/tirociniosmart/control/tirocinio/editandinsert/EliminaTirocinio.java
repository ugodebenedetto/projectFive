package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EliminaTirocinio.
 */
@WebServlet("/it.tirociniosmart.view.tutorAccademico/EliminaTirocinio")
public class EliminaTirocinio extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ArrayList<Tirocinio> tirocini =
        (ArrayList<Tirocinio>) request.getSession().getAttribute("tirociniTutor");
    int id = Integer.parseInt(request.getParameter("id"));
    System.out.println("ID = " + id);
    Tirocinio tirocinio = null;
    for (Tirocinio t : tirocini) {
      if (t.getId() == id) {
        tirocinio = t;
        tirocinio.setNumPost(0);
        tirocinio.setStato("nonDisponibile");
        try {
          tirocinio = eliminaTirocinio(tirocinio, t);
        } catch (StartupCacheException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        tirocini.remove(t);
        tirocini.add(tirocinio);
        break;
      }
    }
    request.getSession().setAttribute("tirociniTutor", tirocini);
    response.sendRedirect("i_miei_tirocini.jsp");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  /**
   * Questo metodo permette l'inserimento di un tirocinio da perte del TA nel DB.
   * 
   * @param newTirocinio oggetto .
   * @return tirocinio
   * @throws StartupCacheException .
   */
  public Tirocinio eliminaTirocinio(Tirocinio newTirocinio, Tirocinio oldTirocinio)
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateTirocinio(newTirocinio, oldTirocinio);
    return newTirocinio;
  }
}
