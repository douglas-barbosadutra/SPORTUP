package it.contrader.usermicroservice.service.mapper;

import it.contrader.usermicroservice.domain.*;
import it.contrader.usermicroservice.service.dto.BiomedicalDataDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity BiomedicalData and its DTO BiomedicalDataDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BiomedicalDataMapper extends EntityMapper<BiomedicalDataDTO, BiomedicalData> {



    default BiomedicalData fromId(Long id) {
        if (id == null) {
            return null;
        }
        BiomedicalData biomedicalData = new BiomedicalData();
        biomedicalData.setId(id);
        return biomedicalData;
    }
}
