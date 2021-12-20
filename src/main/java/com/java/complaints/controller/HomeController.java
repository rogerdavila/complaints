package com.java.complaints.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.complaints.bean.Complaint;
import com.java.complaints.bean.ComplaintResolve;
import com.java.complaints.bean.Resolve;
import com.java.complaints.dao.ComplaintDAO;
import com.java.complaints.dao.ComplaintResolveDAO;
import com.java.complaints.dao.ResolveDAO;

@Controller
public class HomeController {

	@Autowired
	private ComplaintDAO complaintDAO;
	
	@Autowired
	private ResolveDAO resolveDAO;
	
	@Autowired
	private ComplaintResolveDAO complaintResolveDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/")
	public ModelAndView listComplaints(ModelAndView model) throws IOException {
		List<ComplaintResolve> complaintsResolves = complaintResolveDAO.list();

		model.setViewName("home");
		model.addObject("complaintsResolves", complaintsResolves);

		return model;
	}

	@RequestMapping(value = "addcomplaint", method = RequestMethod.GET)
	public ModelAndView addComplaint(ModelAndView model) {
		Complaint complaint = new Complaint();
		complaint.setComplaintDate(Calendar.getInstance().getTime());
		model.addObject("complaint", complaint);
		model.setViewName("complaintform");
		return model;
	}

	@RequestMapping(value = "savecomplaint", method = RequestMethod.POST)
	 public ModelAndView saveComplaint(@ModelAttribute Complaint complaint) {
	     complaintDAO.add(complaint);
	     return new ModelAndView("redirect:/");
	 } 
	
	@RequestMapping(value = "resolvecomplaint", method = RequestMethod.GET)
	public ModelAndView resolveComplaint(HttpServletRequest request) {
		String complaintId = request.getParameter("complaintId");
		Complaint complaint = complaintDAO.get(complaintId);
		
		Resolve resolve = new Resolve();
		resolve.setComplaintId(complaint.getComplaintId());
		resolve.setComplaintDate(complaint.getComplaintDate());
		resolve.setResolveDate(Calendar.getInstance().getTime());
		
		ModelAndView model = new ModelAndView("resolveform");
		model.addObject("complaint", complaint);
		model.addObject("resolve", resolve);
		return model;
	}
	
	@RequestMapping(value = "resolvecomplaint", method = RequestMethod.POST)
	public ModelAndView saveResolveComplaint(@ModelAttribute Resolve resolve) {
		resolveDAO.add(resolve);
		complaintDAO.resolve(resolve.getComplaintId());
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "resolvedcomplaints")
	public ModelAndView listResolvedComplaints(ModelAndView model) {
		List<ComplaintResolve> complaintsResolves = complaintResolveDAO.listResolved();

		model.setViewName("resolvedcomplaints");
		model.addObject("complaintsResolves", complaintsResolves);

		return model;
	}
}
