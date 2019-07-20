<%-- 
    Document   : admin
    Created on : 19 Mar, 2019, 2:33:14 PM
    Author     : VeenaSK
--%><%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%! String driverName = "com.mysql.jdbc.Driver";%>
<%!String url = "jdbc:mysql://localhost:3306/defaultusernamepasswrdtable";%>
<%!String user = "root";%>
<%!String psw = "veena123";%>
<%
String pwd= request.getAttribute("data").toString(); 
String number = request.getAttribute("id").toString();

if(number != null)
{
Connection con = null;
PreparedStatement ps = null;
int serialno=Integer.parseInt(number);
try
{
Class.forName(driverName);
con = DriverManager.getConnection(url,user,psw);
String sql="Update updatedup1 set password=? where serialno="+serialno;
ps = con.prepareStatement(sql);
ps.setString(1, pwd);
int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>

<%@ page import="java.util.*,com.ihub.model.Updatedup1" %>

<% Updatedup1 up; %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                  <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Contact</a>
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
            <li class="nav-item">
                  <a class="nav-link" href="LogoutServlet">Logout</a>
                </li>    
            </ul>  
            
        </div>
    
        </nav>
<div class="card bg-dark text-white">
      <img src="Grey.jpg" class="card-img mx-auto" alt="grey">
           <div class="card-img-overlay">
        <h1>Details</h1> 
        <table border ="1" width="500" align="center" class="text-white"> 
         <tr > 
          <th><b>Serial No</b></th> 
          <th><b>Username</b></th> 
          <th><b>Password</b></th> 
          <th><b>Item</b></th>
          <th><b>Port No</b></th>
          <th><b>Brand</b></th>
          
         </tr> 
        <%-- Fetching the attributes of the request object 
             which was previously set by the servlet  
              "StudentServlet.java" 
        --%>  
        <%ArrayList<Updatedup1> std =(ArrayList<Updatedup1>)request.getAttribute("List"); 
        for(Updatedup1 s:std){%> 
        <%-- Arranging data in tabular form 
        --%> 
            <tr> 
                <td><%=s.getSerialNo()%></td>
                <td><%=s.getUserName()%></td>
                <td><%=s.getPassword()%></td>
                <td><%=s.getItem()%></td>  
                <td><%=s.getPortNo()%></td> 
                <td><%=s.getBrand()%></td>
              
            
            </tr> 
            <%}%> 
        </table>  
        <hr/> 
        
           </div>
</div>
        
    </body>
</html>
