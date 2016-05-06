<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add checkpoint</title>
<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />

</head>
<body style="background-color: #BEDDE9">
<div align="center" class="container">
<div class=jumbotron>
<h1 align="center">GEFP</h1>
</div>
<p align="right">Welcome user  <a  class="btn btn-danger" href="login.html">Logout</a></p><br/><br/><br/>
<div id="header">
<p align="left"><a class="btn btn-primary" class="navbar-brand" href="Departments.html">HOME
        </a></p> 
<font face="verdana" size="15" align="center">ADD A CHECKPOINT</font>
   
        <form:form modelAttribute="checkpoint" method="post">
           Runway:
            <select class="form-control" name="rid">
            <option value="">-Select Runway-</option>
            <c:forEach items="${runways}" var="runway">
            <option value="${runway.id}">${runway.name}</option>
            </c:forEach>
             </select>
           <br/>
           Stage:
                <select class="form-control" name="sid">
                <option value="">-Select Stage-</option>
                <c:forEach items="${stages}" var="stage">
                <option value="${stage.id}">${stage.name}</option>
                </c:forEach>
                </select>
      
          <br/>
          Check Point:
          <input type="text" class="form-control" name="checkpoint_name" /><br/>
          
            <input type="hidden" name="pid" value="${pid}" />
            <button class="btn btn-primary"type="submit" name="add" value="OK" >Add a Checkpoint</button>
          </form:form>
          </div>
          </div>
   
</body>
</html>