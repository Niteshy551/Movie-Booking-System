<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="msg.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show List</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
</head>



<link rel="stylesheet" type="text/css" href="css/seatingcss.css" />
<div class="container"  >
	<div class="seatStructure column" style="margin: 0px auto" >
		<table id="seatsBlock" align="center">
			<tr>
				<td colspan="14"><div class="screen">SCREEN</div></td>
				<td rowspan="20">
					<div class="smallBox greenBox">Selected Seat</div> <br />
					<div class="smallBox redBox">Reserved Seat</div> <br />
					<div class="smallBox emptyBox">Empty Seat</div> <br />
				</td>
				<br/>
			</tr>

			<tr>
				<td></td>
				
				
				
				<td>1</td>
				
				
				<td>2</td>
				
				
				<td>3</td>
				
				
				<td>4</td>
				
				
				<td>5</td>
				
				
				<td>6</td>
				
				
				<td></td>
				
				<td>7</td>
				
				
				<td>8</td>
				
				
				<td>9</td>
				
				
				<td>10</td>
				
				
				<td>11</td>
				
				
				<td>12</td>
				
			</tr>
			
			<tr>
				<td>A</td>
				
				
				<td><input type="checkbox" class="seats" value="A1"></td>

				
				
				<td><input type="checkbox" class="seats" value="A2"></td>

				
				
				<td><input type="checkbox" class="seats" value="A3"></td>

				
				
				<td><input type="checkbox" class="seats" value="A4"></td>

				
				
				<td><input type="checkbox" class="seats" value="A5"></td>

				
				
				<td><input type="checkbox" class="seats" value="A6"></td>

				
				
				<td class="seatGap"></td>
				
				<td><input type="checkbox" class="seats" value="A7"></td>

				
				
				<td><input type="checkbox" class="seats" value="A8"></td>

				
				
				<td><input type="checkbox" class="seats" value="A9"></td>

				
				
				<td><input type="checkbox" class="seats" value="A10"></td>

				
				
				<td><input type="checkbox" class="seats" value="A11"></td>

				
				
				<td><div title="soled" class="soled">&nbsp;</div></td>

				
				
			</tr>
			
			<tr>
				<td>B</td>
				
				
				<td><input type="checkbox" class="seats" value="B1"></td>

				
				
				<td><input type="checkbox" class="seats" value="B2"></td>

				
				
				<td><input type="checkbox" class="seats" value="B3"></td>

				
				
				<td><input type="checkbox" class="seats" value="B4"></td>

				
				
				<td><input type="checkbox" class="seats" value="B5"></td>

				
				
				<td><input type="checkbox" class="seats" value="B6"></td>

				
				
				<td class="seatGap"></td>
				
				<td><input type="checkbox" class="seats" value="B7"></td>

				
				
				<td><input type="checkbox" class="seats" value="B8"></td>

				
				
				<td><input type="checkbox" class="seats" value="B9"></td>
/td>
				
				
				<td><input type="checkbox" class="seats" value="B10"></td>

				
				
				<td><input type="checkbox" class="seats" value="B11"></td>

				
				
				<td><input type="checkbox" class="seats" value="B12"></td>

				
				
			</tr>
			<tr>
			<td align="center" colspan="14"><button  class="csbtn" onclick="updateTextArea()" style="margin: 5px;">Confirm Selection</button></td>
			</tr>
		</table>
	</div>


	<div class="displayerBoxes column " style="margin-top: 50px;" >
		<form action="Booking" method="post">
		<input type="hidden" name="action" value="payment"> 
		<table class="Displaytable" align="center">
		
			<tr>
				<th>Customer Name :</th>
				<td>First Name Last Name</td>
			</tr>
			<tr>
				<th>Show Id :</th>
				<td><input type="text" id="showId" name="showId"
					value="showId" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Movie :</th>
				<td>MovieName</td>
			</tr>
			<tr>
				<th>Screen No:</th>
				<td>ScreenName</td>
			</tr>
			<tr>
				<th>Start Time:</th>
				<td>StartTime</td>
			</tr>
			<tr>
				<th>End Time:</th>
				<td>EndTime</td>
			</tr>
			<tr>
				<th>Seat:</th>
				<td><input type="text" id="seatsDisplay" name="bookedseats" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Total:</th>
				<td><input type="text" id="totalprice" name="totalprice" value="ShowPrice" readonly="readonly"/></td>
			</tr>
			<tr>
				<th colspan="2"><input type="submit" value="Buy" class="buybtn"></th>
			</tr>
		</table>
		</form>
		<div id="legend"></div>
		<div style="clear: both"></div>
	</div>
	</div>
</html>
	