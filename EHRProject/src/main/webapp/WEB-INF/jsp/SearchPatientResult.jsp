<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en" class="no-js">
<link rel="stylesheet" type="text/css" href="../resources/css/component2.css" />
<script>
	function editPatient(id){
		window.location.replace("/editPatient/"+id);
	}
	
	function deletePatient(id){
		
	}
</script>
<%@include file="Header.jsp" %>
		<div class="fileter-below1">
				<table class="GridTable">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Phone</th>
							<th>Mobile</th>
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
								<a href="javascript:;" onclick="deletePatient(${patient.patientId});">Edit</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
		
		</div><!-- /container -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
		<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-throttle-debounce/1.1/jquery.ba-throttle-debounce.min.js"></script>
		<script src="../resources/js/jquery.stickyheader.js"></script>
	</body>
</html>

