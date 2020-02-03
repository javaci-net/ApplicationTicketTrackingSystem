package net.javaci.sample.appticketz.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.javaci.sample.appticketz.dao.springdata.ApplicationDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.entity.Application;
import net.javaci.sample.appticketz.entity.dto.ApplicationDTO;

@RestController
@RequestMapping(
	value = "/api/application/v0",
	produces = { 
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE 
	}
)
public class ApplicationResourceV0 {

	@Autowired
	private ApplicationDAOCrudRepositoryImpl applicationDAO;

	@GetMapping("/application/summary")
	public List<ApplicationDTO> getApplications() {
		return applicationDAO.findApplicationDTOListWithTicketsAndReleases();
	}
	
	@GetMapping("/applications")
	public List<Application> getApplications(
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Page<Application> applicationList = applicationDAO.findAll(PageRequest.of(page, size, Sort.by("name").ascending()));
		return applicationList.getContent();
		
	}
}
