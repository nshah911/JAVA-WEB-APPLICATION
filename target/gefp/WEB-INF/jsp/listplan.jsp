<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of plan</title>
<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />

</head>
 
<body style="background-color: #BEDDE9">
<div align="center" class="container">  
<div class=jumbotron>
<h1 align="center">GEFP</h1></div><p align="right">Welcome user  <a  class="btn btn-danger" href="login.html">Logout</a></p><br/><br/><br/>
<p align="left"><a class="btn btn-primary" class="navbar-brand" href="Departments.html">HOME
        </a></p> 
<br/>
<br/>
<br/>
 <div class="row">
        <br/><br/><br/>
        
            <h5>PLAN LIST</h5>
        </div>


<table class="table table-striped table-bordered">
<tr><th>Plans</th><th>operation</th></tr>
<c:forEach items="${allplan}" var="pln">

<tr>
<td>${pln.name}</td>
<td><a href="Layout.html?id=${pln.id}">View</a></td>
</tr>
</c:forEach>
</table>
<a href="addplan.html">ADD PLAN</a>



</div>
</body>
</html>