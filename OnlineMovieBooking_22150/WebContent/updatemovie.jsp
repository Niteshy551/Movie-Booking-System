<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.coder.nitesh.mtbs.pojo.Movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Movie</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="movie" method="post" enctype="multipart/form-data">
<input type="hidden" name="action" value="updatemovie">
<jsp:include page="header.jsp"></jsp:include>
<%
	Movie movie=(Movie)request.getAttribute("movie");
%>

<fieldset>
	<legend>Update Movie</legend>
	<table cellpadding="5" cellspacing="5">
	<tr>
		<td>Movie Id</td>
		<td><input type="text" name="movieId" value="<%=movie.getMovieId()%>" readonly></td>
	</tr>
	
	<tr>
		<td> Movie Name</td>
		<td><input type="text" name="movieName" placeholder="KGF: Chapter 1" id="mname"
		 value="<%=movie.getMovieName()%>">
		 <span style="color:Red" id="ename"></span> </td>
	</tr>
	
	<tr>
		<td> Movie Image</td>
		<td><input type="file" name="movieImage"></td>
	</tr>
	
	<tr>
			<td><label>Movie Type</label></td>
			<td>
				<select name="MovieType">
					<option <%if(movie.getMovieType().equals("Action")){%> selected <% } %>>Action</option>
					<option <%if(movie.getMovieType().equals("Romantic")){%> selected <% } %>>Romantic</option>
					<option <%if(movie.getMovieType().equals("Horror")){%> selected <% } %>>Horror</option>
					<option <%if(movie.getMovieType().equals("Animation")){%> selected <% } %>>Animation</option>
					<option <%if(movie.getMovieType().equals("Comedy")){%> selected <% } %>>Comedy</option>
				</select>
			</td>
	</tr>
	
	<tr>
		<td> Movie Language</td>
		<td><input type="text" name="movieLanguage" placeholder="" id="mlanguage"
		 value="<%=movie.getMovieLanguage()%>"> <span style="color:Red" id="elanguage"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Cast</td>
		<td><input type="text" name="movieCast" placeholder="" id="mcast"
		 value="<%=movie.getMovieCast()%>"> <span style="color:Red" id="ecast"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Producer</td>
		<td><input type="text" name="movieProducer" placeholder="" id="mProducer" 
		value="<%=movie.getMovieProducer()%>"> <span style="color:Red" id="eproducer"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Director</td>
		<td><input type="text" name="movieDirector" placeholder="" id="mdirector"
		 value="<%=movie.getMovieDirector()%>"> <span style="color:Red" id="edirector"></span> </td>
	</tr>
	
	<tr>
		<td> Movie Duration</td>
		<td><input type="text" name="movieDuration" placeholder="" id="mduration"
		 value="<%=movie.getMovieDuration()%>"> <span style="color:Red" id="eproducer"></span> </td>
	</tr>
	
	<tr>
		<td> Release Date</td>
		<td><input type="text" name="releaseDate" placeholder="DD-MM-YYYY" id="mreleasedate" 
		value="<%=movie.getReleaseDate()%>"> <span style="color:Red" id="ereleasedate"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Description</td>
		<td><input type="text" name="movieDescription" placeholder="" id="mdescreption"
		 value="<%=movie.getMovieDescription()%>"> <span style="color:Red" id="edescreption"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Review</td>
		<td><input type="text" name="movieReview" placeholder="" id="mreview" 
		value="<%=movie.getMovieReview()%>"> <span style="color:Red" id="ereview"></span> </td>
	</tr>
	
	<tr>
		<td><input type="submit" name="btnType" id="btnRegister"
					value="Update"></td>
					<td><input type="reset" name="btnReset" value="Reset"></td>
	</tr>
	
	</table>
</form>	
</fieldset>
</body>
</html>