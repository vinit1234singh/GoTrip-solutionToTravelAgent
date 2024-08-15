package com.intellect.crm.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.intellect.crm.models.Ticket;


/**
 * Repository interface for the {@link Ticket} entity.
 * 
 * @author renisha and yash
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // No custom methods defined
}
