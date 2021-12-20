package com.java.complaints.dao;

import java.util.List;

import com.java.complaints.bean.ComplaintResolve;

public interface ComplaintResolveDAO {

	List<ComplaintResolve> list();
	
	List<ComplaintResolve> listResolved();
	
}
