<%@page import="com.java.complaints.bean.Complaint"%>
<%@page import="com.java.complaints.bean.Status"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div align="center">
		<h1>Complaint List</h1>
		<h3>
			<a href="addcomplaint">New Complaint</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="resolvedcomplaints">See resolved complaints</a>
		</h3>
		<table border="1">
			<tr>
				<th>Complaint ID</th>
				<th>Complaint Type</th>
				<th>Description</th>
				<th>Complaint Date</th>
				<th>Severity</th>
				<th>Status</th>
			</tr>
			<c:forEach var="complaintResolve" items="${complaintsResolves}">
				<tr style="${complaintResolve.complaintDisplayColor}">
					<td>${complaintResolve.complaint.complaintId}</td>
					<td>${complaintResolve.complaint.complaintType}</td>
					<td>${complaintResolve.complaint.CDescription}</td>
					<td>${complaintResolve.complaint.complaintDate}</td>
					<td>${complaintResolve.complaint.severity}</td>
					<td>${complaintResolve.complaint.status}</td>
					<td>
						<c:if
							test="${complaintResolve.complaint.status == 'PENDING'}">
							<a
								href="resolvecomplaint?complaintId=${complaintResolve.complaint.complaintId}">Resolve</a>
						</c:if>
					</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
