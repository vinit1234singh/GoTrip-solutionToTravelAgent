package com.intellect.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellect.crm.models.Lead;


/**
 * Repository interface for the {@link Lead} entity.
 * 
 * @author theerej
 */
public interface LeadRepo extends JpaRepository<Lead, Long> {

    /**
     * Retrieves a {@link Lead} entity by its associated user ID.
     * 
     * @param userId the ID of the user to search for
     * @return the matching {@link Lead} entity, or null if no match is found
     */
    Lead findByUserId(long userId);
}
