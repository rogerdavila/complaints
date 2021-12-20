package com.java.complaints.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.java.complaints.bean.Complaint;
import com.java.complaints.bean.Status;

public class ComplaintDAOImpl implements ComplaintDAO {

	private JdbcTemplate jdbcTemplate;

	public ComplaintDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(Complaint complaint) {
		String sql = "INSERT INTO COMPLAINT(complaintId, complaintType, cDescription,"
				+ " complaintDate, severity, status) values (?,?,?,?,?,?)";
		jdbcTemplate.update(sql, complaint.getComplaintId(), complaint.getComplaintType(), complaint.getCDescription(),
				complaint.getComplaintDate(), complaint.getSeverity(), Status.PENDING.toString());
	}

	@Override
	public Complaint get(String complaintId) {
		String sql = "select * from Complaint where complaintId=?";
		return jdbcTemplate.query(sql, new Object[] { complaintId }, new ResultSetExtractor<Complaint>() {
			@Override
			public Complaint extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Complaint complaint = new Complaint();

					complaint.setCDescription(rs.getString("cdescription"));
					complaint.setComplaintDate(rs.getDate("complaintdate"));
					complaint.setComplaintId(rs.getString("complaintid"));
					complaint.setComplaintType(rs.getString("complaintType"));
					complaint.setSeverity(rs.getString("severity"));
					complaint.setStatus(Status.valueOf(rs.getString("status")));

					return complaint;
				}
				return null;
			}
		});
	}

	@Override
	public void resolve(String complaintId) {
		String sql = "UPDATE COMPLAINT SET status = ? where complaintId = ?";
		
		jdbcTemplate.update(sql, Status.RESOLVED.toString(), complaintId);
	}

}
