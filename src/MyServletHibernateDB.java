import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import datamodel.Item;
import util.Util_Item;

@WebServlet("/MyServletHibernateDB")
public class MyServletHibernateDB extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public MyServletHibernateDB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");

      // #1
      //Util_Item.createItem("Chair", "It is a Chair", "$25.00", true, false, "Locations", "Kitchen, Living Room, Dining Room");
      //Item it = new Item("Blender", "It is a blender", "$25.00", true, false, "Locations", "Kitchen");
      //util.Cart.addItem(request, it);
      // #2
      retrieveDisplayData(response.getWriter());
   }

   void retrieveDisplayData(PrintWriter out) {
      String title = "Database Result";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + //
            "transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");
      List<Item> listItems = Util_Item.listItems();
      for (Item employee : listItems) {
         System.out.println("[DBG] " + employee.getId() + ", " //
               + employee.getName() + ", " //
               + employee.getDescription() + ", " //
               + employee.getPrice());

         out.println("<li>" + employee.getId() + ", " //
               + employee.getName() + ", " //
               + employee.getDescription() + ", " //
               + employee.getPrice() + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
