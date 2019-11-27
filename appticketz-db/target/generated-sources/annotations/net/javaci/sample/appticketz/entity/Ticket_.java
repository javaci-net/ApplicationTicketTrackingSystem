package net.javaci.sample.appticketz.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ticket.class)
public abstract class Ticket_ {

	public static volatile SingularAttribute<Ticket, Application> application;
	public static volatile SingularAttribute<Ticket, String> description;
	public static volatile SingularAttribute<Ticket, Integer> id;
	public static volatile SingularAttribute<Ticket, String> title;
	public static volatile SingularAttribute<Ticket, String> status;
	public static volatile SingularAttribute<Ticket, LocalDate> createDate;
	public static volatile SingularAttribute<Ticket, LocalDateTime> createDateTime;

}

