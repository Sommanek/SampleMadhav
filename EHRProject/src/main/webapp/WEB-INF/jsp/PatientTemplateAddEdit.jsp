<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Include.jsp"%>
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
		function SaveAndGoTo(value){
			$("#redirectionFlag").val(value);
			$("#templateSubmit").submit();
			
		}
	</script>
</head>
<body>
	<%@include file="Header.jsp"%>
	
	<div class="filler-below1" >
	
		<form action="${pageContext.request.contextPath}/Template/SubmitTemplateData" name="templateSubmit" id="templateSubmit" method="POST">
		<input type="hidden" name="mode" id="mode" value="${mode}">
		<input type="hidden" name="templateId" id="templateId" value="${templateMasterBean.templateId}">
		<input type="hidden" name="templateName" id="templateName" value="${templateMasterBean.templateName}">
		<input type="hidden" name="templateCode" id="templateCode" value="${templateMasterBean.templateCode}">
		<input type="hidden" name="appointmentId" id="appointmentId" value="${AppointmentId}">
		<input type="hidden" name="apptId" id="apptId" value="${AppointmentId}">
		<input type="hidden" name="templateCategoryId" id="templateCategoryId" value="${templateMasterBean.templateCategoryId }">
		<input type="hidden" name="redirectionFlag" id="redirectionFlag" value="save">
		<input type="hidden" name="caseDocumentId" id="caseDocumentId" value="${caseDocumentId}">
		
		
		<table style="width: 90%; padding-top: 2%; padding-left: 30%">
			<tr>
				<td colspan="2">${templateMasterBean.templateName}</td>
			</tr>
			
			<c:forEach items="${templateMasterBean.templateDetails}" var="elementBean" varStatus="status">
			
				<tr>
					<td>${elementBean.elementName}</td>
				
					<td>
						<c:choose>
							<c:when test="${elementBean.primaryControlType == 1}">
								<input type="text" name="${elementBean.elementCode }" value="${elementBean.defaultValue}"> 
							</c:when>
							
							<c:when test="${elementBean.primaryControlType == 2}">
								<c:set var="opt" value="${fn:split(elementBean.elementOptions, '#')}"></c:set>
								<c:forEach items="${opt}" var="option">
									<input type="radio" name="${elementBean.elementCode}" id="${elementBean.elementCode}" value="${option}" checked="checked"/>
								</c:forEach>
							</c:when>
							
							<c:when test="${elementBean.primaryControlType == 3}">
							</c:when>
							
							<c:when test="${elementBean.primaryControlType == 4}">
							</c:when>
							
							<c:when test="${elementBean.primaryControlType == 5}">
								<textarea rows="25" cols="75" name="${elementBean.elementCode}" id="${elementBean.elementCode}"></textarea>
							</c:when>
						</c:choose>
						
						<c:forEach items="${templateMOUMap}" var="units">
							<c:if test="${units.key == elementBean.unitId}"><label>${units.value}</label></c:if>
						</c:forEach>
					</td>
					
					
				</tr>
			
			</c:forEach>
			
			<tr>
				<td colspan="2" style="margin-left: 20%">
					<input type="button" value="Save" onclick="javascript: SaveAndGoTo('save')">
					<c:if test="${redirectFlag ne null }">
					<input type="button" value="Save & Go to ${redirectFlag}" onclick="javascript: SaveAndGoTo('${redirectFlag}')">
					</c:if>
				</td>
			</tr>
			
		</table>
		
		</form>
	</div>
	

	
	
</body>
</html>