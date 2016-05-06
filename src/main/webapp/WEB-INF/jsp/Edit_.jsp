<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit checkpoint</title>
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
<font face="verdana" size="15" align="center">EDIT A CHECKPOINT</font>
   
        <form:form action="editcheckpoint.html?id=${plan.id}" modelAttribute="checkpoint" method="post">
          <div class="container">
           <h3>Runway:</h3>
            <select class="form-control" name="rid">
            <option value="">-Select Runway-</option>
            <c:forEach items="${runways}" var="runway">
            
                <c:choose>
                    <c:when test="${checkpoint.runway.id == runway.id }">
                        <option selected value="${runway.id}"> ${runway.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${runway.id}">${runway.name}</option>
                    </c:otherwise>
                </c:choose>
                
                
            
            </c:forEach>
             </select>
           <br/>
           <h3>Stage:</h3>
                <select class="form-control" name="sid">
                <option value="">-Select Stage-</option>
                <c:forEach items="${stages}" var="stage">
                
                
                
                <c:choose>
                    <c:when test="${checkpoint.stage.id == stage.id }">
                        <option selected value="${stage.id}">${stage.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${stage.id}">${stage.name}</option>
                    </c:otherwise>
                </c:choose>
                
                </c:forEach>
                </select>
      
          <br/>
          <h3>Check Point:</h3>
          <form:input type="text" class="form-control" path="name"/><br/>
          
            <input type="hidden" name="cid" value="${checkpoint.id}" />
            <input type="hidden" name="pid" value="${pid}" />
            <button class="btn btn-primary" type="submit" name="add" value="OK" >Add a Checkpoint</button>
          </div>
          </form:form>
         </div>
</body>
</html>