<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>display plan</title>

<link rel="stylesheet"
	href="http://getbootstrap.com/dist/css/bootstrap.min.css" />

</head>
<body style="background-color: #BEDDE9">
  <script src="js/jquery.js" type="text/javascript"></script>
  <script type="text/javascript">
  
  $(document).ready(function() {
	    $('input[type="checkbox"]').click(function() {
	        var val = this.type == "checkbox" ? +this.checked : this.value ;            
	    });
	});
	  
  
  
  
  </script>
  <form method="post">
 <div class="container">
 <div class=jumbotron>
    <h1 align="center"> GEFP</h1><br/>
    </div>
     <a class="btn btn-primary" class="navbar-brand" href="Departments.html">HOME
        </a>
          
        <div class="row">
        <p align="right">WELCOME<a  class="btn btn-danger" href="login.html">Logout</a>   <a href="profile.html?id=${users.id}">change profile</a></a></p>
        <br/><br/><br/>
       
            <h4 align="center">PLAN</h4>
        </div>
        </div>
        
 <div class="container">        
		<div class="row">
			<table class="table table-striped table-bordered">
				<tr>
					<td></td>
					<c:forEach items="${runways}" var="runway">
						<th>${runway.name}</th>
					</c:forEach>
				</tr>

				<c:forEach items="${stages}" var="stage" varStatus="st">

					<tr>
						<td><b> ${stage.name}</b></td>
						<c:forEach items="${runways }" var="runway" varStatus="rw">
							<td><c:forEach items="${checkpoints}" var="chk"
									varStatus="ch">
									<c:if
										test="${chk.stage.id == stage.id && chk.runway.id == runway.id}">
										<li><input type="checkbox" name="check" value="${chk.id}" />${chk.name} 
										<a href="editcheckpoint.html?chkid=${chk.id}&id=${plan.id}">[Edit]</a>
										</li>
									</c:if>
								</c:forEach></td>
						</c:forEach>


					</tr>
				</c:forEach>
			</table>
		</div>
		</div>
 <div class="container">
        <div class="row">
            <a class="btn btn-primary" href="addrunway.html?id=${plan.id}">Add a Runway</a>
             <a class="btn btn-primary" href="addstage.html?id=${plan.id}">Add a Stage</a> 
             <a class="btn btn-primary" href="addcheckpoint.html?id=${plan.id}">Add Checkpoint</a>
         
         <input type="submit" value="Submit"> 
        </div>
</div>

</form>

</body>
</html>