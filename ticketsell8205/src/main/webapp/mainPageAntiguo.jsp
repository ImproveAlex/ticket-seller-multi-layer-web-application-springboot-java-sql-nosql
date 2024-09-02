<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.Usuarios"%>
<!DOCTYPE html>
<html>

<head>
<title>Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/styles/login.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", Arial, Helvetica, sans-serif
}

.myLink {
	display: none
}
</style>
</head>

<body class="w3-light-grey">

	<%
	String userN = new String();
	boolean isLoggedIn = false;
	isLoggedIn = (boolean) (request.getAttribute("isLoggedIn"));
	if (isLoggedIn == false) {
		userN = "Guest";
	} else {
		Usuarios usl = (Usuarios) request.getAttribute("loginUser");
		Usuarios userLogged = new Usuarios();
		userLogged = usl;
		userN = userLogged.getUsuario();
	}
	%>
	<!-- Navigation Bar -->
	<div class="w3-bar w3-white w3-border-bottom w3-xlarge">
		<a href="#" class="w3-bar-item w3-button w3-text-red w3-hover-red"><b>TicketSeller</b></a>
		<a href="#"
			class="w3-bar-item w3-button w3-right w3-hover-red w3-text-grey">Log
			Out</a> <a class="w3-bar-item w3-button w3-right w3-text-grey"> <%=userN%>
		</a>
	</div>
	<!-- Header -->
	<header class="w3-display-container w3-content w3-hide-small"
		style="max-width: 1500px">
		<img class="w3-image" src="" alt="London" width="1500" height="700">
		<div class="w3-display-middle" style="width: 65%">
			<div class="w3-bar w3-black">
				<button class="w3-bar-item w3-button tablink"
					onclick="openLink(event, 'Flight');">
					<i class="fa w3-margin-right"></i>Tickets
				</button>
			</div>

			<!-- Tabs -->
			<div id="EventS" class="w3-container w3-white w3-padding-16 myLink">
				<h3>Events</h3>
				<div class="w3-row-padding" style="margin: 0 -16px;"></div>
				<a href="AdvancedSearch.html" class="w3-button w3-dark-grey"><b>Advanced
						Event Search</b></a>
			</div>

			<div id="Ticket" class="w3-container w3-white w3-padding-16 myLink">
				<h3>Tickets</h3>
				<div class="w3-row-padding" style="margin: 0 -16px;"></div>
			</div>
	
		</div>
	</header>

	<!-- Page content -->
	<a href="PublishTicket.html" class="extraBtn"><b>Publish Tickets</b></a>
	<a href="AdvancedSearch.html" class="extraBtn"><b>Advanced Event Search</b></a>
											


		<!-- Contact -->
		<div class="w3-container">
			<h2>Contact</h2>
			<p>Let us post your tickets!</p>
			<i class="fa fa-map-marker" style="width: 30px"></i>Spain, MADRID <br>
			<i class="fa fa-phone" style="width: 30px"></i> Phone: 789548216<br>
			<i class="fa fa-envelope" style="width: 30px"> </i> Email:
			mail@mail.com<br>
		</div>

		<!-- End page content -->
	</div>

	<!-- Footer -->
	<footer class="w3-container w3-center w3-opacity w3-margin-bottom">
		<h5></h5>
	</footer>

</body>

</html>
