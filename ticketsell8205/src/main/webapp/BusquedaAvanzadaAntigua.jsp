<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "entities.Usuarios"%> 
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.myLink {display: none}
</style>
</head>
<body>


<% 
    String userN = new String();
    if((int)request.getAttribute("IsLoggedIn") == 0){
    	
      userN = "Guest";
    }
    else
    {
    Usuarios infoSession = (Usuarios) session.getAttribute("IsLoggedIn");
      Usuarios userLogged = new Usuarios();
      
      userLogged = infoSession;
      userN = userLogged.getUsuario();
    }
%>

<!-- Navigation Bar -->
<div class="w3-bar w3-white w3-border-bottom w3-xlarge">
  <a href="#" class="w3-bar-item w3-button w3-text-red w3-hover-red"><b>TicketSeller</b></a>
  <a href="#" class="w3-bar-item w3-button w3-right w3-hover-red w3-text-grey">Log Out</a>
  <a class="w3-bar-item w3-button w3-right w3-text-grey"><%= userN %></a></form> 
</div>

<!-- Header -->
<header class="w3-display-container w3-content w3-hide-small" style="max-width:1500px">
  <img class="w3-image" src="" alt="London" width="1500" height="700">
  <div class="w3-display-middle" style="width:65%">
    <div class="w3-bar w3-black">
      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'Flight');"><i class="fa fa-plane w3-margin-right"></i>Tickets</button>
    </div>

    <!-- Tabs -->
    <div id="Flight" class="w3-container w3-white w3-padding-16 myLink">
      <h3>Tickets</h3>
      <div class="w3-row-padding" style="margin:0 -16px;">
        <div class="w3-half">
          <label>From</label>
          <input class="w3-input w3-border" type="text" placeholder="Initial Date">
        </div>
        <div class="w3-half">
          <label>To</label>
          <input class="w3-input w3-border" type="text" placeholder="End date">
        </div>
      </div>
      <p><button class="w3-button w3-dark-grey">Search and find tickets</button></p>
    </div>

  </div>
</header>

<div class="back_re">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="title">
                     <h2> Búsqueda Avanzada de Eventos</h2>
                  </div>
               </div>
            </div>
         </div>
      </div>


<!-- Footer -->
<footer class="w3-container w3-center w3-opacity w3-margin-bottom">
  <h5></h5>
</footer>




</body>
</html>