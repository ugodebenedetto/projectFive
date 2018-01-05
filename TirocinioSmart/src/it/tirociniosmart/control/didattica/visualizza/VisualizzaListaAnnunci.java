package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.AnnuncioDAO;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDAO;
import it.tirociniosmart.model.factory.AbstractFactory;
import it.tirociniosmart.model.factory.AnnuncioDAOFactory;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.utente.Didattica;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli annunci.
 * 
 * @author Clara Monaco
 */


@WebServlet("/it.tirociniosmart.view.didattica/VisualizzaListaAnnunci")
public class VisualizzaListaAnnunci extends HttpServlet {

  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * @throws IOException
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    HashMap<String, Annuncio> annunci = visualizzaListaAnnuncio();
    request.getSession().setAttribute("annunci", annunci);
    response.sendRedirect("annunci.jsp");
  }


  /**
   * Gestisce il metodo HTTP POST. con questo metodo possiamo gestire la richiesta di controllo
   * lista annunci permettendo poi l'iterazione con essi.
   * 
   * 
   * @param request richiesta che arriva alla servlet
   * @param response risposta della servlet
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}


  /**
   * Questo metodo visualizza tutti gli annunci.
   * 
   * @return ArrayList Annuncio
   */
  public HashMap<String, Annuncio> visualizzaListaAnnuncio() {
    FactoryProducer producer = FactoryProducer.getIstance();
    AbstractFactory annuncioFactory = (AnnuncioDAOFactory) producer.getFactory("annuncioDAO");
    AnnuncioDAO annunci = (ProxyAnnuncioDAO) annuncioFactory.getAnnuncioDao();
    return annunci.selectAnnuncio();

  }
}
