package com.apptorneo.Tournament.domain.service;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.persistence.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    InscriptionRepository inscriptionRepository;

    public  List<InscriptionDTO> getAll() {
        return inscriptionRepository.getAll();
    }

    public Optional<List<InscriptionDTO>> getByTournamentId(Long id) {
        return  inscriptionRepository.getByTournamentId(id);
    }
    public Optional<List<InscriptionDTO>> getByUserId(Long id) {

        return inscriptionRepository.getByUserId(id);
    }

}
