package com.intellect.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intellect.crm.dto.MessageDTO;
import com.intellect.crm.service.inter.MessageService;

/**
 * MessageController is a RESTful controller that handles CRUD operations for Message entities.
 * 
 * @author Tanmay and Vishal
 */
@RestController
@RequestMapping("/api/messages")
@CrossOrigin("http://localhost:4200")
public class MessageController {

    /**
     * Autowired instance of MessageService, which provides the business logic for Message operations.
     */
    @Autowired
    private MessageService ticketService;

    /**
     * Creates a new Message entity based on the provided MessageDTO.
     * 
     * @param ticketDTO the MessageDTO object containing the data to be saved
     * @return a ResponseEntity containing the created MessageDTO, with a HTTP status of 201 (CREATED)
     */
    @PostMapping
    public ResponseEntity<MessageDTO> addTicket(@RequestBody MessageDTO ticketDTO) {
        MessageDTO tick = ticketService.addTicket(ticketDTO);
        return new ResponseEntity<>(tick, HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of all Message entities.
     * 
     * @return a ResponseEntity containing a list of MessageDTO objects, with a HTTP status of 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<MessageDTO>> getAllTickets() {
        List<MessageDTO> messages = ticketService.getAllTickets();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    /**
     * Retrieves a Message entity by ID.
     * 
     * @param id the ID of the Message to be retrieved
     * @return a ResponseEntity containing the MessageDTO, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getTicketById(@PathVariable Long id) {
        MessageDTO tickDTO = ticketService.getTicketById(id);
        if (tickDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
    }

    /**
     * Updates an existing Message entity based on the provided MessageDTO.
     * 
     * @param id the ID of the Message to be updated
     * @param ticketDTO the MessageDTO object containing the updated data
     * @return a ResponseEntity containing the updated MessageDTO, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDTO> updateTicket(@PathVariable Long id, @RequestBody MessageDTO ticketDTO) {
        MessageDTO tickDto = ticketService.updateTicket(id, ticketDTO);
        if (tickDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickDto, HttpStatus.OK);
    }

    /**
     * Deletes a Message entity by ID.
     * 
     * @param id the ID of the Message to be deleted
     * @return a ResponseEntity containing the deleted MessageDTO, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteTicket(@PathVariable Long id) {
        MessageDTO tickDto = ticketService.deleteTicket(id);
        if (tickDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickDto, HttpStatus.OK);
    }

    /**
     * Retrieves a list of Message entities by Admin ID.
     * 
     * @param adminId the ID of the Admin
     * @return a ResponseEntity containing a list of MessageDTO objects, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<MessageDTO>> getByAdminId(@PathVariable Long adminId) {
        List<MessageDTO> msglist = ticketService.getByAdminId(adminId);
        if (msglist.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(msglist, HttpStatus.OK);
    }

    /**
     * Retrieves a list of Message entities by Customer ID.
     * 
     * @param custId the ID of the Customer
     * @return a ResponseEntity containing a list of MessageDTO objects, with a HTTP status of 200 (OK) if found, or 404 (NOT_FOUND) if not found
     */
    @GetMapping("/cust/{custId}")
    public ResponseEntity<List<MessageDTO>> getByCustId(@PathVariable Long custId) {
        List<MessageDTO> msglist = ticketService.getByCustomerId(custId);
        if (msglist.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(msglist, HttpStatus.OK);
    }
}