package com.intellect.crm.mapper;

import com.intellect.crm.dto.TicketDTO;
import com.intellect.crm.models.Ticket;


/**
 * Utility class for mapping between Ticket entities and their corresponding Data Transfer Objects (DTOs).
 * 
 * @author renisha
 * @author yash
 */
public class TicketMapper {

        /**
         * Private constructor to prevent instantiation of this utility class.
         */
        private TicketMapper(){}
    
        /**
         * Maps a Ticket entity to a Ticket DTO.
         * 
         * @param ticket the Ticket entity to be mapped
         * @return the corresponding Ticket DTO
         */
        public static TicketDTO toDTO(Ticket ticket) {
            TicketDTO dto = new TicketDTO();
            dto.setId(ticket.getId());
            dto.setSubject(ticket.getSubject());
            dto.setDescription(ticket.getDescription());
            dto.setCreatedDate(ticket.getCreatedDate());
            dto.setStatus(ticket.getStatus());
            dto.setSenderId(ticket.getSenderId());
            dto.setRecieverId(ticket.getRecieverId());
            return dto;
        }
    
        /**
         * Maps a Ticket DTO to a Ticket entity.
         * 
         * @param dto the Ticket DTO to be mapped
         * @return the corresponding Ticket entity
         */
        public static Ticket toEntity(TicketDTO dto) {
            Ticket ticket = new Ticket();
            ticket.setId(dto.getId());
            ticket.setSubject(dto.getSubject());
            ticket.setDescription(dto.getDescription());
            ticket.setCreatedDate(dto.getCreatedDate());
            ticket.setStatus(dto.getStatus());
            ticket.setRecieverId(dto.getRecieverId());
            ticket.setSenderId(dto.getSenderId());
            return ticket;
        }
    }