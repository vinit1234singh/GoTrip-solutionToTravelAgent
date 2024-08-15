package com.intellect.crm.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intellect.crm.models.Admin;

/**
 * Repository interface for the {@link Admin} entity.
 * 
 * @author vinit
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    /**
     * Retrieves an {@link Admin} entity by its email address.
     * 
     * @param email the email address to search for
     * @return an {@link Optional} containing the matching {@link Admin} entity, or an empty {@link Optional} if no match is found
     */
    Optional<Admin> findByEmail(String email);
}