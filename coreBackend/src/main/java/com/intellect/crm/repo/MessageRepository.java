package com.intellect.crm.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intellect.crm.models.Message;

/**

 * Repository interface for the {@link Message} entity.

 * 

 * @author vishal and tanmay

 */

 @Repository

 public interface MessageRepository extends JpaRepository<Message, Long> {
 
     // No custom methods defined
 
 }
