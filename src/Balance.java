

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Balance extends HttpServlet {
	public void service(HttpServletRequest request ,HttpServletResponse response) {
		try {
			HttpSession session=request.getSession();
			int accno = (int) session.getAttribute("accno");
			DAO_Model dm = new DAO_Model();
			dm.setAccno(accno);
			boolean b=dm.balance();
			int balance=dm.getBalance();
			session.setAttribute("balance", balance);
			if(b==true) {
				response.sendRedirect("/BankApp/balanceSuccess.jsp");
			}
			else {
				response.sendRedirect("/BankApp/balanceFailure.jsp");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
