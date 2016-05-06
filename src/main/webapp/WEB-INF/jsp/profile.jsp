<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />

</head>
<body style="background-color: #BEDDE9">

<div class="container">
<div class=jumbotron>
<h1 align="center">GEFP</h1>
</div>
<form:form modelAttribute="user" method="post">
USERNAME: ${users.name}
<br/>
<br/>

CHANGE PASSWORD:

<input type="text" class="form-control" name="passw" value="${users.password}"/>

<p style="color:blue">password should greater than 4 digit and have 1 number otherwise it will not save</p>
<br/>
YOUR MAJOR IS: ${users.department.name}
<br/>
<br/>
CHANGE MAJOR:
<select name="dept" class="form-control">

<c:forEach items="${alldepts }" var="dept">
<option selected value="${dept.id}"> ${dept.name}</option>
 <c:choose>
                    <c:when test="${users.department.id == depart.id}">
                        <option selected value="${depart.id}"> ${depart.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${depart.id}">${depart.name}</option>
                    </c:otherwise>
                </c:choose>
</c:forEach>
</select>
<br/>
<button type="submit" class="btn btn-primary" name="add" value="OK" >Save</button>
</form:form>
</div>
</body>
</html>