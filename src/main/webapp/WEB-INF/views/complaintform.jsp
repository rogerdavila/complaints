<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta charset="UTF-8">
<title>Complaint Form</title>
</head>
<body>

	<div align="center">
		<h1>Add Complaint</h1>
		<form:form action="savecomplaint" method="post" modelAttribute="complaint">
			<table>
				<tr>
					<td>Complaint Id</td>
					<td><form:input path="complaintId" /></td>
				</tr>
				<tr>
					<td>Complaint Type:</td>
					<td><form:input path="complaintType" /></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><form:input path="cDescription" /></td>
				</tr>
				<tr>
					<td>Complaint Date:</td>
					<td><form:input path="complaintDate" readonly="true"/></td>
				</tr>
				<tr>
					<td>Severity:</td>
					<td><form:input path="severity" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>