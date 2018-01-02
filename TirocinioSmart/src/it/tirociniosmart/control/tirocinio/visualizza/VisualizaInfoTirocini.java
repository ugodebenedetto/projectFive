/**
 * Servlet che permete di visualizzare le info relative ai tirocini
 * 
 * @author Clara Monaco
 */

/* Commento di recommit - causa perdita dati e messaggio relativo alle precedenti commit */
package it.tirociniosmart.control.tirocinio.visualizza;

import it.tirociniosmart.model.factory.FactoryProducer;
import it.tirociniosmart.model.tirocinio.ProxyTirocinioDao;
import it.tirociniosmart.model.tirocinio.Tirocinio;
import it.tirociniosmart.model.utente.Studente;
import java.util.ArrayList;
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
    Tirocinio tirocinio = visualizzaTirocinio(tirocinio);
  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {
    ArrayList<Studente> listaStudente = visualizzaTirocinanti(tirocinio);
  }
  

  /**
   * Questo metodo visualizza tutti gli studenti tirocinanti ad un tirocinio.
   * 
   * @param tirocinio tirocinio di cui visualizzare i tirocinanti
   * @return ArrayList Studente
   * 
   */
  public ArrayList<Studente> visualizzaTirocinanti(Tirocinio tirocinio) {
    
    return //metodo che restituisca i tirocinanti

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
    tirocinio1 = proxyTirocinio.findTirocinioForTutorAccademico(tutoraccademico);
    return tirocinio1;
  }
}
