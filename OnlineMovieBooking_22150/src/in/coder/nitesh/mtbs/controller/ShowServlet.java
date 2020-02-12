package in.coder.nitesh.mtbs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.nitesh.mtbs.dao.ShowDao;
import in.coder.nitesh.mtbs.daoimpl.ShowDaoImpl;
import in.coder.nitesh.mtbs.pojo.Show;
@WebServlet("/show")
public class ShowServlet extends HttpServlet 
{
	String theatreName,screenName,showType,showDate,showStartTime,showEndTime,action;
	double price;
	int showId,movieId;
	List<Show> showlist=null;
	boolean flag;
	HttpSession httpsession;
	Show show=null;
	ShowDao showdao=new ShowDaoImpl();
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		action=request.getParameter("action");
		System.out.println(action);
		
		if(action!=null && action.equalsIgnoreCase("addshow"))
		{
			movieId=Integer.parseInt(request.getParameter("movieId"));
			theatreName = request.getParameter("theatreName");
			screenName = request.getParameter("screenName");
			showType = request.getParameter("showType");
			showDate = request.getParameter("showDate");
			showStartTime = request.getParameter("showStartTime");
			showEndTime = request.getParameter("showEndTime");
			price = Double.parseDouble(request.getParameter("price"));
			
			show =new Show(movieId, theatreName, screenName, showType, showDate, showStartTime, showEndTime, price);
			
			flag = showdao.addShow(show);
			
			if(flag)
			{
				request.setAttribute("msg", "Show Added");
			}
			else
			{
				request.setAttribute("emsg", "Show not Added");
			}
			RequestDispatcher rd=request.getRequestDispatcher("addshow.jsp");
			rd.forward(request, response);
			}
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		httpsession=request.getSession();
		
		action =request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("delete"))
		{
			showId=Integer.parseInt(request.getParameter("showId"));
			flag=showdao.deleteShow(showId);
			
			if(flag)
			{
				showlist=showdao.showAllShow();
				httpsession.setAttribute("showlist", showlist);
				request.setAttribute("msg", "Show Deleted");
			}
			else
				{
					request.setAttribute("emsg", "Show not Deleted");	
				}
			RequestDispatcher rd=request.getRequestDispatcher("movielist.jsp");
			rd.forward(request, response);
			}
		else if(action!=null && action.equalsIgnoreCase("edit"))
		{
			movieId=Integer.parseInt(request.getParameter("movieId"));
			show=showdao.showById(showId);
			if(show!=null)
			{
				request.setAttribute("show", show);
				RequestDispatcher rd=request.getRequestDispatcher("updatemovie.jsp");
				rd.forward(request,response);
			}
		}
		else
		{
			showlist=showdao.showAllShow();
			
			httpsession.setAttribute("showlist", showlist);
			response.sendRedirect("showlist.jsp");
		}
		
		
	}
}
