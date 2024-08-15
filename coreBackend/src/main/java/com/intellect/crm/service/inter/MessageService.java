package com.intellect.crm.service.inter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intellect.crm.dto.MessageDTO;

@Service
public interface MessageService {
    MessageDTO addTicket(MessageDTO ticketDTO);
    List<MessageDTO> getAllTickets();
    List<MessageDTO> getByCustomerId(Long id);
    List<MessageDTO> getByAdminId(Long id);
    MessageDTO getTicketById(Long id);
    MessageDTO updateTicket(Long id, MessageDTO ticketDTO);
    MessageDTO deleteTicket(Long id);
    
}
