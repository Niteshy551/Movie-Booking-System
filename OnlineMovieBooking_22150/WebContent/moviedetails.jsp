
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, in.coder.nitesh.mtbs.pojo.Movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<%
		Movie movie = (Movie) request.getAttribute("movie");
	%>
	<jsp:include page="msg.jsp"></jsp:include>
	<table>
		<caption style="color:red">***--*** Movie Details ***--***</caption>

		<tr>
			<th colspan="2"><%=movie.getMovieName()%></th>
		</tr>
		<tr>
			<th colspan="2"><img
				src="MovieImage?movieId=<%=movie.getMovieId()%>" width="350px"
				height="250px"></th>
		</tr>
		<tr>
			<th style="color: black;">Id</th>
			<td><%=movie.getMovieId()%></td>
		</tr>
		<tr>
			<th style="color: black;">Type</th>
			<td><%=movie.getMovieType()%></td>
		</tr>
		<tr>
			<th style="color: black;">Language</th>
			<td><%=movie.getMovieLanguage()%></td>
		</tr>
		<tr>
			<th style="color: black;">Cast</th>
			<td><%=movie.getMovieCast()%></td>
		</tr>
		<tr>
			<th style="color: black;">Producer</th>
			<td><%=movie.getMovieProducer()%></td>
		</tr>
		<tr>
			<th style="color: black;">Director</th>
			<td><%=movie.getMovieDirector()%></td>
		</tr>
		<tr>
			<th style="color: black;">Duration</th>
			<td><%=movie.getMovieDuration()%></td>
		</tr>
			<tr>
			<th style="color: black;">Release Date</th>
			<td><%=movie.getReleaseDate()%></td>
		</tr>
			<tr>
			<th style="color: black;">Description</th>
			<td><%=movie.getMovieDescription()%></td>
		</tr>
			<tr>
			<th style="color: black;">Review</th>
			<td><%=movie.getMovieReview()%></td>
		</tr>

	</table>

</body>
</html>