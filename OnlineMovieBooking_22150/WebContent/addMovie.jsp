<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="movie" method="post" enctype="multipart/form-data">
<input type="hidden" name="action" value="addMovie">
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
	<legend> Add Movie</legend>                         
	<table cellpadding="5" cellspacing="5">
	<tr>
		<td> Movie Name</td>
		<td><input type="text" name="movieName" placeholder="KGF: Chapter 1" id="mname"> <span style="color:Red" id="ename"></span> </td>
	</tr>
	
	<tr>
		<td> Movie Image</td>
		<td><input type="file" name="movieImage"></td>
	</tr>
	
	<tr>
			<td><label>Movie Type</label></td>
			<td>
				<select name="MovieType">
					<option>Action</option>
					<option>Romantic</option>
					<option>Horror</option>
					<option>Animation</option>
					<option>Comedy</option>
				</select>
			</td>
	</tr>
	
	<tr>
		<td> Movie Language</td>
		<td><input type="text" name="movieLanguage" placeholder="" id="mname"> <span style="color:Red" id="elanguage"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Cast</td>
		<td><input type="text" name="movieCast" placeholder="" id="mname"> <span style="color:Red" id="ecast"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Producer</td>
		<td><input type="text" name="movieProducer" placeholder="" id="mname"> <span style="color:Red" id="eproducer"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Director</td>
		<td><input type="text" name="movieDirector" placeholder="" id="mname"> <span style="color:Red" id="edirector"></span> </td>
	</tr>
	
	<tr>
		<td> Movie Duration</td>
		<td><input type="text" name="movieDuration" placeholder="" id="mname"> <span style="color:Red" id="eproducer"></span> </td>
	</tr>
	
	<tr>
		<td> Release Date</td>
		<td><input type="text" name="releaseDate" placeholder="YYYY-MM-DD" id="mname"> <span style="color:Red" id="ereleasedate"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Description</td>
		<td><input type="text" name="movieDescription" placeholder="" id="mname"> <span style="color:Red" id="edescreption"></span> </td>
	</tr>
	
	<tr>
		<td>Movie Review</td>
		<td><input type="text" name="movieReview" placeholder="" id="mname"> <span style="color:Red" id="ereview"></span> </td>
	</tr>
	
	<tr>
		<td><input type="submit" name="btnType" id="btnRegister"
						value="Register"></td>
					<td><input type="reset" name="btnReset" value="Reset"></td>
	</tr>
	<tr>
					<td colspan="2">
						<jsp:include page="msg.jsp"></jsp:include>
					</td>
				</tr>
	</table>
</form>	
</fieldset>
</body>
</html>