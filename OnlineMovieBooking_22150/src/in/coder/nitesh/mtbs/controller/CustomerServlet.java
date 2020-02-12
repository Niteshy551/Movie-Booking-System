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
import javax.servlet.http.Part;

import in.coder.nitesh.mtbs.dao.CustomerDao;
import in.coder.nitesh.mtbs.dao.MovieDao;
import in.coder.nitesh.mtbs.daoimpl.CustomerDaoImpl;
import in.coder.nitesh.mtbs.daoimpl.MovieDaoImpl;
import in.coder.nitesh.mtbs.pojo.Customer;
import in.coder.nitesh.mtbs.pojo.Movie;

@WebServlet("/CustomerServlet")

public class CustomerServlet extends HttpServlet {
	String custFName,custLName,custEmailId,custPassword,custContactNo,custAddress,action;
	List<Customer> custlist=null;
	HttpSession httpsession;
	Customer customer=null; 
	int custId;
	boolean flag;
	CustomerDao customerdao=new CustomerDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		action=request.getParameter("action");
		System.out.println(action);
		if(action!=null && action.equalsIgnoreCase("addCustomer"))
		{
		
		custFName = request.getParameter("custFName");
		custLName = request.getParameter("custLName");
		custEmailId = request.getParameter("custEmailId");
		custPassword = request.getParameter("custPassword");
		custContactNo = request.getParameter("custContactNo");
		custAddress = request.getParameter("custAddress");
		
		customer=new Customer(custFName, custLName, custEmailId, custPassword, custContactNo, custAddress);
		
		flag=customerdao.addCustomer(customer);
		if(flag)
		{
			request.setAttribute("msg", "Customer Added");
			
		}
		else
		{
			request.setAttribute("msg", "Customer not Added");
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("addcustomer.jsp");
		rd.forward(request, response);
		}
		
		
		else if(action!=null && action.equalsIgnoreCase("updatecustomer"))
		{
			custFName = request.getParameter("custFName");
			custLName = request.getParameter("custLName");
			custEmailId = request.getParameter("custEmailId");
			custPassword = request.getParameter("custPassword");
			custContactNo = request.getParameter("custContactNo");
			custAddress = request.getParameter("custAddress");
			
			custId=Integer.parseInt(request.getParameter("custId"));
			
			customer=new Customer(custId, custFName, custLName, custEmailId, custPassword, custContactNo, custAddress);
			
			flag=customerdao.updateCustomer(customer);
			if(flag)
			{
				request.setAttribute("msg", "Customer updated");
				httpsession=request.getSession();
				custlist=customerdao.showAllCustomer();
				httpsession.setAttribute("custlist",custlist);
				request.getRequestDispatcher("custlist.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("msg", "Customer not updated");
				customer=customerdao.searchCustomerById(custId);
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("updatecustomer.jsp").forward(request,response);
			}
		}
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		httpsession=request.getSession();
		
		action =request.getParameter("action");
		
		if(action!=null && action.equalsIgnoreCase("delete"))
		{
			custId=Integer.parseInt(request.getParameter("custId"));
			flag=customerdao.deleteCustomer(custId);
			
			if(flag)
			{	
				request.setAttribute("msg", "Customer Deleted");
				custlist=customerdao.showAllCustomer();
				httpsession.setAttribute("custlist", custlist);
			}
			else
				{
					request.setAttribute("emsg", "Customer not Deleted");	
				}
			RequestDispatcher rd=request.getRequestDispatcher("custlist.jsp");
			rd.forward(request, response);
			}
		else
		{
			custlist=customerdao.showAllCustomer();
			httpsession.setAttribute("custlist", custlist);
			response.sendRedirect("custlist.jsp");
		}
		}
		
	}
	