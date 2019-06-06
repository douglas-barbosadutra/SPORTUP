package it.contrader.usermicroservice.service.mapper;

import it.contrader.usermicroservice.domain.*;
import it.contrader.usermicroservice.service.dto.PlayerDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Player and its DTO PlayerDTO.
 */
@Mapper(componentModel = "spring", uses = {BiomedicalDataMapper.class, PerformanceMapper.class})
public interface PlayerMapper extends EntityMapper<PlayerDTO, Player> {

    @Mapping(source = "biomedicalData.id", target = "biomedicalDataId")
    @Mapping(source = "performance.id", target = "performanceId")
    PlayerDTO toDto(Player player);

    @Mapping(source = "biomedicalDataId", target = "biomedicalData")
    @Mapping(source = "performanceId", target = "performance")
    Player toEntity(PlayerDTO playerDTO);

    default Player fromId(Long id) {
        if (id == null) {
            return null;
        }
        Player player = new Player();
        player.setId(id);
        return player;
    }
}
