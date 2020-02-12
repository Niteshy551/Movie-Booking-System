<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,in.coder.nitesh.mtbs.pojo.Show" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show List</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="msg.jsp"></jsp:include>
	<%
	List<Show> showlist=(List<Show>)request.getAttribute("showlist");
	if(showlist==null)
	{
		showlist=(List<Show>)session.getAttribute("showlist");
	}
	%>
	
	<table border="1" cellspacing="5" style="color:white;">
		<tr>
			<th>Show Id</th>
			<th>Movie Id Id</th>
			<th>Movie Image</th>
			<th>Movie Name</th>
			<th>Theatre Name</th>
			<th>Screen Name</th>
			<th>Show Type</th>
			<th>Show Date</th>
			<th>Show  Start Time</th>
			<th>Show End Time</th>
			<th>Show Price</th>
		</tr>
		
		<% for(Show show:showlist) {%>
		<tr>
			<td><%=show.getShowId() %></td>
			<td><%=show.getMovieId() %></td>
			<td><img src="MovieImage?movieId=<%=show.getMovie().getMovieId()%>" width="150" height="150"></td>
			<td><%=show.getMovie().getMovieName()%></td>
			<td><%=show.getTheatreName() %></td>
			<td><%=show.getScreenName() %></td>
			<td><%=show.getShowType() %></td>
			<td><%=show.getShowDate() %></td>
			<td><%=show.getShowStartTime() %></td>
			<td><%=show.getShowEndTime() %></td>
			<td><%=show.getPrice() %></td>
			
			
				<td>
				<core:if test="${Admin!=null and Customer==null}">
				 <a href="show?action=delete&showId=<%= show.getShowId() %>" onclick="return confirm('Do you Want to Delete')"> Delete </a>
				 <a href="show?action=edit&showId=<%= show.getShowId() %>">Edit</a>
				</core:if>
			
					<a href="Booking?action=booktheshow&showId=<%=show.getShowId() %>">Book</a>
				</td>
		</tr>
		<%} %>
</body>
</html>