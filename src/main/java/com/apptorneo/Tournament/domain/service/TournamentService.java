package com.apptorneo.Tournament.domain.service;

import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.persistence.TournamentRepository;
import com.apptorneo.Tournament.web.controller.TournamentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public List<TournamentDTO> getAll(){
            return  tournamentRepository.getAll();
    }

    public  Optional<List<TournamentDTO>> getByDateTime(Date date){
        return  tournamentRepository.getByDateTime(date);

    }

    public Optional<List<TournamentDTO>> getActiveTorunaments(){
        return tournamentRepository.getActiveTorunaments();
    }


}
