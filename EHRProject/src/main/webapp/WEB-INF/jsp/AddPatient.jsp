<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
	<%@include file="Header.jsp"%>
<body>

	<div class="filler-below1">
  		
  		<form:form modelAttribute="patient">
  		
  		<table>
  			<tr>
  				<td>First Name:</td>
  				<td></td>
  			</tr>
  			<tr>
  				<td>Last Name:</td>
  				<td></td>
  			</tr>
  			<tr>
  				<td>Address Line 1:</td>
  				<td></td>
  			</tr>
  			<tr>
  				<td>Address Line 2:</td>
  				<td></td>
  			</tr>  			  		
  			<tr>
  				<td>City:</td>
  				<td></td>
  			</tr>  		
  			<tr>
  				<td>State:</td>
  				<td></td>
  			</tr>  		
  						  			
  		</table>
  		
  		</form:form>
  	</div>

  <%@include file="Footer.jsp"%>
</body>
</html>