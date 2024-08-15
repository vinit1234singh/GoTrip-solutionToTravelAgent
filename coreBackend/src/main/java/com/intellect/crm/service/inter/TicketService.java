package com.intellect.crm.service.inter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intellect.crm.dto.TicketDTO;

@Service
public interface TicketService {

	public TicketDTO createTicket(TicketDTO ticket);
	public List<TicketDTO> getTicketsByUserId(Long userId);
	public List<TicketDTO> getAllTickets();
	public TicketDTO updateTicketStatus(Long ticketId, String status);
	public List<TicketDTO> getBySenderId(Long senderId);
	public List<TicketDTO> getByRecieverId(Long recieverId);
	
}
