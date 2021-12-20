package com.java.complaints.bean;

import java.util.Date;

public class Complaint {

	private String complaintId;

	private String complaintType;

	private String cDescription;

	private Date complaintDate;

	private String severity;

	private Status status;

	public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public String getCDescription() {
		return cDescription;
	}

	public void setCDescription(String cDescription) {
		this.cDescription = cDescription;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
