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
<div style="text-align:center;">
<h1 style="color:royalblue; text-shadow: 2px 2px black;"><strong>Bedside Encourager</strong></h1>
<h2><strong>Where patients can encourage each other or be encouraged by others</strong></h2>
</div>
<div style="display:flex; justify-content:space-evenly;">
	<div style="text-align:left;">
		<h1 style="color:royalblue; text-shadow: 2px 2px black;"><strong>Register</strong></h1>
		<form:form action="/register" method="post" modelAttribute="newUser">
		    <p>
		        <form:label path="name">Name:</form:label>
		        <form:input path="name" style="margin-left: 94px;"/>
		        <form:errors path="name" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="email">Email:</form:label>
		        <form:input path="email" style="margin-left: 98px;"/>
		        <form:errors path="email" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="password">Password:</form:label>
		        <form:input type="password" path="password" style="margin-left: 70px;"/>
		        <form:errors path="password" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="confirm">Confirm Password:</form:label>
		        <form:input type="password" path="confirm" style="margin-left: 8px;"/>
		        <form:errors path="confirm" class="text-danger"/>
		    </p>
		    <div class="text-center">
		    	<input type="submit" value="Register" class="btn btn-dark row form-inline "/>
		    </div>
		</form:form>    
	</div>
	<div style="text-align:left;">
		<h1 style="color:royalblue; text-shadow: 2px 2px black;"><strong>Log in</strong></h1>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<p style="color:red;"><c:out value="${message}"></c:out></p>
		    <p>
		        <form:label path="email">E-mail:</form:label>
		        <form:input path="email" style="margin-left: 32px;"/>
		        <form:errors path="email" class="text-danger"/>
		    </p>
		    <p>
		        <form:label path="password">Password:</form:label>
		        <form:input type="password" path="password" style="margin-left: 10px;"/>
		        <form:errors path="password" class="text-danger"/>
		    </p>
		    <div class="text-center">
		    	<input type="submit" value="Login" class="btn btn-dark row form-inline "/>
		    </div>
		    
		</form:form>    
	</div>
</div>
</body>
</html>