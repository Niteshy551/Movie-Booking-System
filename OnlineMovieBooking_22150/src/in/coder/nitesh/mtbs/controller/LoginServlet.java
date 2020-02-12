package in.coder.nitesh.mtbs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.coder.nitesh.mtbs.dao.LoginDao;
import in.coder.nitesh.mtbs.daoimpl.CustomerDaoImpl;
import in.coder.nitesh.mtbs.daoimpl.LoginDaoImpl;
import in.coder.nitesh.mtbs.pojo.Customer;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	HttpSession httpsession=null;
	String password,emailId,userType;
	Boolean flag;
	LoginDao logindao=new LoginDaoImpl();
	RequestDispatcher rd;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		String action=request.getParameter("action");
		httpsession = request.getSession();
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		if(action!=null && action.equalsIgnoreCase("Login"))
		{
			emailId=request.getParameter("emailId");
			password=request.getParameter("password");
			userType=request.getParameter("userType");
			
			if(userType.equalsIgnoreCase("Admin"))
			{
				flag=logindao.isAdmin(emailId, password);
				if(flag==true)
				{
					httpsession.setAttribute("Admin",emailId);
					request.setAttribute("msg", "Admin Login Successfully");
					rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else
				{
					request.setAttribute("msg", "Invaid Admin");
					rd = request.getRequestDispatcher("Login.jsp");
					rd.forward(request, response);
				}
			}
			else if(userType.equalsIgnoreCase("Customer"))
			{
				emailId=request.getParameter("emailId");
				password=request.getParameter("password");
				userType=request.getParameter("userType");
				
				if(userType.equalsIgnoreCase("Customer"))
				{
					flag=logindao.isCustomer(emailId, password);
					if(flag==true)
					{
						httpsession.setAttribute("Customer",emailId);
						request.setAttribute("msg", "Customer Login Successfully");
						Customer custobj=new CustomerDaoImpl().searchCustomerByEmailId(emailId);
						httpsession.setAttribute("custobj", custobj);
						rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					}
					else
					{
						request.setAttribute("msg", "Invaid Customer");
						rd = request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}
				}
			}
		}
	}
	 @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	 {
		
		String action=request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("Logout"))
		{
			httpsession = request.getSession();
			httpsession.invalidate();
			request.setAttribute("msg", "Logout Successfully");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	 }
}
