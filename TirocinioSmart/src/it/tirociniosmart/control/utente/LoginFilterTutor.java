package it.tirociniosmart.control.utente;

import it.tirociniosmart.model.utente.TutorAccademico;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/it.tirociniosmart.view.tutorAccademico/*")
public class LoginFilterTutor implements Filter {
  @Override
  public void init(FilterConfig config) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();

    if (session == null || session.getAttribute("currentSessionUser") == null) {

      response.sendRedirect(request.getContextPath() + "/it.tirociniosmart.view.utente/login.jsp");
      
    } else if (session.getAttribute("currentSessionUser") instanceof TutorAccademico) {
      chain.doFilter(req, res);
    } else {
      response.sendRedirect(request.getContextPath() + "/it.tirociniosmart.view.utente/login.jsp");
    }
  }
  
  @Override
  public void destroy() {
  }

}
