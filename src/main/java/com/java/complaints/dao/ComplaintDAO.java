package com.java.complaints.dao;

import com.java.complaints.bean.Complaint;

public interface ComplaintDAO {

	void add(Complaint complaint);
	
	Complaint get(String complaintId);
	
	void resolve(String complaintId);
	
}
