
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.EHR.bean.Patient" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%-- <c:if test="${mode} != edit"> --%> 
	<%@include file="Include.jsp"%>
	<%-- </c:if> --%>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
	<style>
		input{
			background-color: white;
			border-radius: 5px;
			height: 30px;
		}
		
		tr{
			padding: 2px 2px 2px 2px;
		}
		
		td{
			padding: 2px 2px 2px 15px;
		}
	</style>
	<script type="text/javascript">
	 $(function() {
		    $( "#datepicker" ).datepicker();
		  });
	</script>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="filler-below1">
  	
  		<form:form commandName="patient" action="${pageContext.request.contextPath}/Patient/patientAddEditSubmit" method="POST">
  		
  		<form:hidden path="patientId" value=""/>
  		
  		<table style="margin-left: 20%; padding-top: 2%">
  		
  			  <tr>
	  			<td colspan="4">
	  				<label>${message}</label>
	  			</td>
	  		</tr>
  		
	  		<tr>
	  			<td colspan="4">
	  				<label><h3>Patient Information</h3></label>
	  			</td>
	  		</tr>
  		
	  			<tr>
	  				<td>First Name:</td>
	  				<td><form:input path="patientFirstName"></form:input></td>
	  				<td>Date of Birth:</td>
	  				<td><form:input path="dateOfBirth" id="datepicker"></form:input></td>
	  			</tr>
	  			<tr>
	  				<td>Last Name:</td>
	  				<td><form:input path="patientLastName"></form:input></td>
	  				<td>Sex:</td>
	  				<td>
	  					<form:select path="sex">
	  						<form:option value="1">Male</form:option>
	  						<form:option value="2">Female</form:option>
	  					</form:select>
	  				</td>	  				
	  			</tr>
	  			<tr>
	  				<td>Address Line 1:</td>
	  				<td><form:input path="addressLine1"></form:input></td>
					<td>Address Line 2:</td>
	  				<td><form:input path="addressLine2"></form:input></td>	  				
	  			</tr>
	  			  			  		
	  			<tr>
	  				<td>City:</td>
	  				<td>
	  					<form:select path="city">
	  						<form:option value="New York">New York</form:option>
	  						<form:option value="Arizona">Arizona</form:option>
	  						<form:option value="Florida">Florida</form:option>
	  					</form:select>
	  				</td>
	  				<td>State:</td>
	  				<td><form:input path=""></form:input></td>
	  			</tr>  		
	  			<tr>
	  				<td>Contact:</td>
	  				<td><form:input path="contactDetail"></form:input></td>
	  				<td>Alternate Contact:</td>
	  				<td><form:input path="alternateContact"></form:input></td>
	  			</tr>
	  			
				<tr>
	  				<td>Primary Physician:</td>
	  				<td><form:input path="primaryPhysician"></form:input></td>
	  				<td>Referring Physician:</td>
	  				<td><form:input path="referringPhysician"></form:input></td>
	  			</tr>
	  			
	  			<tr>
	  				<td colspan="4" style="text-align: center;">
	  					<input type="Submit" value="Add Patient">
	  				</td>
	  			</tr>  			  			  		
	  						  			
	  		</table>
  		
  		</form:form> 
  		
  	</div>

  <%@include file="Footer.jsp"%>
</body>
</html>