package net.javaci.sample.appticketz.dao.springdata;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaci.sample.appticketz.dao.ReleaseDAO;
import net.javaci.sample.appticketz.entity.Release;

@Transactional
@Repository
@Primary
public interface ReleaseDAOCrudRepositoryImpl extends ReleaseDAO, JpaRepository<Release, Integer> {

	/** @deprecated Use save */
	@Deprecated
	@Override
	default void addRelease(Release release) {
		save(release);
	}

	/** @deprecated Use findById */
	@Deprecated
	@Override
	default Release getReleaseById(int releaseId) {
		return findById(releaseId).get();
	}

}
