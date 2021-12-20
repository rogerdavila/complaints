package com.java.complaints.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.java.complaints.bean.Resolve;

public class ResolveDAOImpl implements ResolveDAO {

	private JdbcTemplate jdbcTemplate;

	public ResolveDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void add(Resolve resolve) {
		String sql = "INSERT INTO RESOLVE(complaintId, complaintDate, resolveDate,"
				+ " resolvedBy, comments) values (?,?,?,?,?)";
		jdbcTemplate.update(sql, resolve.getComplaintId(), resolve.getComplaintDate(), resolve.getResolveDate(),
				resolve.getResolvedBy(),resolve.getComments());
	}

}
