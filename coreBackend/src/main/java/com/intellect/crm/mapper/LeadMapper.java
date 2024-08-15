package com.intellect.crm.mapper;

import com.intellect.crm.dto.LeadDTO;
import com.intellect.crm.models.Lead;

/**
 * Utility class for mapping between Lead entities and their corresponding Data Transfer Objects (DTOs).
 * 
 * @author theerej
 */
public class LeadMapper {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private LeadMapper(){}

    /**
     * Maps a Lead DTO to a Lead model entity.
     * 
     * @param leadDTO the Lead DTO to be mapped
     * @return the corresponding Lead model entity
     */
    public static Lead dtoToModel(LeadDTO leadDTO){
        return new Lead(leadDTO.getLeadId(), leadDTO.getUserId(), leadDTO.getNumberOfPackages());
    }

    /**
     * Maps a Lead model entity to a Lead DTO.
     * 
     * @param lead the Lead model entity to be mapped
     * @return the corresponding Lead DTO
     */
    public static LeadDTO modelToDto(Lead lead){
        return new LeadDTO(lead.getLeadId(), lead.getUserId(), lead.getNumberOfPackages());
    }
}
