<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Enjoy Your Show</title>
</head>
<body><%-- 
		${bookingDetails} --%>
		<link href="css/ticketcss.css" rel="stylesheet" type="text/css" />

	<div class="cardWrap">
		<div class="card cardLeft">
			<h1>
				Cinema <span>World</span>
			</h1>
			<div class="title">
				<h2>Movie Name</h2>
				<span>${bookingDetails.show.movie.movieName}</span>
			</div>
			<div class="name">
				<h2>Customer Full Name</h2>
				<span>${custobj.custFName} ${custobj.custLName}</span>
			</div>
			<div class="screen">
				<h2>Screen Name</h2>
				<span>${show.screenName}</span>
			</div>
			<div class="theater">
				<h2> Theatre Name, Theatre Location</h2>
				<span> ${show.theatreName}</span>
			</div>
			<div class="date">
				<h2>Show Date</h2>
				<span>${show.showDate}</span>				
				
			</div>
			<div class="time">
				<h2>Start Time</h2>
				<span>${show.showStartTime}</span>
			</div>
			

		</div>
		<div class="card cardRight">
			<div class="eye"></div>
			<div class="number">
				<h3 id="seat">Booking Seats</h3>
				<span>${bookingDetails.bookingSeats }</span>
			</div>
			<div class="barcode"></div>
		</div>

	</div>
</body>
</html>