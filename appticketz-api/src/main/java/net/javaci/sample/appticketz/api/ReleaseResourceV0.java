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

import net.javaci.sample.appticketz.dao.springdata.ReleaseDAOCrudRepositoryImpl;
import net.javaci.sample.appticketz.entity.Release;

@RestController
@RequestMapping(
	value = "/api/release/v0",
	produces = { 
		MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE 
	}
)
public class ReleaseResourceV0 {

	@Autowired
	private ReleaseDAOCrudRepositoryImpl releaseDAO;

	@GetMapping("/applications")
	public List<Release> getReleasess(
			@RequestParam(value = "page", defaultValue = "0") int page, 
			@RequestParam(value = "size", defaultValue = "10") int size) {
		
		Page<Release> releaseList = releaseDAO.findAll(PageRequest.of(page, size, Sort.by("name").ascending()));
		return releaseList.getContent();
		
	}
}
