<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="formcls">

		<form action="LoginServlet" method="post">
			<fieldset>
				<legend>Login Here</legend>
				<table>
				<input type="hidden" name="action" value="Login">
				<tr>
					<td>User Type</td>
					<td>Admin<input type="radio" name="userType" value="Admin">
					<td>Customer<input type="radio" name="userType" value="Customer"></td>
				</tr>
				
				<tr>
					<td>Email ID</td>
					<td><input type="text" name="emailId"placeholder="abc@gmail.com"> </td></br>
				
				</tr>
				<tr>
					<td>Enter Password</td>
					<td><input type="password" name="password"
					placeholder="Abc@123"></td>
				</tr>
				<tr>
					<td colspan="2">
					<a href="Forget Password"> </a></td>
					<td><a href="Register New Account"></a></td>
				</tr>
				<tr>
					<td><input type="submit" name="btnsubmit" value="Login"></td>
					<td><input type=reset name="btnreset" value="Reset"></td>
				</tr>	
				
					<td colspan="2">
						<jsp:include page="msg.jsp"></jsp:include>
					</td>					
					
					
				</table>
			</fieldset>
		</form>
</body>
</html>