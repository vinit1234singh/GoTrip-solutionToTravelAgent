package com.intellect.crm.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intellect.crm.dto.TicketDTO;
import com.intellect.crm.mapper.TicketMapper;
import com.intellect.crm.models.Ticket;
import com.intellect.crm.repo.TicketRepository;
import com.intellect.crm.service.inter.TicketService;
/**
 * Implementation of the {@link TicketService} interface.
 * 
 * @author renisha and yash
 */
@Service
public class TicketServiceImpl implements TicketService {

    /**
     * Autowired instance of the {@link TicketRepository} interface.
     */
    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Create a new ticket.
     * 
     * @param ticketDTO the ticket data to create
     * @return the created ticket
     */
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = TicketMapper.toEntity(ticketDTO);
        return TicketMapper.toDTO(ticketRepository.save(ticket));
    }

    /**
     * Update the status of a ticket.
     * 
     * @param ticketId the ID of the ticket to update
     * @param status the new status of the ticket
     * @return the updated ticket, or null if not found
     */
    public TicketDTO updateTicketStatus(Long ticketId, String status) {
        Optional<Ticket> ticketOptional = ticketRepository.findById(ticketId);
        if (!ticketOptional.isPresent()) {
            return null;
        }
        Ticket ticket = ticketOptional.get();
        ticket.setStatus(status);

        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketMapper.toDTO(updatedTicket);
    }

    /**
     * Retrieve a list of all tickets.
     * 
     * @return a list of all tickets
     */
    public List<TicketDTO> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream().map(TicketMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * Retrieve a list of tickets by user ID.
     * 
     * @param userId the user ID to search for
     * @return a list of tickets for the given user ID
     */
    @Override
    public List<TicketDTO> getTicketsByUserId(Long userId) {
        Optional<Ticket> tickets = ticketRepository.findById(userId);
        return tickets.stream().map(TicketMapper::toDTO).collect(Collectors.toList());
    }

    /**
     * Retrieve a list of tickets by sender ID.
     * 
     * @param senderId the sender ID to search for
     * @return a list of tickets for the given sender ID
     */
    @Override
    public List<TicketDTO> getBySenderId(Long senderId) {
        List<TicketDTO> ticketDto = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findAll();
        if (!tickets.isEmpty()) {
            for (Ticket ticket : tickets) {
                if (senderId!= null && ticket.getSenderId()!= null && senderId.equals(ticket.getSenderId())) {
                    ticketDto.add(TicketMapper.toDTO(ticket));
                }
            }
            return ticketDto;
        } else {
            return ticketDto;
        }
    }

    /**
     * Retrieve a list of tickets by receiver ID.
     * 
     * @param recieverId the receiver ID to search for
     * @return a list of tickets for the given receiver ID
     */
    @Override
    public List<TicketDTO> getByRecieverId(Long recieverId) {
        List<TicketDTO> ticketDto = new ArrayList<>();
        List<Ticket> tickets = ticketRepository.findAll();
        if (!tickets.isEmpty()) {
            for (Ticket ticket : tickets) {
                if (recieverId!= null && ticket.getRecieverId()!= null && recieverId.equals(ticket.getRecieverId())) {
                    ticketDto.add(TicketMapper.toDTO(ticket));
                }
            }
            return ticketDto;
        } else {
            return ticketDto;
        }
    }
}