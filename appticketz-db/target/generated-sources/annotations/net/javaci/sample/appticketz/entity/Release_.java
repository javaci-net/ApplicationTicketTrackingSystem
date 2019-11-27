package net.javaci.sample.appticketz.entity;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Release.class)
public abstract class Release_ {

	public static volatile SetAttribute<Release, Application> deployedApplications;
	public static volatile SingularAttribute<Release, String> name;
	public static volatile SingularAttribute<Release, Integer> id;
	public static volatile SingularAttribute<Release, LocalDateTime> releaseDateTime;

}

