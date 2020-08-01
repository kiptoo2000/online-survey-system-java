package beans;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Request {

      public static HttpSession getSession() {
          return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      }
      public static HttpServletRequest getRequest() {
          return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
      }
}
