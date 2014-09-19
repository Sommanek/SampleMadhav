<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Include.jsp"%>
<script type="text/javascript">
	function editTemplate(module, appointmentId){
		
		var action = "";
		if(module == 'HPI'){
			action = 'Vital';
		}else if(module == 'ROS'){
			action = 'HPI';
		}else if(module == 'TRP'){
			action = 'ROS';
		}
		$("#templateView").attr("action", action);
		//$("#action").val(action);
		$("#templateView").submit();
	}
	
	function goToTemplate(module){
		//$("#action").val(module);
		//$("#templateView").submit();
	}
</script>
</head>

<body>
	<%@include file="Header.jsp"%>
	<form  id="templateView" action="" method="post">
		<div class="filler-below1" >
			<input type="hidden" name="mode" id="mode" value="edit"/>
			<input type="hidden" name="templateId" id="templateId" value="${fields.get(0).templateId}"/>
			<input type="hidden" name="templateCode" id="templateCode" value="${fields.get(0).templateCode}"/>
			<input type="hidden" name="apptId" id="appointmentId" value="${fields.get(0).appointmentId}"/>
			<input type="hidden" name="caseDocumentId" id="caseDocumentId" value="${fields.get(0).caseDocumentId}"/>
			
			<table>	
				<c:forEach items="${fields}" var="field">
					<tr>
						<td>${field.elementName}</td>
						<td>${field.fieldValue}</td>				
					</tr>
				</c:forEach>
			</table>
			
			<input type="button" value="Edit" onclick="javascript:editTemplate('${redirectFlag}', '${fields.get(0).appointmentId}');">
			<input type="button" value="Go to ${redirectFlag}" onclick="javascript:goToTemplate('${redirectFlag}', '${fields.get(0).appointmentId}');"> 
		</div>
		
 
	</form>
	
</body>