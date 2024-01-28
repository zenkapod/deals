package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import dao.DealDbDAO;
import dao.VerietyDbDAO;
import domain.Deal;
import domain.VerietyDeal;

@WebServlet("/editdeal")
public class EditDealServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

 public EditDealServlet()
throws FileNotFoundException, IOException {

 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
String userPath;
List<VerietyDeal> verieties;
List<Deal> deals = null;
Deal editdeal = null;
VerietyDbDAO daoVeriety = new VerietyDbDAO();
DealDbDAO dao = new DealDbDAO();
try {
	verieties = daoVeriety.findAll();
request.setAttribute("verieties", verieties);
} catch (Exception e) {
e.printStackTrace();
}
try {
deals = dao.findAll();
verieties = daoVeriety.findAll();
for (Deal deal: deals) {
deal.setVeriety(daoVeriety.FindById(deal.getIdVeriety(), verieties));
}
}catch (Exception e) {
e.printStackTrace();
}
String strId = request.getParameter("id");
Long id = null; // id редактируемого сотрудника
if(strId != null) {
id = Long.parseLong(strId);
}
try {
	editdeal = dao.findById(id);
} catch (Exception e) {
e.printStackTrace();
}
request.setAttribute("dealEdit", editdeal);
request.setAttribute("deals", deals);
userPath = request.getServletPath();
if ("/editdeal".equals(userPath)) {
request.getRequestDispatcher("/views/editdeal.jsp").forward(request, response);
}
}
protected void doPost(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
DealDbDAO dao = new DealDbDAO();
String strId = request.getParameter("id");
Long id = null;
if(strId != null) {
id = Long.parseLong(strId);
}
String ticker = request.getParameter("ticker");
String ordertype = request.getParameter("ordertype");
String currency = request.getParameter("currency");
String veriety = request.getParameter("veriety");
int index1 = veriety.indexOf('=');
int index2 = veriety.indexOf(",");
if (index1 >= 0 && index2 >= 0) {
    String r1 = veriety.substring(index1 + 1, index2);
    Long idVeriety = Long.parseLong(r1.trim());
    VerietyDeal verietyDeal = new VerietyDeal(idVeriety, veriety);
    Deal editDeal = new Deal(id, ticker, ordertype, currency, idVeriety, verietyDeal);
try {
dao.update(editDeal);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/deals/deal");
}
}
}
