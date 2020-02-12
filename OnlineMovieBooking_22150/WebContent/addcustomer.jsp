<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="css/mystyle.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<script src="Js/jquery.js">
		
	</script>
	<script>
		function resetError() {
			$("#efname").text("*")
			$("#elname").text("*")
			$("#eemailId").text("*")
			$("#epassword").text("*")
			$("#econfirmPassword").text("*")
			$("#econtactNo").text("*")
			$("#eaddress").text("*")
			alert()
		}
		$(function() {
			$("#btnRegister").click(function() {
					
				resetError();
				

				var fname = $("#fname").val()
				if (fname == "") {
					$("#efname").text("Please Enter First Name")
					return false
				}

				var lname = $("#lname").val()
				if (lname == "") {
					$("#elname").text("Please Enter Last Name")
					return false
				}

				var emailId = $("#emailId").val()
				if (emailId == "") {
					$("#eemailId").text("Please Enter EmailId")
					return false
				}

				var password = $("#password").val(RequestDispatcher rd=request.getRequestDispatcher("addcustomer.jsp");
				rd.forward(request, response))
				if (password == "") {
					$("epassword").text("Please Enter Password")
					return false
				}

				var confirmPassword = $("confirmPassword").val()
				if (confirmPassword == "") {
					$("#econfirmPassword").text("Confirm your Password")
					return false
				}

				var confirmPassword = $("confirmPassword").val()
				if (password != confirmPassword) {
					$("#econfirmPassword").text("Password does't match")
					return false
				}
				var contactNo = $("#contactNo").val()
				if (contactNo == "") {
					$("#contactNo").text("Please enter Contact no..")

					return false
				}

				if (isNaN(contactNo)) {
					$("econtactNo").text("Only digits allowed")
					return false;
				}
				if (contactNo.length >= 7 && contactNo < 10) {
					$("#econtactNo").text("please Enter the 10 digit")
					return false;
				}

				var address = $("address").val()
				if (address == "") {
					$("#eaddress").text("Please Enter Address")
				}
				return true
			});
		});
	</script>
	<form onsubmit="return validate()" action="CustomerServlet" method="post">
	<input type="hidden" name="action" value="addcustomer">
		<fieldset>
			<legend>Registration</legend>
			<table cellspacing="5" cellpadding="5">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="custFName" placeholder="ABC"
						id="fname"> <span class="error" id="efname">*</span></td>
					<br>
				</tr>

				<tr>
					<td>Last Name</td>
					<td><input type="text" name="custLName" placeholder="Abc"
						id="lname"> <span class="error" id="elname"> *</span><br>
				</tr>

				<tr>
					<td>Email Id</td>
					<td><input type="text" name="custEmailId"
						placeholder="example@gmail.com" id="emailId"><span
						class="error" id="eemailId">*</span></td>
				</tr>

				<tr>
					<td>Password</td>
					<td><input type="password" name="custPassword"
						placeholder="abc@123" id="password"><span class="error"
						id="epassword">*</span></td>
				</tr>

				<tr>
					<td>Confirm Password</td>
					<td><input type="Password" name="ConfirmPassword"
						placeholder="abc@123" id="confirmpassword"><span class="error"
						id="econfirmPassword">*</span></td>
				</tr>


				<tr>
					<td>Contact No</td>
					<td><input type="text" name="custContactNo"
						placeholder="1234567890" id="contactNo"><span
						class="error" id="econtactNo">*</span></td>
				</tr>

				<tr>
					<td>Address</td>
					<td><textarea name="custAddress"elname rows="3" cols="20"
							id="address"></textarea><span class="error" id="eaddress">*</span></td>
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
		</fieldset>
	</form>
</body>
</html>