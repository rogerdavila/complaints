package com.java.complaints.bean;

import java.util.Calendar;

public class ComplaintResolve {

	private Complaint complaint;

	private Resolve resolve;

	public Complaint getComplaint() {
		return complaint;
	}

	public void setComplaint(Complaint complaint) {
		this.complaint = complaint;
	}

	public Resolve getResolve() {
		return resolve;
	}

	public void setResolve(Resolve resolve) {
		this.resolve = resolve;
	}

	public String getResolvedComplaintDisplayColor() {
		Calendar resolveDate = Calendar.getInstance();
		resolveDate.setTime(resolve.getResolveDate());
		Calendar complaintDate = Calendar.getInstance();
		complaintDate.setTime(resolve.getComplaintDate());

		boolean sameDay = resolveDate.get(Calendar.DAY_OF_YEAR) == complaintDate.get(Calendar.DAY_OF_YEAR)
				&& resolveDate.get(Calendar.YEAR) == complaintDate.get(Calendar.YEAR);

		Calendar fiveDays = Calendar.getInstance();
		fiveDays.setTime(resolve.getComplaintDate());
		fiveDays.add(Calendar.DAY_OF_MONTH, 5);

		if (sameDay) {
			return "background-color: green;";
		} else if (resolveDate.before(fiveDays)) {
			return "background-color: pink;";
		} else {
			return "background-color: red;";
		}
	}
	
	public String getComplaintDisplayColor() {
		Calendar endDate = Calendar.getInstance();
		
		if (complaint.getStatus() == Status.RESOLVED) { 
			endDate.setTime(resolve.getResolveDate());
		}

		Calendar oneweek = Calendar.getInstance();
		oneweek.setTime(complaint.getComplaintDate());
		oneweek.add(Calendar.DAY_OF_MONTH, 7);

		if (endDate.after(oneweek)) {
			return "background-color: red;";
		}
		return "background-color: white;";
	}

}
