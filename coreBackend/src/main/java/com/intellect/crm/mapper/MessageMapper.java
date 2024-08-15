package com.intellect.crm.mapper;

import com.intellect.crm.dto.MessageDTO;
import com.intellect.crm.models.Message;

/**
 * Utility class for mapping between Message entities and their corresponding Data Transfer Objects (DTOs).
 * 
 * @author vishal
 * @author tanmay
 */
public class MessageMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private MessageMapper(){}

    /**
     * Maps a Message entity to a Message DTO.
     * 
     * @param ticket the Message entity to be mapped
     * @return the corresponding Message DTO
     */
    public static MessageDTO mapToTicketDTO(Message ticket) {
        return new MessageDTO(ticket.getId(), ticket.getAdminId(), ticket.getCustomerId(), ticket.getIssueDate(),
                ticket.getStatus(), ticket.getPriority(), ticket.getContent());
    }

    /**
     * Maps a Message DTO to a Message entity.
     * 
     * @param ticketDto the Message DTO to be mapped
     * @return the corresponding Message entity
     */
    public static Message mapToTicket(MessageDTO ticketDto) {
        return new Message(ticketDto.getId(), ticketDto.getAdminId(), ticketDto.getCustomerId(),
                ticketDto.getIssueDate(), ticketDto.getStatus(), ticketDto.getPriority(), ticketDto.getMessage());
    }
}
