

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class PasswordChange extends HttpServlet {
	public void service(HttpServletRequest request ,HttpServletResponse response) {
		try {
			String opw=request.getParameter("opw");
			String npw=request.getParameter("npw");
			DAO_Model dm = new DAO_Model();
			dm.setCusPwd(opw);
			boolean b=dm.passwordChange(npw);
			if(b==true) {
				response.sendRedirect("/BankApp/passwordChangeSuccess.jsp");
				
			}else {
				response.sendRedirect("/BankApp/passwordChangeFailure.jsp");
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
