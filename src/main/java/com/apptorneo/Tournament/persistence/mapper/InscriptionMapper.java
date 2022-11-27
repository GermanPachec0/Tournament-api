package com.apptorneo.Tournament.persistence.mapper;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.persistence.entity.Inscription;
import com.apptorneo.Tournament.persistence.entity.Tournament;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {TournamentMapper.class,UserMapper.class})

public interface InscriptionMapper {

    @Mappings({
            @Mapping(source = "user",target = "userDTO"),
            @Mapping(source = "tournament",target = "tournamentDTO"),

    })
    InscriptionDTO toInscriptionDTO(Inscription inscription);
    List<InscriptionDTO> toInscriptionsDTO(List<Inscription> inscriptions);

    @InheritInverseConfiguration
    Inscription toInscription(InscriptionDTO inscriptionDTO);

}
