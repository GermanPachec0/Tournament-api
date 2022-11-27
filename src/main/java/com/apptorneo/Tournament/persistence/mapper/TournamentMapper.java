package com.apptorneo.Tournament.persistence.mapper;

import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.persistence.entity.Tournament;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {
        @Mappings({
                @Mapping(source ="idTournament",target ="tournamentId"),
                @Mapping(source ="datetime",target ="date_time"),
                @Mapping(source ="url_img",target ="urlImg" )

        })
        TournamentDTO toTournament(Tournament tournament);
        List<TournamentDTO> toTournaments(List<Tournament> tournaments);

        @InheritInverseConfiguration
        Tournament toTournament(TournamentDTO tournamentDTO);
}
