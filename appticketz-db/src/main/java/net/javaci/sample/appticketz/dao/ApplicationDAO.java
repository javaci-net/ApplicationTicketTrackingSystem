package net.javaci.sample.appticketz.dao;

import net.javaci.sample.appticketz.entity.Application;
import net.javaci.sample.appticketz.entity.dto.ApplicationDTO;

public interface ApplicationDAO {

	void addApplication(Application application);

	Application getApplicationById(int applicationId);

	boolean applicationExists(String name, String owner);

	boolean applicationReallyExists(String name, String owner);

	boolean updateNameAndOwnerById(Integer id, String newName, String newOwner);

	Application getApplicationWithTicketsAndReleases(int applicationId);

	Application getApplicationWithTicketsAndReleasesV2(int applicationId);

	ApplicationDTO getApplicationWithTicketsAndReleasesV3(int applicationId);
	
}
