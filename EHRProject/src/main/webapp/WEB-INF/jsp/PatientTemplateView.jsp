<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="Include.jsp"%>
</head>

<body>
	<%@include file="Header.jsp"%>
	
	<div class="filler-below1" >
	
		<table>	
			<c:forEach items="${fields}" var="field">
				<tr>
					<td>${field.fieldName}</td>
					<td>${field.fieldValue}</td>				
				</tr>
			</c:forEach>
		</table>
	</div>
	
</body>