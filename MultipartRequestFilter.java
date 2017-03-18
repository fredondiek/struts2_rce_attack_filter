package pt.sc.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class MultipartRequestFilter   extends StrutsPrepareAndExecuteFilter
{
  private static final Log logger = LogFactory.getLog(RequestFilter.class);
  private static final String UNAVAILABLE_PAGE = "/unavailable.html"; //Customize
  
  public void destroy()
  {
    super.destroy();
  }
  
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
    throws IOException, ServletException
  {
    
    String contentType = arg0.getContentType();
    if ((contentType != null) && (
      (contentType.indexOf("multipart/form-data") == 0) || (contentType.indexOf("text/xml") == 0) || 
      (contentType.indexOf("application/x-www-form-urlencoded") == 0)))
    {
      HttpServletResponse response = (HttpServletResponse)arg1;
      response.addHeader("Access-Control-Allow-Origin", "*");
      response.addHeader("Access-Control-Allow-Headers", "X-Requested-With");
      super.doFilter(arg0, arg1, arg2);
      return;
    }
    if (contentType == null)
    {
      HttpServletResponse response = (HttpServletResponse)arg1;
      response.addHeader("Access-Control-Allow-Origin", "*");
      response.addHeader("Access-Control-Allow-Headers", "X-Requested-With");
      super.doFilter(arg0, arg1, arg2);
      return;
    }
    HttpServletRequest req = (HttpServletRequest)arg0;
    arg0.getRequestDispatcher("/unavailable.html").forward(arg0, arg1);
    logger.debug("Redirected request (" + req.getRequestURI() + ") to Unavailable page.");
  }
  
  public void init(FilterConfig arg0)
    throws ServletException
  {
    super.init(arg0);
  }
}
