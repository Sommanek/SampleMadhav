<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.EHR.bean.Patient"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
	<%@include file="Header.jsp"%>
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
<body>

	<div class="filler-below1">
  	<%-- 	
  		<form:form commandName="patient" action="Patient/patientAddEditSubmit" method="POST">
  		
  		<form:hidden path="patient.patientId" value=""/>
  		
  		<table style="margin-left: 20%; padding-top: 2%">
  		
	  		<tr>
	  			<td colspan="4">
	  				<label><h3>Patient Information</h3></label>
	  			</td>
	  		</tr>
  		
	  			<tr>
	  				<td>First Name:</td>
	  				<td><form:input path="patientFirstName"></form:input></td>
	  				<td>Date of Birth:</td>
	  				<td><form:input path="dateOfBirth"></form:input></td>
	  			</tr>
	  			<tr>
	  				<td>Last Name:</td>
	  				<td><form:input path="patientLastName"></form:input></td>
	  				<td>Sex:</td>
	  				<td><form:input path="sex"></form:input></td>	  				
	  			</tr>
	  			<tr>
	  				<td>Address Line 1:</td>
	  				<td><form:input path="addressLine1"></form:input></td>
					<td>Address Line 2:</td>
	  				<td><form:input path="addressLine2"></form:input></td>	  				
	  			</tr>
	  			  			  		
	  			<tr>
	  				<td>City:</td>
	  				<td><form:input path="city"></form:input></td>
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
  		
  		</form:form> --%>
  		Hello worldtestsetest
  	</div>

  <%@include file="Footer.jsp"%>
</body>
</html>