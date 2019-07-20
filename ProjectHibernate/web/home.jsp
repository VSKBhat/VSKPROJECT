<%-- 
    Document   : admin
    Created on : 19 Mar, 2019, 2:33:14 PM
    Author     : VeenaSK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
         <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
       <style>
body, html {
  height: 100%;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-image {
  /* The image used */
  background-image: url("iot-security-attacks.jpg");
  
  /* Add the blur effect */
  filter: blur(8px);
  -webkit-filter: blur(8px);
  
  /* Full height */
  height: 100%; 
  
  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
}

/* Position text in the middle of the page/image */
.bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  border: 3px solid #f1f1f1;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 80%;
  padding: 20px;
  text-align: center;
}
#navbar a:hover {
  background-color: #ddd;
  color: black;
}
.sticky {
  position: fixed;
  top: 0;
  width: 100%;
}

.sticky + .content {
  padding-top: 60px;
  
}

</style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top ">
             <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="IoT-bulb-1.jpg" alt="Logo" style="width:100px">
                </a>
            
                 
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
        </div>
        </nav>
        
         <div class="bg-image"></div>

<div class="bg-text">
  <h1>Evaluation System For IoT</h1>
  <p/><h2>-a security for your device</h2>
</div>
      <!-- Footer -->
<footer class="footer text-center  blue pt-4 bg-dark text-white" >

    <!-- Footer Links -->
    <div class="container-fluid  text-center text-md-left">

      <!-- Grid row -->
      <div class="row">

       
        <!-- Grid column -->

        <hr class="clearfix w-100 d-md-none pb-3">

        <!-- Grid column -->
        <div class="col-md-3 mb-md-0 mb-3">

            <!-- Links -->
            <h5 class="text-uppercase">Links</h5>

            <ul class="list-unstyled">
              <li>
                  <a href="home.jsp">Home</a>
              </li>
              <li>
                  <a href="about.jsp">About</a>
              </li>
              <li>
                <a href="contact.jsp">Contact</a>
              </li>
              
            </ul>

          </div>
          <!-- Grid column -->

          

    </div>
      
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">© 2019 Copyright:
      <a href="#">Veena SK</a>
    </div>
    <!-- Copyright -->

  </footer>
  <!-- Footer -->
    </body>
</html>
