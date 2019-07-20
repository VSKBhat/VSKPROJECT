<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About</title>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>  
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <a class="navbar-brand" href="#">
                <img src="IoT-bulb-1.jpg" alt="Logo" style="width:100px">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mydiv">
              <span class="navbar-toggler-icon"></span>
            </button>
        <div id="#mydiv" class="collapse navbar-collapse">
            <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact.jsp">Contact</a>
                </li>
                 <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Login
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="admin.jsp">Admin</a>
        <a class="dropdown-item" href="intelligence.jsp">Intelligence Team</a>
     <a class="dropdown-item" href="userLogin.jsp">User</a>
      </div>
    </li>
                 <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop1" data-toggle="dropdown">
        Demo
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="cheatcodesqlinjection.jsp">SQL injection</a>
        <a class="dropdown-item" href="preventSqlinjection.jsp">SQL injection prevention</a>
     
      </div>
    </li>
                
            </ul>   
        </div>
        </nav>
        <div class="card bg-dark text-white">
            <img src="Grey.jpg" class="card-img mx-auto" alt="iot security">
  <div class="card-img-overlay">
    <h1 class="card-title">As the world becomes more connected, we make it more secure.</h1>
    <img src="IoTSecurityCampaign.jpg" alt="Digital" width="600" height="200">
    <div class="container text-justify">
        <h5>We solve the problem of ineffective authentication, lack of transport encryption and insecure web interface in IoT devices.
        As IoT grows, the attack surface also grows and all the loopholes/vulnerabilities present in the digital world will flow into our real world.
         Before IoT, attackers used vulnerabilities for data theft or to make money or sometimes just for fun, but with IoT, the attack surface has grown to such extent that attacker can use vulnerabilities or loopholes in the car, smart sniper rifle etc., to kill a person remotely with a few strokes of the keyboard. Attackers are constantly finding the vulnerabilities to break into IoT and use those vulnerabilities for many illegal purposes. The exponential rise in the use of IoT devices, more processing of sensitive data by these devices, and their mass exploitation is the motivation for the development of this evaluation system.</h5>
  </div>
    </div>
        </div>
    </body>
</html>
