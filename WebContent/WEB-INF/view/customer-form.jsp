<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">

			<h1>--Customer Resource Management--</h1>

		</div>

		<div id="container">

			<div id="content">
				<h3>Save Customer</h3>
				<hr>
				<form:form action="saveCustomer" modelAttribute="customer"

					method="POST">
					
					<!-- with out this hidden id field it doesnt know which to save/edit -->
					
				<form:hidden path="id"/>

					<table>

						<tbody>


							<tr>
								<td><label>FirstName: </label></td>
								<td><form:input path="firstName" /></td>
							</tr>

							<tr>
								<td><label>LastName: </label></td>
								<td><form:input path="lastName" /></td>
							</tr>
							<tr>
								<td><label>Email: </label></td>
								<td><form:input path="email" /></td>
							</tr>

							<tr>
								<td><label> </label></td>
								<td><input type="submit" value="Save" class="save" /></td>
							</tr>
							
							
							<tr>
							    <p> <a href="${pageContext.request.contextPath}/customer/list">Back To List</a>  </p>
							  
							</tr>

						</tbody>


					</table>
				</form:form>
               
               <div style="clear; both;"></div>
                      <p> <a href="${pageContext.request.contextPath}/customer/list">Back To List</a>  </p>
			</div>

		</div>
</body>
</html>