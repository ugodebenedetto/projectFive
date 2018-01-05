/**
 * Servlet che permette all'utente TA di modificare un tirocinio
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

@WebServlet("/it.tirociniosmart.view.tutorAccademico/ModificaTirocinio")
public class ModificaTirocinio extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException eccezione IO
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String url = "i_miei_tirocini.jsp";
    //prendo il tirocinio dalla session
    Tirocinio oldTirocinio = (Tirocinio) request.getSession().getAttribute("tirocinioModifica");
    ArrayList<Tirocinio> tirocini = (ArrayList<Tirocinio>) request.getSession().getAttribute("tirocini");
    TutorAccademico ta = (TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    //ricevo dati tirocinio da TA tramite form
    String nome = request.getParameter("nome");
    if (nome.equals("")) {
      nome = oldTirocinio.getNome();
    }
    String obiettivi = request.getParameter("Obiettivi");
    if (obiettivi.equals("")) {
      obiettivi = oldTirocinio.getObiettivi();
    }
    String descrizione = request.getParameter("Descrizione");
    if (descrizione.equals("")) {
      descrizione = oldTirocinio.getDescrizione();
    }
    String numPostString = request.getParameter("Numero Posti");
    
    int numPost = 0;
    if (numPostString.equals("")) {
      numPost = Integer.parseInt(numPostString);
      numPost = oldTirocinio.getNumPost();
    } else {
      numPost = Integer.parseInt(numPostString);
    }
    String sede = request.getParameter("Sede");
    if (sede.equals("")) {
      sede = oldTirocinio.getSede();
    }
    String tipo = request.getParameter("Tipo");
    if (tipo.equals("")) {
      tipo = oldTirocinio.getTipo();
    }
    String responsabile = request.getParameter("Responsabile");
    if (responsabile.equals("")) {
      responsabile = oldTirocinio.getResponsabile();
    }
    //controllare se i campi sono quelli giusti
      
    //creo l'oggetto tirocinio
    Tirocinio newTirocinio = new Tirocinio(nome, obiettivi, descrizione, numPost,
        ta, sede, tipo, responsabile); 
      
    //chiamo la funzione che modifica il tirocinio
    try {
      modificaTirocinio(oldTirocinio, newTirocinio);
      tirocini.remove(oldTirocinio);
    } catch (StartupCacheException e) {
      e.printStackTrace();
    }
    request.getSession().removeAttribute("tirocinioModifica");
    request.getSession().setAttribute("tirocini", tirocini);
    response.sendRedirect(url);
  }    


  /**
   * Questo metodo permette la modifica di un tirocinio da perte del TA nel DB.
   * 
   * @param tirocinio oggetto tirocinio che dev'essere sostituito
   * @param nuovoTirocinio tirocinio da sostituire al vecchio
   * @return tirocinio
   * @throws StartupCacheException 
   */
  
  public Tirocinio modificaTirocinio(Tirocinio tirocinio, Tirocinio nuovoTirocinio) 
      throws StartupCacheException {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory tirocinioFactory = (TirocinioDAOFactory) producer.getFactory("tirocinioDAO");
    TirocinioDAO tiroc = (ProxyTirocinioDAO) tirocinioFactory.getTirocinioDao();
    tiroc.updateTirocinio(nuovoTirocinio, tirocinio);
    return tirocinio;

  }
}
