<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<div class="tail-top">
	<%
		String admin = (String) session.getAttribute("Admin");
	%>
	<%
		String customer = (String) session.getAttribute("Customer");
	%>
	<div class="tail-bottom">
		<div id="main">
			<div id="header">
				<div class="row-1">
					<div class="fleft">
						<a href="#">Cinema<span>World</span></a>
					</div>
					<table>
						<tr>
							<core:if test="${Admin==null && Customer==null}">
								<td><a href="Login.jsp">Sign In</a></td>
								<td><a href="addcustomer.jsp">Sign Up</a></td>
							</core:if>

							<td align="center"><span id="welcometxt">Welcome</span> <a
								href="#"><span id="profilename">
								<core:if test="${Admin==null && Customer==null}">
								Guest...
								</core:if>
								
								<core:if test="${Admin!=null && Customer==null}">
								Admin...
								</core:if>
								
								
								<core:if test="${Admin==null && Customer!=null}">
								${custobj.custFName} ${custobj.custLName}
								</core:if>
							
								</span></a></td>
							<core:if test="${Admin!=null || Customer!=null}">
								<td style="float: right;"><a href="LoginServlet?action=Logout">Logout</a></td>
							</core:if>
						</tr>
					</table>
				</div>
				<div class="row-2">
					<ul>
						<li><a href="index.jsp" class="active">Home</a></li>
						<li><a href="movie">Movie's</a></li>
						<li><a href="show">Show's</a></li>
						
						<core:if test="${Admin!=null or Customer==null}">
							<li><a href="addMovie.jsp">Add Movie</a></li>
							<li><a href="addshow.jsp">Add Show</a></li>
							<li><a href="CustomerServlet">All Customer</a></li>
						</core:if>
						
						<core:if test="${Admin==null or Customer!=null}">
							<li><a href="#">Change Password</a></li>
						</core:if>
						
						<li><a href="#">Contacts</a></li>
						<li><a href="#">About Us</a></li>
						
					</ul>
				</div>
			</div>
			<div id="content">
				<div id="slogan">
					<div class="image png"></div>
					<div class="inside">
						<h2>
							We are breaking<span>All Limitations</span>
						</h2>
						<p>Lorem ipsum dolor consectetur adipisicing elit, sed do
							eiusmod tempor incididunt labore etolore magna aliqua enim minim
							veniam quis nostrud exercitation ullamco laboris.</p>
						<div class="wrapper">
							<a href="#" class="link1"><span><span>Learn
										More</span></span></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>