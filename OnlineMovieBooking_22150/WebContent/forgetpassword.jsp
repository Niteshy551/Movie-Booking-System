<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget  Password</title>
</head>
<body>

</head>
<body>
	<h1> Forget Password </h1>

	<div style="border:2px red solid;" class="changePassword" id="ab">
		<form action="LoginServlet" method="post">
			<table cellspacing="10" cellpadding="10">
			
				<tr><td colspan="2"><input type="hidden" name="action" value="changepassword"></td></tr>
			
				<tr>
				<td><label>Email Id</label></td>
				<td>
					<input id="emailid" type="text" name="emailId" placeholder="example@abc.com">
				</td>				
				</tr>
				
				<tr>
					<td><label>Mobile No</label></td>
					<td>
						<input id="mobileNo" type="text" name="mobileBo" placeholder="8650356720" >
					</td>				
				</tr>	
				
				<tr>
					<td><label>Password</label></td>
					<td>
						<input id="newpassword" type="password" name="newPassword" placeholder="abc@123">
					</td>				
				</tr>	
				
				<tr>
					<td><label>Confirm Password</label></td>
					<td>
						<input id="cnfpassword" type="password" name="cnfPassword" placeholder="abc@123">
					</td>				
				</tr>	
								
				<tr> 
				<td align="right">
					<input type="submit" name="btnsubmit" value="Change Password" >
		    	</td>
	
		    	<td align="left">
		    		<input type="reset" name="btnreset" value="Reset">
		    	</td>
			</tr>
			</table>
		</form>
	</div>
</body>
</html>