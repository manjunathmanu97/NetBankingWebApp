

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	public void service(HttpServletRequest request ,HttpServletResponse response) {
		try {
		int amttranf=Integer.parseInt(request.getParameter("amttranf"));
		DAO_Model dm = new DAO_Model();
		HttpSession session= request.getSession();
		int accno =(int)session.getAttribute("accno");
		dm.setAccno(accno);
		boolean b=dm.transfer(amttranf);
		if(b==true) {
			response.sendRedirect("/BankApp/transferSuccess.jsp");
		}
		else {
			response.sendRedirect("/BankApp/transferFailure.jsp");
		}
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
