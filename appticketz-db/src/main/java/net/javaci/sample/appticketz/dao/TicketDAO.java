package net.javaci.sample.appticketz.dao;

import java.util.List;

import net.javaci.sample.appticketz.entity.Ticket;
import net.javaci.sample.appticketz.entity.dto.TicketStatsByStatusDTO;

public interface TicketDAO {

	void addTicket(Ticket ticket);

	Ticket getTicketById(int ticketId);
	
	List<TicketStatsByStatusDTO> findTicketStats();

	boolean removeTickets(List<Ticket> tickets);

	boolean removeTicket(Ticket ticket);
	
}
