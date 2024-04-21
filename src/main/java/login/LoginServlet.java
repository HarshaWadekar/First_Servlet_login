package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Spliterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reg_dao_bean_DB.BeanClass;
import reg_dao_bean_DB.LogInDAO;
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		
	String name = req.getParameter("uname");
	String password = req.getParameter("pwd");
	
	
	BeanClass eb = new LogInDAO().login(name, password);
	
	ArrayList<BeanClass> al = LogInDAO.al;
	Spliterator<BeanClass> sp = al.spliterator();
	PrintWriter pw = res.getWriter();
	if(eb!=null)
	{
		sp.forEachRemaining((k) -> {
			pw.println("<html><body bgcolor=#99FF66 text=black>");
			pw.println("<h1 >"+k.getUsername()+"&nbsp &nbsp"+k.getPassword()+"&nbsp &nbsp"+k.getAddress()+				"&nbsp&nbsp"+k.getMailId()+"&nbsp&bsp"+k.getPhoneNo()+"&nbsp&nbsp"+k.getState()+"&nbsp&nbsp"+k.getCountry()+"</h1>");
		});
		pw.println("</body></html>");

	}	
	}
}
