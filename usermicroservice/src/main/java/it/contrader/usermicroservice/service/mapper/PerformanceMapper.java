package it.contrader.usermicroservice.service.mapper;

import it.contrader.usermicroservice.domain.*;
import it.contrader.usermicroservice.service.dto.PerformanceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Performance and its DTO PerformanceDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PerformanceMapper extends EntityMapper<PerformanceDTO, Performance> {



    default Performance fromId(Long id) {
        if (id == null) {
            return null;
        }
        Performance performance = new Performance();
        performance.setId(id);
        return performance;
    }
}
