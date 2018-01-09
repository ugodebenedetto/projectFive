/**
* Servlet che permette all'utente TA di inserire un tirocinio
* 
* @author Clara Monaco
*/

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */

package it.tirociniosmart.control.tirocinio.editandinsert;

import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.factory.TirocinioDAOFactory;
import it.tirociniosmart.model.persistancetools.StartupCacheException;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDAO;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.tirocinio.TirocinioDAO;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/it.tirociniosmart.view.tutorAccademico/InserisciTirocinio")
public class InserisciTirocinio extends HttpServlet {
  
  private static final long serialVersionUID = 1L;
  
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta
   * @param response risposta
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta
   * @param response risposta
   * @throws IOException exception
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
    
    String url = "aggiungi_tirocinio_success.jsp";
    
    ArrayList<Tirocinio> tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirociniTutor");
    //i controlli sono già nella form
    //ricevo dati tirocinio da TA tramite form
    String nome = request.getParameter("nome");
    String obiettivi = request.getParameter("Obiettivi");
    String descrizione = request.getParameter("Descrizione");
    int numPost = Integer.parseInt(request.getParameter("Numero Posti"));
    String sede = request.getParameter("Sede");
    String tipo = request.getParameter("Tipo");
    String responsabile = request.getParameter("Responsabile");

    TutorAccademico ta = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
      
    //creo e aggiungo tirocinio
    Tirocinio tirocinio = new Tirocinio(nome, obiettivi, descrizione,numPost,
        ta, sede, tipo, responsabile); 
    tirocinio.setStato("disponibile");
    try {
      inserisciTirocinio(tirocinio);
      tirocini.add(tirocinio);
    } catch (StartupCacheException e) {
      // TODO Auto-generated catch block
      url = "aggiungi_tirocinio_failure.jsp";
      e.printStackTrace();
    }
    request.getSession().setAttribute("tirociniTutor", tirocini);
    response.sendRedirect(url);
  } 

  /**
   * Questo metodo permette l'inserimento di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto
   * @return tirocinio
   * @throws StartupCacheException .
   */
  public Tirocinio inserisciTirocinio(Tirocinio tirocinio) throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.insertTirocinio(tirocinio);
    return tirocinio;
  }

}