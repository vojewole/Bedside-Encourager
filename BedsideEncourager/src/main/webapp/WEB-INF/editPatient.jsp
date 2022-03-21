<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
    <title></title>
    <!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>    
</head>
<body>
	<div style="text-align:center; display:flex; justify-content:space-between; padding-left:300px; padding-right:300px;">
		<h1 style="color:royalblue; text-shadow: 2px 2px black;"> <strong>Edit <span>${patient.name}</span> Details</strong></h1>
		<a href="/patients"><strong>Return to main page</strong></a>
	</div>
	<div style="text-align:left; margin-left:300px;">
		<form:form action="/patients/${patient.id}" method="post" modelAttribute="patient">
		<input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="name"> <strong>Name:</strong> </form:label>
			        <div>
			        	<form:input path="name"/>
			        </div>
		        <form:errors path="name" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="age"><strong>Age:</strong> </form:label>
			        <div>
			        	<form:input path="age"/>
			        </div>
		        <form:errors path="age" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="roomNumber"><strong>Room Number:</strong> </form:label>
			        <div>
			        	<form:input path="roomNumber"/>
			        </div>
		        <form:errors path="roomNumber" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="description"><strong>About the patient:</strong> </form:label>
			        <div>
			        	<form:textarea path="description"/>
			        </div>
		        <form:errors path="description" class="text-danger"/>
		    </p>
		    <div style="padding-left:350px; padding-top:20px;">
		    	<input type="submit" value="Submit Changes" class="btn btn-dark row form-inline "/>
		    </div>
		</form:form>    
	</div>
</body>
</html>