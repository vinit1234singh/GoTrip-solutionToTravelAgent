package com.intellect.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intellect.crm.models.Users;


/**
 * Repository interface for the {@link Users} entity.
 * 
 * @author theerej
 */
public interface UserRepository extends JpaRepository<Users, Long> {
    
    /**
     * Find a user by their username.
     * 
     * @param userName the username to search for
     * @return the user with the given username, or null if not found
     */
    Users findByUserName(String userName);
}