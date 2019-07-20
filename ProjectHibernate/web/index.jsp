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
    </head>
    <body>
        <%
//allow access only if session exists
            // WHY BOTH SESSION AND COOKIE AMNAGEMENT SINCE ..... 
String user = null;
if(session.getAttribute("user") == null){
	response.sendRedirect("home.jsp");
}else user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
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
           <img src="iot security 9.jpg" class="card-img mx-auto" alt="iot security">
           <div class="card-img-overlay">
<h3>Hi <%=userName %>, Login successful.</h3>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="col-lg-6 col-lg-3 btn-lg card bg-danger">
      <form action="Display">
           IoT User List
            <input type="submit" class="btn btn-primary"  value="Display" />
            
        </form>
        </div>
    
        <div class="col-lg-6 col-lg-3 btn-lg card bg-danger">
        <form action="PieChartServlet">
            <p/>Username Statistics
            <input type="submit" class="btn btn-primary" value="Study" />
            
        </form>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-6 col-lg-3 btn-lg card bg-danger "> 
       <form action="PieChartServlet2">
            <p/>Password Statistics
            <input type="submit" class="btn btn-primary"  value="Study" />
        </form>
        </div>
        <div class="col-lg-6 col-lg-3 btn-lg card bg-danger">
        <form action="Change">
            Change Password
            <input type="submit" class="btn btn-primary" value="Change" />
        </form>
        </div>
    </div>
    </div>
<div class="container">
    <div class="row">
        <div class="col text-center">
   <form action="LogoutServlet" method="post">
           <br/><br/> <input type="submit" class="btn btn-lg btn-primary" value="Logout" />
   </form>
        </div>
    </div>
</div>
        

           </div>
    </div>
    </body>
</html>
