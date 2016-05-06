<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a plan</title>

<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />
</head>
<body style="background-color: #BEDDE9">
<div align="center" class="container">
<div class=jumbotron>
<h1 align="center">GEFP</h1></div><p align="right">Welcome user  <a  class="btn btn-danger" href="login.html">Logout</a></p><br/><br/><br/>
<div id="header">
<p align="left"><a class="btn btn-primary" class="navbar-brand" href="Departments.html">HOME
        </a></p> 


<font face="verdana" size="15" align="center">ADD A PLAN</font>
</div>


<form method="post" action=""> <br/>

<div class="container">
<input type="text" class="form-control" name="plan_name"/><br/>
<input type="hidden" name="d_id" value="${d_id}" />
<button class="btn btn-primary"  type="submit" name="add" value="OK" >Add a plan</button>
</div>
</form>
</div>
</body>
</html>