<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Shows</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/formstyle.css" rel="stylesheet" type="text/css" />
<link href="css/tablestyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">

$(function() {
	$(".displayerBoxes").hide();
});
	function confirmSeats()
	{
		if($("input:checked").length>0) {
			var allselectedseats=[];
		$("#seatsBlock :checked").each(function(){
			allselectedseats.push($(this).val())
		});
		alert(allselectedseats)
		$(".displayerBoxes").show();
		$("#seatsDisplay").val(allselectedseats)
		$(".seatStructure").hide()
		noofSeats=$("input:checked").length;
		$("#totalprice").val(noofSeats * $("#totalprice").val());
	}
		else
			{
				alert("Please select Seats");
			}
	}
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
	List<String> bookedseats=(List<String>) request.getAttribute("bookedseatlist");
%>

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
			<core:set var="columns" value="12"/>
			<tr>
				<td></td>
			
			<core:forEach var="j" begin="1" end ="${columns}" step="1">
			<td>${j}</td>
			<fmt:parseNumber var="colmid" value="${columns/2}"/>
			<core:if test="${j==colmid}">
				<td class ="seatGap">&nbsp;</td>
				</core:if>
			</core:forEach>

			</tr>
				${bookedseatlist }
				<% char rows='L'; %>
				
				<% for(char ch='A';ch<=rows;ch++){ %>
				<core:set var="i" value="<%=ch%>"/>
				<tr>
				<td>${i}</td>
				<core:forEach var="j" begin="1" end="${columns}" step="1">
				<core:set value="${i}${j}" var="seat"/>
				<core:if test="${not fn:contains(bookedseatlist,seat)}">
					<td><input type="checkbox" class="seats" value="${i}${j}"> </td>
				</core:if>
				
				<core:if test="${fn:contains(bookedseatlist,seat)}">
					<td><div title="Soled" style="background-color: red; width: 15px; height: 15px"></div></td>
				</core:if>
				
				<fmt:parseNumber var="colmid" value="${columns/2 }"/>
				
				<core:if test ="${j==colmid }">
					<td class ="seatGap">&nbsp;&nbsp;</td>
					</core:if>
					</core:forEach>
					</tr>
					
					<core:set var="rowmid" value="E"/>
					<core:if test ="${fn:contains(rowmid,i)}">
					<tr>
						<td colspan="${columns}">
						&nbsp;
						<!-- space -->
					</td>
					</tr>
					</core:if>
					
					<%} %>
			<tr>
			<td align="center" colspan="14"><button  class="csbtn" onclick="confirmSeats()" style="margin: 5px;">Confirm Selection</button></td>
			</tr>
		</table>
	</div>


	<div class="displayerBoxes column " style="margin-top: 50px;" >
		<form action="Booking" method="post">
		<input type="hidden" name="action" value="BookTheShow"> 
		<table class="Displaytable" align="center">
		
			<tr>
				<th>Customer Name :</th>
				<td>${custobj.custFName} ${custobj.custLName}</td>
			</tr>
			<tr>
				<th>Show Id :</th>
				<td><input type="text" id="showId" name="showId"
					value="${show.showId}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Movie :</th>
				<td>${show.movie.movieName}</td>
			</tr>
			<tr>
				<th>Screen No:</th>
				<td>${show.screenName}</td>
			</tr>
			<tr>
				<th>Start Time:</th>
				<td>${show.showStartTime}</td>
			</tr>
			<tr>
				<th>End Time:</th>
				<td>${show.showEndTime}</td>
			</tr>
			<tr>
				<th>Seat:</th>
				<td><input type="text" id="seatsDisplay" name="bookedseats" readonly="readonly"></td>
			</tr>
			<tr>
				<th>Total:</th>
				<td><input type="text" id="totalprice" name="totalprice" value="${show.price}" readonly="readonly"/></td>
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
</body>
</html>