package net.javaci.sample.appticketz.dao;

import net.javaci.sample.appticketz.entity.Release;

public interface ReleaseDAO {

	void addRelease(Release release);

	Release getReleaseById(int releaseId);
	
}
