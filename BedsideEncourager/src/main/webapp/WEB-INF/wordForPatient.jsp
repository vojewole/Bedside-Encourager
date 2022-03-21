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
	<div style="text-align:right; padding-right: 50px; ">
		<a href="/patients"><strong>Return to main page</strong></a>
	</div>
	<div style="text-align:center;">
		<h1 style="color:royalblue; text-shadow: 1px 1px black;"> <strong>Leave an Encouraging Word for <span><c:out value="${patient.name}"></c:out></span> </strong></h1>
	</div>
	<div style="text-align:center; color:darkgrey; text-shadow: 1px 1px black;">
		<h2><strong><c:out value="${patient.description}"></c:out></strong></h2>
	</div>
	<div class="container">
		<table  class="table table-dark table-striped">
		    <thead>
		        <tr class="text-center">
		        	<th>Word</th>
		            <th>Posted By</th>
		        </tr>
		    </thead>
		    <tbody style="text-align:center;">
		         <c:forEach var="posterRecipient" items="${patient.postersRecipients}">
					<tr>
						<td><c:out value="${posterRecipient.word}"/></td>
						<td><c:out value="${posterRecipient.poster.name}"/></td>
					</tr>
				</c:forEach>
		    </tbody>
		</table>
	</div>
	<div>
		<form:form action="/patients/word" method="post" modelAttribute="posterRecipient">
			<form:input type="hidden" path="recipient" value="${patient.id}"/>
		    <p>
		    	<div style="padding-left: 570px;">
		    		<form:textarea path="word"/>
		    	</div>
		        <form:errors path="word" class="text-danger"/>
		    </p>
		    <div style="padding-left:650px; padding-top:20px;">
		    	<input type="submit" value="Post Word" class="btn btn-dark row form-inline "/>
		    </div>
		</form:form>    
	</div>
</body>
</html>