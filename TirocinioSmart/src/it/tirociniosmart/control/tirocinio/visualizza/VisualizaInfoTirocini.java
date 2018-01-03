/**
 * Servlet che permete di visualizzare le info relative ai tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */
package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.RichiestaTirocinio;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import it.tirociniosmart.model.utente.TutorAccademico;

import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VisualizaInfoTirocini extends HttpServlet {
  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    //bisogna prendere il tirocinio selezionato
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinioSession = new Tirocinio("", "", 1, ta);
    Tirocinio tirocinio = visualizzaTirocinio(tirocinioSession);
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    //bisogna prendere il tirocinio selezionato
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    Tirocinio tirocinioSession = new Tirocinio("", "", 1, ta);
    ArrayList<Studente> listaStudente = visualizzaTirocinanti(tirocinioSession);
  }
  

  /**
   * Questo metodo visualizza tutti gli studenti tirocinanti ad un tirocinio.
   * 
   * @param tirocinio tirocinio di cui visualizzare i tirocinanti
   * @return ArrayList Studente
   * 
   */
  public ArrayList<Studente> visualizzaTirocinanti(Tirocinio tirocinio) {
    
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    ArrayList<Studente> listaTirocinanti;
    int num = tirocinio.getNumPost();
    ArrayList<RichiestaTirocinio> listaRichieste = proxyTirocinio.selectRichiestaTirocinio();
    for (RichiestaTirocinio r : listaRichieste) {
      if (r.getStato() == "richiestaAccettata") {
        listaTirocinanti.add(r.getRichiedente());
      }
    }
    return listaTirocinanti;
  }

  /**
   * Questo metodo visualizza tirocinio.
   * 
   * @param tirocinio tirocinio da visualizzare
   * @return Tirocinio
   * 
   */
  public Tirocinio visualizzaTirocinio(Tirocinio tirocinio) {
    FactoryProducer factory = FactoryProducer.getIstance();
    ProxyTirocinioDao proxyTirocinio = (ProxyTirocinioDao) factory.getTirocinioDao();
    //vedere qui
    //tutor accademico dalla session
    //TutorAccademico ta= 
    //(TutorAccademico) request.getSession().getAttribute("currentSessionUser");
    TutorAccademico ta = new TutorAccademico("", "", "", "", "", "", "", "", "", "", "", "", "");
    tirocinio = proxyTirocinio.findTirocinioForTutorAccademico(ta);
    return tirocinio;
  }
}
