import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datamodel.Item;
import util.Info;

import util.Util_Item;

@WebServlet("/SearchByRoom")
public class SearchByRoom extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SearchByRoom() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Item> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = Util_Item.listItemByRoom(keyword);
      } else {
         listEmployees = Util_Item.listItems();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Item> listItems, PrintWriter out) {
      for (Item item : listItems) {
         System.out.println("[DBG] " + item.getId() + ", " //
               + item.getName() + ", " //
               + item.getDescription() + ", " //
         	   + item.getPrice());

         out.println("<li>" + item.getId() + ", " //
               + item.getName() + ", " //
               + item.getDescription() + ", " //
         	   + item.getPrice() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
