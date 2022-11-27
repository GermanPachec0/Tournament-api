package com.apptorneo.Tournament.domain.repository;

import com.apptorneo.Tournament.domain.dto.TournamentDTO;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TournamentRepositoryDTO {

    List<TournamentDTO> getAll();
    Optional<List<TournamentDTO>> getByDateTime(Date date);
    Optional<List<TournamentDTO>> getActiveTorunaments();
}
