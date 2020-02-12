<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
	<%@ page import="java.util.List,in.coder.nitesh.mtbs.pojo.Movie" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show All Movies</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>


<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="msg.jsp"></jsp:include>
	<%
		List<Movie> movielist=(List<Movie>)session.getAttribute("movielist");
	%>
		
		<table border="1" cellspacing="5" style="color:white;">
		<tr>
			<th>Movie Id</th>
			<th>Movie Image</th>
			<th>Movie Name</th>
			<th>Movie Type</th>
			<th>Release Date</th>
			<th>Movie Review</th>
			
			
			
		</tr>
	<% for(Movie movie:movielist) {%>
	<tr>
		<td><%= movie.getMovieId() %></td>
		<td><img src="MovieImage?movieId=<%=movie.getMovieId()%>" width="150" height="150"></td>
		<td><%= movie.getMovieName() %></td>
		<td><%= movie.getMovieType() %></td>
		<td><%= movie.getReleaseDate() %></td>
		<td><%= movie.getMovieReview() %></td>
		
		<td> 
		<core:if test="${Admin!=null && Customer==null}">
			<a href="movie?action=delete&movieId=<%= movie.getMovieId() %>" onclick="return confirm('Do you Want to Delete')"> Delete </a>
			<a href="movie?action=edit&movieId=<%= movie.getMovieId() %>"> Edit </a>
		</core:if>
			
		<core:if test="${Admin==null && Customer!=null}">
			<a href="movie?action=details&movieId=<%= movie.getMovieId() %>"> Details </a>
			<a href="movie?action=shows&movieId=<%= movie.getMovieId() %>"> Shows </a>
		</core:if>
		</td>
	</tr>
	<%} %>
	</table>
</body>
</html>