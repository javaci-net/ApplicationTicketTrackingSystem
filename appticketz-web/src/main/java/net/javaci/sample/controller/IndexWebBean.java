package net.javaci.sample.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import net.javaci.sample.appticketz.dao.impl.ReleaseDAOImpl;
import net.javaci.sample.appticketz.dao.impl.TicketDAOImpl;
import net.javaci.sample.appticketz.dao.springdata.ApplicationDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.entity.Application;

@Controller(value = "indexWebBean")
public class IndexWebBean {

	private static final Logger log = LoggerFactory.getLogger(IndexWebBean.class);

	@Autowired private TicketDAOImpl ticketDAO;
	
	@Autowired private ApplicationDAOCrudRepositoryImpl applicationDAO;
	
	@Autowired private ReleaseDAOImpl releaseDAO;
	
	public List<Application> getApplications() {
		
		Page<Application> applicationList = applicationDAO.findAll(PageRequest.of(0, 10, Sort.by("name").ascending()));
		
		return applicationList.getContent();
	}
}
