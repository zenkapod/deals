package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import domain.VerietyDeal;
import dao.VerietyDbDAO;

@WebServlet("/editveriety")
public class EditVerietyServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 public EditVerietyServlet()
throws FileNotFoundException, IOException {
 }
 
protected void doGet(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
String userPath;
List<VerietyDeal> verieties;
VerietyDeal editveriety = null;
VerietyDbDAO dao = new VerietyDbDAO();
try {
	verieties = dao.findAll();
request.setAttribute("verieties", verieties);
} catch (Exception e) {
e.printStackTrace();
}
String strId = request.getParameter("id");
Long id = null; // id редактируемой должности
if(strId != null) {
id = Long.parseLong(strId);
}
try {
	editveriety = dao.findById(id);
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
request.setAttribute("verietyEdit", editveriety);
userPath = request.getServletPath();
if ("/editveriety".equals(userPath)) {
request.getRequestDispatcher("/views/editveriety.jsp")
.forward(request, response);
}
}
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
	VerietyDbDAO dao = new VerietyDbDAO();
String strId = request.getParameter("id");
Long id = null;
if(strId != null) {
id = Long.parseLong(strId);
}
String nameveriety = request.getParameter("inputVeriety");
VerietyDeal editveriety = new VerietyDeal(id, nameveriety);
try {
dao.update(editveriety);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/deals/verietydeal");
}
}