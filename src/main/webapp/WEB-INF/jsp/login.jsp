<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="signin.css" rel="stylesheet">
<title>Login page</title>
<link rel="stylesheet"
    href="http://getbootstrap.com/dist/css/bootstrap.min.css" />


</head>
<body style="background-color:lightgrey">




<div align="center" class="container">

<div id="header">
<font face="verdana" size="20" align="center">WELCOME TO GEFP</font>
</div>

<form:form modelAttribute="User" class="form-inline">

        <br/><br/><br/><br/>
         <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="inputEmail" class="sr-only">Email address</label>
      <form:input type="text" class="form-control" path="name" placeholder="Username" /><br/>

    <label for="inputPassword" class="sr-only">Password</label>
     <form:input type="password" class="form-control" path="password" placeholder="Password"/> <br />
 <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
    <br/>
    
        <button class="btn btn-primary btn-md"type="submit" value="Login" name="login"  >Sign in</button>
        
        <br/>        

</form:form>
</div>    

</body>
</html>