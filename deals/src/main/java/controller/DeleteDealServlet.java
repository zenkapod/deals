package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import dao.DealDbDAO;

@WebServlet( "/deletedeal")
public class DeleteDealServlet extends HttpServlet {

private static final long serialVersionUID = 1L;


public DeleteDealServlet() throws FileNotFoundException,
IOException {
 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
	DealDbDAO dao = new DealDbDAO();
String strId = request.getParameter("id");
Long deleteid = null;
if(strId != null) {
deleteid = Long.parseLong(strId);
}
try {
dao.delete(deleteid);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/deals/deal");
}
}

