package com.intellect.crm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for Lead entities.
 * 
 * @author theerej
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class LeadDTO {

    /**
     * Unique identifier for the Lead entity.
     */
    private long leadId;

    /**
     * User ID associated with the Lead.
     */
    private long userId;

    /**
     * Number of packages associated with the Lead.
     */
    private long numberOfPackages;
}
