package com.intellect.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.crm.dto.MessageDTO;
import com.intellect.crm.mapper.MessageMapper;
import com.intellect.crm.models.Message;
import com.intellect.crm.repo.MessageRepository;
import com.intellect.crm.service.inter.MessageService;

/**
 * Implementation of the {@link MessageService} interface.
 * 
 * @author vishal and tanmay
 */
@Service
public class MessageServiceImplementation implements MessageService {

    /**
     * Autowired instance of the {@link MessageRepository} interface.
     */
    @Autowired
    private MessageRepository ticketRepository;

    /**
     * Add a new ticket.
     * 
     * @param ticketDTO the ticket data to add
     * @return the added ticket
     */
    @Override
    public MessageDTO addTicket(MessageDTO ticketDTO) {
        Message ticket = MessageMapper.mapToTicket(ticketDTO);
        ticketRepository.save(ticket);
        return ticketDTO;
    }

    /**
     * Retrieve a list of all tickets.
     * 
     * @return a list of all tickets
     */
    @Override
    public List<MessageDTO> getAllTickets() {
        List<Message> tickets = ticketRepository.findAll();
        return tickets.stream().map(MessageMapper::mapToTicketDTO).toList();
    }

    /**
     * Retrieve a ticket by its ID.
     * 
     * @param id the ID of the ticket to retrieve
     * @return the ticket with the given ID, or null if not found
     */
    @Override
    public MessageDTO getTicketById(Long id) {
        Optional<Message> tick = ticketRepository.findById(id);
        if (tick.isEmpty()) {
            return null;
        } else {
            return MessageMapper.mapToTicketDTO(tick.get());
        }
    }

    /**
     * Update a ticket.
     * 
     * @param id the ID of the ticket to update
     * @param ticketDTO the updated ticket data
     * @return the updated ticket, or null if not found
     */
    @Override
    public MessageDTO updateTicket(Long id, MessageDTO ticketDTO) {
        Optional<Message> tick = ticketRepository.findById(id);
        if (tick.isEmpty()) {
            return null;
        } else {
            ticketDTO.setId(tick.get().getId());
            return MessageMapper.mapToTicketDTO(ticketRepository.save(MessageMapper.mapToTicket(ticketDTO)));
        }
    }

    /**
     * Delete a ticket.
     * 
     * @param id the ID of the ticket to delete
     * @return the deleted ticket, or null if not found
     */
    @Override
    public MessageDTO deleteTicket(Long id) {
        Optional<Message> tick = ticketRepository.findById(id);
        if (tick.isEmpty()) {
            return null;
        } else {
            ticketRepository.deleteById(id);
            return MessageMapper.mapToTicketDTO(tick.get());
        }
    }

    /**
     * Retrieve a list of tickets by customer ID.
     * 
     * @param custId the customer ID to search for
     * @return a list of tickets for the given customer ID
     */
    @Override
    public List<MessageDTO> getByCustomerId(Long custId) {
        List<MessageDTO> msgDto = new ArrayList<>();
        List<Message> messages = ticketRepository.findAll();
        if (!messages.isEmpty()) {
            for (Message msg : messages) {
                if (custId != null && msg.getCustomerId() != null && custId.equals(msg.getCustomerId())) {
                    msgDto.add(MessageMapper.mapToTicketDTO(msg));
                }
            }
            return msgDto;
        } else {
            return msgDto;
        }
    }

    /**
     * Retrieve a list of tickets by admin ID.
     * 
     * @param adminId the admin ID to search for
     * @return a list of tickets for the given admin ID
     */
    @Override
    public List<MessageDTO> getByAdminId(Long adminId) {
        List<MessageDTO> msgDto = new ArrayList<>();
        List<Message> messages = ticketRepository.findAll();
        if (!messages.isEmpty()) {
            for (Message msg : messages) {
                if (adminId != null && msg.getAdminId() != null && adminId.equals(msg.getAdminId())) {
                    msgDto.add(MessageMapper.mapToTicketDTO(msg));
                }
            }
            return msgDto;
        } else {
            return msgDto;
        }
    }
}