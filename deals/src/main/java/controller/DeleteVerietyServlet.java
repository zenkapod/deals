package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import dao.VerietyDbDAO;

@WebServlet( "/deleteveriety")
public class DeleteVerietyServlet extends HttpServlet {

private static final long serialVersionUID = 1L;


public DeleteVerietyServlet() throws FileNotFoundException,
IOException {
 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
	VerietyDbDAO dao = new VerietyDbDAO();
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
response.sendRedirect("/deals/verietydeal");
}
}

