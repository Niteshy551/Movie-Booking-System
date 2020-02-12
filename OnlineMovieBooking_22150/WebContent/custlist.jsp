<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,in.coder.nitesh.mtbs.pojo.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="msg.jsp"></jsp:include>
	
	<%
	List<Customer> custlist =(List<Customer>)session.getAttribute("custlist");
	%>
	<table>
	<tr>
		<th>custFName</th>
		<th>custLName</th>
		<th>custEmailID</th>
		<th>custPassword</th>
		<th>custContactNo</th>
		<th>custAddress</th>
	</tr>
	
	<% for(Customer customer:custlist) {%>
	<tr>
		<td><%= customer.getCustFName() %></td>
			<td><%= customer.getCustLName() %></td>
				<td><%= customer.getCustEmailId() %></td>
					<td><%= customer.getCustPassword() %></td>
						<td><%= customer.getCustContactNo() %></td>
							<td><%= customer.getCustAddress() %></td>
	
		<td> <a href="CustomerServlet?action=delete&custId=<%= customer.getCustId() %>" onclick="return confirm('Do you Want to Delete')"> Delete </a>
			<a href="CustomerServlet?action=edit&custId=<%= customer.getCustId() %>"> Update </a>	
			<a href="CustomerServlet?action=details&custId=<%= customer.getCustId() %>"> Details </a>	
			<a href="CustomerServlet?action=shows&custId=<%= customer.getCustId() %>"> Shows </a>			
		</td>
	</tr>
	<%} %>
	</table>
</body>
</html>