package com.apptorneo.Tournament.domain.repository;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.domain.dto.TournamentDTO;

import java.util.List;
import java.util.Optional;

public interface InscriptionRepositoryDTO {

    List<InscriptionDTO> getAll();
    Optional<List<InscriptionDTO>> getByTournamentId(Long id);
    Optional<List<InscriptionDTO>> getByUserId(Long id);

}
