package in.coder.nitesh.mtbs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.nitesh.mtbs.dao.ShowDao;
import in.coder.nitesh.mtbs.daoimpl.BookingDaoImpl;
import in.coder.nitesh.mtbs.daoimpl.ShowDaoImpl;
import in.coder.nitesh.mtbs.pojo.Booking;
import in.coder.nitesh.mtbs.pojo.Show;
@WebServlet("/Booking")
public class BookingServlet extends HttpServlet {
	private String action,custEmailId;
	private HttpSession httpsession;
	private Show show=null;
	private int showId;
	private Booking booking=null;
	private ShowDao showdao=new ShowDaoImpl();
	private String bookedseats;
	String bookingSeats;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		action=request.getParameter("action");
		httpsession=request.getSession();
		if(action!=null && action.equalsIgnoreCase("BookTheShow")) 
		{	
			custEmailId=(String)httpsession.getAttribute("Customer");
			showId=Integer.parseInt(request.getParameter("showId"));
			bookingSeats=request.getParameter("bookedseats");
			
			Booking bookingdetails=new BookingDaoImpl().bookShow(showId, custEmailId, bookingSeats);
			 request.setAttribute("bookingdetails", bookingdetails);
			 request.getRequestDispatcher("Ticket.jsp").forward(request, response);
			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		action=request.getParameter("action");
		httpsession=request.getSession();
		if(action!=null && action.equalsIgnoreCase("booktheshow")) {
			custEmailId=(String)httpsession.getAttribute("Customer");
			if(custEmailId!=null)
			{
				 showId = Integer.parseInt(request.getParameter("showId"));
				 show=showdao.showById(showId);
				 List<String> bookedseatlist=new BookingDaoImpl().getAllBookSeats(showId);
				 
				 request.setAttribute("show", show);
				 request.setAttribute("bookedseatlist", bookedseatlist);
				 request.getRequestDispatcher("booktheseats.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("emsg", "Please login....");
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		}
	}
}
