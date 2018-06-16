

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Home extends HttpServlet {
	public void service(HttpServletRequest request ,HttpServletResponse response) {
		try {
		int custid = Integer.parseInt(request.getParameter("cusID"));
		String custpwd = request.getParameter("cusPwd");
		DAO_Model dm=  new DAO_Model();
		dm.setCusID(custid);
		dm.setCusPwd(custpwd);
		boolean b=dm.verify();
		int accno=dm.getAccno();
		HttpSession session=request.getSession(true);
		session.setAttribute("accno", accno);
		
		
		if(b==true) {
			response.sendRedirect("/BankApp/success.jsp");
		}
		else {
			response.sendRedirect("/BankApp/failure.jsp");
			
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
