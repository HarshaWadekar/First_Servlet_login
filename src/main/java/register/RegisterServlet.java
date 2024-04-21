package register;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reg_dao_bean_DB.BeanClass;
import reg_dao_bean_DB.UserDAO;


public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BeanClass eb = new BeanClass(); // name pwd add mid phno state country

		try {
			eb.setUsername(req.getParameter("uname"));
			eb.setPassword(req.getParameter("pwd"));
			eb.setAddress(req.getParameter("address"));
			eb.setMailId(req.getParameter("mid"));
			eb.setPhoneNo(req.getParameter("phno"));
			eb.setState(req.getParameter("state"));
			eb.setCountry(req.getParameter("country"));

			int k = new UserDAO().insert(eb);
			PrintWriter pw = res.getWriter();
			if (k > 0) {
				pw.println("<html><body bgcolor=#6A1B9A text=#fffff>");
				pw.println("<h1 >data insert sucessfully.</h1>");
				pw.println("</body></html>");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
