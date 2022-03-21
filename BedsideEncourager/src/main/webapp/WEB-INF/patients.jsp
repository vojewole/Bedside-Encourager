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
	<div style="display:flex; justify-content:space-between; padding-left:120px; padding-right:110px;">
		<h1><strong>Welcome, <c:out value="${user.name}"/></strong></h1>
		<a href="/logout"><strong>logout</strong></a>
	</div>
	<div style="display:flex; color:royalblue; justify-content:space-between; padding-left:120px; padding-right:110px;">
		<h3 style="text-shadow: 1px 1px black;"><strong>Patients needing some love:</strong></h3>
		<a href="/patients/new"><strong>Add new patient here</strong></a>
	</div>
	
	<div class="container">
		<table class="table table-dark table-striped">
		    <thead>
		        <tr class="text-center">
		        	<th>ID</th>
		            <th>Name</th>
		            <th>Age</th>
		            <th>Room Number</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody style="text-align:center;">
		         <c:forEach var="patient" items="${patients}">
					<tr>
						<td><c:out value="${patient.id}"/></td>
						<td><a href="/patients/<c:out value="${patient.id}"/>"><c:out value="${patient.name}"/></a></td>
						<td><c:out value="${patient.age}"/></td>
						<td><c:out value="${patient.roomNumber}"/></td>
						<c:choose>
							<c:when test="${user.id == patient.user.id }">
								<td>
									<div style="display:flex; justify-content:space-evenly">
										<a href="/patients/<c:out value="${patient.id}"/>/edit" class="btn btn-success" tabindex="-1" role="button" aria-disabled="true">edit</a>
										<form action="/patients/delete/<c:out value="${patient.id}"/>" method="post">
				    						<input type="hidden" name="_method" value="delete">
				    						<input type="submit" value="Delete" class="btn btn-danger">
										</form>
									</div>
								</td>
							</c:when>
							<c:otherwise>
									<td>
									
									</td>	
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
		    </tbody>
		</table>
	</div>
</body>
</html>