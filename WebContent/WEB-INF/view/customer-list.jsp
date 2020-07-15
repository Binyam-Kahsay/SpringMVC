<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer list page</title>

 <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css">
 


</head>


<body>
	<div id="wrapper">
		<div id="header">

			<h1>--Customer Resource Management--</h1>

		</div>


	</div>

           <br>

       <div>
               <input type="button" value="Add Customer" 
               onclick="window.location.href='ShowAddCustomerForm'"; return false;
               class="add-button"  />
               
       </div>
       
       
       
       
       
       <div>
       
          
           <form:form action ="SearchCustomer" modelAttribute="customers" method="GET">
           
           
                   <input type="search"  name="searchName"/> 
                           <input type="submit" value="Search" class="add-button"/>
                 
           
               <p>  <a href="${pageContext.request.contextPath}/customer/list"> Back to List</a>     </p>
           
           </form:form>
       
       
       </div>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       


	<div id="container">
		<div id="content">


			<table>

				<tr>

					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
					
				</tr>

				<c:forEach var="temp" items="${customers}">
				
                   
                   
                    <c:url var="updateurl" value="/customer/updateFormAdd">
                    
                       <c:param name="customerId" value="${temp.id}"/>
                    
                    </c:url>
                    
                    <c:url var="deleteurl" value="/customer/deleteCustomerForm">
                      <c:param name="customerId" value="${temp.id}"/>
                    </c:url>
                     
                     
					<tr>


						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						
						<td>
						 <a href=" ${updateurl}">Update</a>   
						  |
						  <a href="${deleteurl}" 
						  onclick="if(!(confirm('Are your sure to delete this'))) return false">Delete</a>   
						</td>

					</tr>

				</c:forEach>



			</table>
</body>
</div>

</div>


</html>









