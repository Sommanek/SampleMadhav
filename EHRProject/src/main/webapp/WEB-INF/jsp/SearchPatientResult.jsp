<!DOCTYPE html>
<%@ page isELIgnored="false"%>
<html lang="en" class="no-js">
<head>
	<%@include file="Include.jsp"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/component2.css" />
	<script>
		function editPatient(id){
			window.location.replace("editPatient/"+id);
		}
		
		function deletePatient(id){
			window.location.replace("deletePatient/"+id);
		}
	</script>
</head>
<body>
<%@include file="Header.jsp" %>
		<div class="fileter-below1">
				<table class="GridTable">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Date of Birth</th>
							<th>Sex</th>
							<th>Address Line 1</th>
							<th>Address Line 2</th>
							<th>City</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${patientList}" var="patient">
						<tr>
							<td class="user-name">${patient.patientFirstName}</td>
							<td class="user-name">${patient.patientLastName}</td>
							<td class="user-name">${patient.dateOfBirth}</td>
							<td class="user-name">${patient.sex}</td>
							<td class="user-name">${patient.addressLine1}</td>
							<td class="user-name">${patient.addressLine2}</td>
							<td class="user-name">${patient.city}</td>
							<td>
								<a href="javascript:;" onclick="editPatient(${patient.patientId});">Edit</a>
								<a href="javascript:;" onclick="deletePatient(${patient.patientId});">Delete</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
		
		</div>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="../resources/js/jquery.stickyheader.js"></script>
	</body>
</html>

