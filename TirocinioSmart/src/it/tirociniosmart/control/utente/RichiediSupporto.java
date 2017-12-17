/**
 * Servelt che permete all'utente richiedere supporto. Fornisce la possibilità di inviare una
 * e-mail all'assistenza tecnica del dipartimento d'Informatica dell'Università degli Studi di
 * Salerno, per richiedere delle informazioni.
 * 
 * @author Clara Monaco
 */

package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.Utente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RichiediSupporto extends HttpServlet {

  private static final long serialVersionUID = 1L;


  /**
   * Gestisce il metodo HTTP GET.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * @throws IOException .
   * 
   * 
   */


  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String from = null;
    if (request.getSession().getAttribute("currentSessionUser") != null) {
      Utente utente = (Utente) request.getSession().getAttribute("currentSessionUser");
      from = utente.getEmail();
    } else {
      from = request.getParameter("emailFrom");
    }

    String to = request.getParameter("emailTo");
    String host = "localhost";
    Properties prop = System.getProperties();
    prop.setProperty("mail.smtp.host", host);
    Session session = Session.getDefaultInstance(prop);
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      MimeMessage message = new MimeMessage(session);

      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Subject line");
      message.setText("This is the actual message");

      // send message
      Transport.send(message);
      String title = "send email";
      String res = "Sent message successfully...";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

      out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
          + "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n"
          + "<p align = \"center\">" + res + "</p>\n" + "</body>\n" + "</html>");

    } catch (AddressException e) {
      e.printStackTrace();
    } catch (javax.mail.MessagingException e) {
      e.printStackTrace();
    }


  }


  /**
   * Gestisce il metodo HTTP POST.
   * 
   * @param request richiesta inviata al server
   * @param response risposta inviata dal server
   * 
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) {}
}
