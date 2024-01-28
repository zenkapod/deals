package controller;
import java.io.IOException;
import java.util.List;

import dao.DealDbDAO;
import dao.VerietyDbDAO;
import domain.Deal;
import domain.VerietyDeal;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
* Servlet implementation class RoleServlet_
*/
@WebServlet("/deal")
public class DealsServle extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public DealsServle() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request,
HttpServletResponse response)
*/
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 String userPath;
	 List<Deal> deals;
	 List<VerietyDeal> verieties;
	 VerietyDbDAO daoVeriety = new VerietyDbDAO();
	 DealDbDAO dao = new DealDbDAO();
	 try {
		 verieties = daoVeriety.findAll();
		 request.setAttribute("verieties", verieties);
		 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
		 }

	 try {
	 deals = dao.findAll();
	 verieties = daoVeriety.findAll();
	 for (Deal deal: deals) {
	 deal.setVeriety(daoVeriety.FindById(deal.getIdVeriety(), verieties));
	 }
	 request.setAttribute("deals", deals);
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }
	  userPath = request.getServletPath();
	 if("/deal".equals(userPath)){
	 request.getRequestDispatcher("/views/deal.jsp").forward(request
	 , response);
	 }
	}
/**
* @see HttpServlet#doPost(HttpServletRequest request,
HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException, IOException {
	DealDbDAO dao = new DealDbDAO();
    String ticker = request.getParameter("ticker");
    String ordertype = request.getParameter("ordertype");
    String currency = request.getParameter("currency");
    String veriety = request.getParameter("veriety");
    int index1 = veriety.indexOf('=');
    int index2 = veriety.indexOf(",");
    String r1 = veriety.substring(index1 + 1, index2);
    Long idVeriety = Long.parseLong(r1.trim());
    VerietyDeal verietyDeal = new VerietyDeal(idVeriety, veriety);
    Deal newDeal = new Deal(idVeriety, ticker, ordertype, currency, idVeriety, verietyDeal);
	try {
	Long index = dao.insert(newDeal);
	System.out.println("Adding result: " + index );
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
doGet(request, response);
}
}