<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Department list</title>
<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />

</head>
<body style="background-color: #BEDDE9">
        
<div align="center" class="container"> 
 <div class="row">  
 <div class=jumbotron>
<h1 align="center">Welcome to GEFP</h1></div>
<p align="right">Welcome user  <a  class="btn btn-danger" href="login.html">Logout</a></p><br/><br/><br/>
<p align="left" ><a class="btn btn-primary" class="navbar-brand" href="Departments.html">HOME
        </a></p>
        </div>
<h2>LIST OF DEPARTMENTS</h2>
<div class="row">
<table class="table table-striped table-bordered">

<c:forEach items="${alldepts}" var="dept">

<tr>
<td>${dept.name}<td>

<div class="row">
<a class="btn btn-primary" href="Plan.html?id=${dept.id}">select</a>
</div>



</tr>
</c:forEach>
</table>


</div>
</div>
</body>
</html>