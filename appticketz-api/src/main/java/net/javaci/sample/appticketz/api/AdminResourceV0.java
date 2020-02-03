package net.javaci.sample.appticketz.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaci.sample.appticketz.dao.springdata.ApplicationDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.dao.springdata.ReleaseDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.dao.springdata.TicketDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.entity.Application;
import net.javaci.sample.appticketz.entity.Release;
import net.javaci.sample.appticketz.entity.Ticket;

@RestController
@RequestMapping(
	value = "/api/admin/v0",
	produces = { 
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE 
	}
)
public class AdminResourceV0 {
	
	private static final Logger log = LoggerFactory.getLogger(AdminResourceV0.class);
	
	@Autowired
	private ApplicationDAOCrudRepositoryImpl applicationDAO;
	
	@Autowired
	private ReleaseDAOCrudRepositoryImpl releaseDAO;
	
	@Autowired
	private TicketDAOCrudRepositoryImpl ticketDAO;

	@GetMapping("/init")
	public Boolean initSampleRecords() {
		
		log.info( ">> TEST PERSIST >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		
		Application facebookWebApp = new Application("Facebook Web App", "Facebook.com", "volkan");
		log.info("** Adding facebookWebApp: {}", facebookWebApp);
		applicationDAO.addApplication(facebookWebApp);
		Application facebookCoreSystemApp = new Application("Facebook Core System", "Facebook Core", "koray");
		log.info("** Adding facebookCoreSystemApp: {}", facebookCoreSystemApp);
		applicationDAO.addApplication(facebookCoreSystemApp);
		Application facebookMobileApp = new Application("Facebook Mobile App", "Facebook Mobile", "dogancan");
		log.info("** Adding facebookMobileApp: {}", facebookMobileApp);
		applicationDAO.addApplication(facebookMobileApp);
		Application facebookAdminApp = new Application("Facebook Admin App", "Facebook Admin", "dogancan");
		log.info("** Adding facebookAdminApp: {}", facebookAdminApp);
		applicationDAO.addApplication(facebookAdminApp);
		Application demoApp = new Application("Temporary Demo Application", "Demo App", "ozkan");
		log.info("** Adding demoApp: {}", demoApp);
		applicationDAO.addApplication(demoApp);
		
		Ticket ticket1 = new Ticket("Login failed when empty", "OPEN", "Login Bug", LocalDate.now(), LocalDateTime.now(), facebookWebApp);
		log.info("** Adding ticket1: {}", ticket1);
		ticketDAO.addTicket(ticket1);
		Ticket ticket2 = new Ticket("Password reminder not working", "CLOSED", "Pwd Remind Bug", LocalDate.now(), LocalDateTime.now(), facebookWebApp);
		log.info("** Adding ticket2: {}", ticket2);
		ticketDAO.addTicket(ticket2);
		
		Set<Application> deployedApplications1 = new HashSet<Application>();
		deployedApplications1.add(facebookWebApp);
		deployedApplications1.add(facebookCoreSystemApp);
		Release release1 = new Release("v1", LocalDateTime.now().plusDays(10), deployedApplications1);
		log.info("** Adding release1: {}", release1);
		releaseDAO.addRelease(release1);
		
		Set<Application> deployedApplications2 = new HashSet<Application>();
		deployedApplications2.add(facebookWebApp);
		deployedApplications2.add(facebookMobileApp);
		Release release2 = new Release("v2", LocalDateTime.now().plusDays(10), deployedApplications2);
		log.info("** Adding release2: {}", release2);
		releaseDAO.addRelease(release2);
		
		log.info( "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
		
		return Boolean.TRUE;
	}
}
