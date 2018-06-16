

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TransferFilter
 */
public class TransferFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransferFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		String taccno = request.getParameter("tpaccno");
		int amttransf = Integer.parseInt(request.getParameter("amttranf"));
		if( amttransf > 0) {
		

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
		else {
			((HttpServletResponse)response).sendRedirect("/BankApp/errorTransfer.jsp");
			
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
