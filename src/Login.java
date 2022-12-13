import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.UtilUser;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet{
   private static final long serialVersionUID = 1L;

   public Login() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username = request.getParameter("keyword").trim();
      String password = request.getParameter("password").trim();
      int check = UtilUser.login(username, password);
      if (check == 1)
      {
    	  request.setAttribute("user", "admin");
    	  request.getSession().setAttribute("user", "admin");
    	  request.getRequestDispatcher("/admin/simpleSearchAdmin.html").forward(request, response);
      }
      else if (check == 2)
      {
    	  request.setAttribute("user", "user");
    	  request.getSession().setAttribute("user", "user");
    	  request.getRequestDispatcher("/user/simpleSearchHB.html").forward(request, response);
      }
      else
      {
    	  request.getRequestDispatcher("accountPage.html").forward(request, response);   	  
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
