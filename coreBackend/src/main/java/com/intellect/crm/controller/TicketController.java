package com.intellect.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.crm.dto.TicketDTO;
import com.intellect.crm.service.TicketServiceImpl;



/**
 * TicketController is a RESTful controller that handles CRUD operations for Ticket entities.
 * 
 * @author Renisha and Yash
 */
@RestController
@RequestMapping("/tickets")
@CrossOrigin("http://localhost:4200")
public class TicketController {

    /**
     * Autowired instance of TicketServiceImpl, which provides the business logic for Ticket operations.
     */
    @Autowired
    private TicketServiceImpl service;

    /**
     * Creates a new Ticket entity based on the provided TicketDTO.
     * 
     * @param ticketDTO the TicketDTO object containing the data to be saved
     * @return a ResponseEntity containing the created TicketDTO, with a HTTP status of 201 (CREATED)
     */
    @PostMapping("/create")
    public ResponseEntity<TicketDTO> createTicket(@RequestBody TicketDTO ticketDTO) {
        TicketDTO createdTicket = service.createTicket(ticketDTO);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all Ticket entities.
     * 
     * @return a ResponseEntity containing a list of TicketDTO objects, with a HTTP status of 200 (OK)
     */
    @GetMapping("/all")
    public ResponseEntity<List<TicketDTO>> getAllTickets() {
        List<TicketDTO> tickets = service.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    /**
     * Updates the status of a Ticket entity.
     * 
     * @param ticketId the ID of the Ticket to be updated
     * @param status the new status of the Ticket
     * @return a ResponseEntity containing the updated TicketDTO, with a HTTP status of 200 (OK)
     */
    @GetMapping("/update/{ticketId}/{status}")
    public ResponseEntity<TicketDTO> updateTicketStatus(@PathVariable Long ticketId, @PathVariable String status) {
        TicketDTO updatedTicket = service.updateTicketStatus(ticketId, status);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    /**
     * Retrieves a list of Ticket entities by Sender ID.
     * 
     * @param senderId the ID of the Sender
     * @return a ResponseEntity containing a list of TicketDTO objects, with a HTTP status of 200 (OK)
     */
    @GetMapping("/user/{senderId}")
    public ResponseEntity<List<TicketDTO>> getTicketsBySenderId(@PathVariable Long senderId) {
        List<TicketDTO> tickets = service.getBySenderId(senderId);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    /**
     * Retrieves a list of Ticket entities by Reciever ID.
     * 
     * @param recieverId the ID of the Reciever
     * @return a ResponseEntity containing a list of TicketDTO objects, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @GetMapping("recieve/{recieverId}")
    public ResponseEntity<List<TicketDTO>> getTicketsByRecieverId(@PathVariable Long recieverId) {
        List<TicketDTO> tickets = service.getByRecieverId(recieverId);
        if (tickets.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}