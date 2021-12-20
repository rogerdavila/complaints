package com.java.complaints.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.java.complaints.bean.Complaint;
import com.java.complaints.bean.ComplaintResolve;
import com.java.complaints.bean.Resolve;
import com.java.complaints.bean.Status;

public class ComplaintResolveDAOImpl implements ComplaintResolveDAO {

	private JdbcTemplate jdbcTemplate;

	public ComplaintResolveDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ComplaintResolve> list() {
		String sql = "select * from complaint c left join resolve r on (c.complaintId = r.complaintId)";

		List<ComplaintResolve> complaintsResolves = jdbcTemplate.query(sql, new RowMapper<ComplaintResolve>() {

			@Override
			public ComplaintResolve mapRow(ResultSet rs, int rowNum) throws SQLException {
				ComplaintResolve complaintResolve = new ComplaintResolve();

				Complaint complaint = new Complaint();
				complaint.setCDescription(rs.getString("c.cdescription"));
				complaint.setComplaintDate(rs.getDate("c.complaintdate"));
				complaint.setComplaintId(rs.getString("c.complaintid"));
				complaint.setComplaintType(rs.getString("c.complaintType"));
				complaint.setSeverity(rs.getString("c.severity"));
				complaint.setStatus(Status.valueOf(rs.getString("c.status")));
				complaintResolve.setComplaint(complaint);
				
				Resolve resolve = new Resolve();
				resolve.setComplaintId(rs.getString("r.complaintId"));
				resolve.setComments(rs.getString("r.comments"));
				resolve.setComplaintDate(rs.getDate("r.complaintDate"));
				resolve.setResolveDate(rs.getDate("r.resolveDate"));
				resolve.setResolvedBy(rs.getString("r.resolvedBy"));
				complaintResolve.setResolve(resolve);

				return complaintResolve;
			}

		});

		return complaintsResolves;
	}

	@Override
	public List<ComplaintResolve> listResolved() {
		String sql = "select * from complaint c inner join resolve r on (c.complaintId = r.complaintId)"
				+ " where c.status = ?";

		List<ComplaintResolve> complaintsResolves = jdbcTemplate.query(sql, new Object[] { Status.RESOLVED.toString() }, new RowMapper<ComplaintResolve>() {

			@Override
			public ComplaintResolve mapRow(ResultSet rs, int rowNum) throws SQLException {
				ComplaintResolve complaintResolve = new ComplaintResolve();

				Complaint complaint = new Complaint();
				complaint.setCDescription(rs.getString("c.cdescription"));
				complaint.setComplaintDate(rs.getDate("c.complaintdate"));
				complaint.setComplaintId(rs.getString("c.complaintid"));
				complaint.setComplaintType(rs.getString("c.complaintType"));
				complaint.setSeverity(rs.getString("c.severity"));
				complaint.setStatus(Status.valueOf(rs.getString("c.status")));
				complaintResolve.setComplaint(complaint);
				
				Resolve resolve = new Resolve();
				resolve.setComplaintId(rs.getString("r.complaintId"));
				resolve.setComments(rs.getString("r.comments"));
				resolve.setComplaintDate(rs.getDate("r.complaintDate"));
				resolve.setResolveDate(rs.getDate("r.resolveDate"));
				resolve.setResolvedBy(rs.getString("r.resolvedBy"));
				complaintResolve.setResolve(resolve);

				return complaintResolve;
			}

		});

		return complaintsResolves;
	}

}
