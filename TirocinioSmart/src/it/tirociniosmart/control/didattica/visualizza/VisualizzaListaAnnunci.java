package it.tirociniosmart.control.didattica.visualizza;

import it.tirociniosmart.model.annuncio.Annuncio;
import it.tirociniosmart.model.annuncio.ProxyAnnuncioDao;
import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.utente.Didattica;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servelt che permete alla didattica di visualizzare la lista di tutti gli annunci.
 * 
 * @author Clara Monaco
 */


@WebServlet("/VisualizzaListaAnnunci")
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
    //CODICE GIUSTO
    // ArrayList<Annuncio> annunci = visualizzaListaAnnuncio();

    //CODICE DI PROVA
    ArrayList<Annuncio> annunci = new ArrayList<Annuncio>();
    Annuncio a =
        new Annuncio(
            "prova", new Didattica("prova@prova.it", "ADFF", "prova", "provaaa", "prova",
                "12/12/1111", "no", "m", "r", "via", "3455", false),
            "12/12/1200", "annuncio di prova 1", "prova");
    Annuncio a1 =
        new Annuncio(
            "prova", new Didattica("prova@prova.it", "ADFF", "prova", "provaaa", "prova",
                "12/12/1111", "no", "m", "r", "via", "3455", false),
            "12/12/1200", "annuncio di prova 2", "prova");
    Annuncio a2 =
        new Annuncio(
            "prova", new Didattica("prova@prova.it", "ADFF", "prova", "provaaa", "prova",
                "12/12/1111", "no", "m", "r", "via", "3455", false),
            "12/12/1200", "annuncio di prova 3", "prova");
    annunci.add(a);
    annunci.add(a1);
    annunci.add(a2);
    request.getSession().setAttribute("annunci", annunci);
    response.sendRedirect("it.tirociniosmart.view.didattica/annunci.jsp");
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
  public ArrayList<Annuncio> visualizzaListaAnnuncio() {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyAnnuncioDao proxyAnnuncio = (ProxyAnnuncioDao) factory.getAnnuncioDao();
    return proxyAnnuncio.selectAnnuncio();

  }
}
