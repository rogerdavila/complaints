<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="UTF-8">
<title>Complaint Form</title>
</head>
<body>

	<div align="center">
		<h1>Resolve Complaint</h1>

		<table>
			<tr>
				<td>Complaint Id</td>
				<td><c:out value="${complaint.complaintId}"/></td>
			</tr>
			<tr>
				<td>Complaint Type:</td>
				<td><c:out value="${complaint.complaintType}"/></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><c:out value="${complaint.CDescription}"/></td>
			</tr>
			<tr>
				<td>Complaint Date:</td>
				<td><c:out value="${complaint.complaintDate}"/></td>
			</tr>
			<tr>
				<td>Severity:</td>
				<td><c:out value="${complaint.severity}"/></td>
			</tr>
		</table>
		<h2>Resolution Details</h2>
		<form:form action="resolvecomplaint" method="post"
			modelAttribute="resolve">
			<table>
				<tr>
					<td>Complaint Id</td>
					<td><form:input path="complaintId" readonly="true"/></td>
				</tr>
				<tr>
					<td>Complaint Date:</td>
					<fmt:formatDate value="${resolve.complaintDate}" var="complaintDate" pattern="MM/dd/yyyy" />
					<td><form:input path="complaintDate" readonly="true"/></td>
				</tr>
				<tr>
					<td>Resolve Date:</td>
					<fmt:formatDate value="${resolve.resolveDate}" var="resolveDate" pattern="MM/dd/yyyy" />
					<td><form:input path="resolveDate" readonly="true"/></td>
				</tr>
				<tr>
					<td>Resolve By:</td>
					<td><form:input path="resolvedBy" /></td>
				</tr>
				<tr>
					<td>Comments:</td>
					<td><form:input path="comments" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Resolve"></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>