package net.javaci.sample.appticketz.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Application.class)
public abstract class Application_ {

	public static volatile SingularAttribute<Application, String> owner;
	public static volatile SetAttribute<Application, Release> releasesToDeploy;
	public static volatile ListAttribute<Application, Ticket> tickets;
	public static volatile SingularAttribute<Application, String> name;
	public static volatile SingularAttribute<Application, String> description;
	public static volatile SingularAttribute<Application, Integer> id;

	public static final String OWNER = "owner";
	public static final String RELEASES_TO_DEPLOY = "releasesToDeploy";
	public static final String TICKETS = "tickets";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

