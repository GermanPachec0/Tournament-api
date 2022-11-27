package com.apptorneo.Tournament.persistence;

import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.domain.repository.TournamentRepositoryDTO;
import com.apptorneo.Tournament.persistence.crud.TournamentCrudRepository;
import com.apptorneo.Tournament.persistence.entity.Tournament;
import com.apptorneo.Tournament.persistence.mapper.TournamentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TournamentRepository implements TournamentRepositoryDTO {
    @Autowired
    private TournamentCrudRepository tournamentCrudRepository;

    @Autowired
    private TournamentMapper mapper;

    @Override
    public List<TournamentDTO> getAll() {
        List<Tournament> tournaments = (List<Tournament>) tournamentCrudRepository.findAll();
        return mapper.toTournaments(tournaments);
    }

    @Override
    public Optional<List<TournamentDTO>> getByDateTime(Date date) {
       Optional<List<Tournament>> tournaments = tournamentCrudRepository.findBydatetime(date);
        return  tournaments.map(t -> mapper.toTournaments(t));
    }

    @Override
    public Optional<List<TournamentDTO>> getActiveTorunaments() {
        Optional<List<Tournament>> tournaments = tournamentCrudRepository.getActiveTorunaments();
        return  tournaments.map(t -> mapper.toTournaments(t));
    }


}
