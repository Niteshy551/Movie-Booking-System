<%@page import="in.coder.nitesh.mtbs.daoimpl.MovieDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.List,in.coder.nitesh.mtbs.pojo.Movie" %>
     <%@page import="in.coder.nitesh.mtbs.daoimpl.MovieDaoImpl"%>
	<%@page import="in.coder.nitesh.mtbs.pojo.Show"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Show</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>
<body>

<input type="hidden" name="action" value="addshow">
<jsp:include page="header.jsp"></jsp:include>
<%
	List<Movie> movielist=new MovieDaoImpl().showAllMovie();
%>
<form action="show" method="post" >
<input type="hidden" name="action" value="addshow">
<div class="form-style">
			<fieldset>
				<legend>New Show</legend>
				<table cellpadding="10" cellspacing="10">
					<tr>
						<td><label>Select Movie</label></td>
						<td><select name="movieId">
								<option>Select</option>
								<%for(Movie movie:movielist) { %>
								<option value="<%= movie.getMovieId()%>">
								<%=movie.getMovieName() %>
								</option>
								<%} %>
						</select></td>
					</tr>

					<tr>
						<td><label>Select Theater</label></td>
						<td><select name="theatreName">
								<option>Select</option>
								<optgroup label="Mumbai">
									<option value="PA">PVR Andheri</option>
									<option>Phoenix Bandra</option>
									<option>PVR Churchgate</option>
								</optgroup>
								<optgroup label="Pune">
									<option>ABC</option>
									<option>PQR</option>
									<option>XYZ</option>
								</optgroup>
						</select></td>
					</tr>

					<tr>
						<td><label>Select Screen</label></td>
						<td><select name="screenName">
								<option>Screen 1</option>
								<option>Screen 2</option>
								<option>Screen 3</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Show Type</label></td>
						<td><select name="showType">
								<option>Select</option>
								<option>Morning</option>
								<option>Afternoon</option>
								<option>Evening</option>
								<option>Night</option>
						</select></td>
					</tr>

					<tr>
						<td><label>Date</label></td>
						<td><input type="text" name="showDate"
							placeholder="YYYY-MM-DD"></td>
					</tr>

					<tr>
						<td><label>Start Time</label></td>
						<td><input type="text" name="showStartTime"
							placeholder="HH:MIN"></td>
					</tr>

					<tr>
						<td><label>End Time</label></td>
						<td><input type="text" name="showEndTime"
							placeholder="HH:MIN"></td>
					</tr>

					<tr>
						<td><label>Price</label></td>
						<td><input type="text" name="price" placeholder="00.00"></td>
					</tr>
					

					<tr>
						<td><input type="submit" name="btnsubmit" value="save"></td>
						<td><input type="reset" name="btnreset" value="clear"></td>
					</tr>
					<tr>
					<td colspan="2">
						<jsp:include page="msg.jsp"></jsp:include>
					</td>
				</tr>
				</table>
			</fieldset>
		</form>
</body>
</html>