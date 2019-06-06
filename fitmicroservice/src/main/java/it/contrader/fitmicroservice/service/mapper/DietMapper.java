package it.contrader.fitmicroservice.service.mapper;

import it.contrader.fitmicroservice.domain.*;
import it.contrader.fitmicroservice.service.dto.DietDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Diet and its DTO DietDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DietMapper extends EntityMapper<DietDTO, Diet> {



    default Diet fromId(Long id) {
        if (id == null) {
            return null;
        }
        Diet diet = new Diet();
        diet.setId(id);
        return diet;
    }
}
