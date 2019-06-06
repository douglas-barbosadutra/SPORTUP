package it.contrader.fitmicroservice.service.mapper;

import it.contrader.fitmicroservice.domain.*;
import it.contrader.fitmicroservice.service.dto.TrainingCardDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity TrainingCard and its DTO TrainingCardDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TrainingCardMapper extends EntityMapper<TrainingCardDTO, TrainingCard> {



    default TrainingCard fromId(Long id) {
        if (id == null) {
            return null;
        }
        TrainingCard trainingCard = new TrainingCard();
        trainingCard.setId(id);
        return trainingCard;
    }
}
