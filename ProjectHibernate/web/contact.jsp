<%-- 
    Document   : admin
    Created on : 19 Mar, 2019, 2:33:14 PM
    Author     : VeenaSK
--%><%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
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
    <h1 class="card-title">Contact Us</h1>
    
    <div class="container">
        <h4>Have a question about the product?
           <br/>
           <br/>Contact us on vskbhat9@gmail.com</h4>
    </div>
    </div>
        </div>
        
    </body>
</html>
