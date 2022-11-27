package com.apptorneo.Tournament.persistence;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.domain.repository.InscriptionRepositoryDTO;
import com.apptorneo.Tournament.persistence.crud.InscriptionCrudRepository;
import com.apptorneo.Tournament.persistence.entity.Inscription;
import com.apptorneo.Tournament.persistence.mapper.InscriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InscriptionRepository implements InscriptionRepositoryDTO {

    @Autowired
    InscriptionCrudRepository inscriptionCrudRepository;
    @Autowired
    InscriptionMapper mapper;


    @Override
    public List<InscriptionDTO> getAll() {
        List<Inscription> inscriptions = (List <Inscription>) inscriptionCrudRepository.findAll();
        return mapper.toInscriptionsDTO(inscriptions);
    }

    @Override
    public Optional<List<InscriptionDTO>> getByTournamentId(Long id) {
        Optional<List<Inscription>> inscriptions=  inscriptionCrudRepository.findBytournament(id);
        return inscriptions.map(i -> mapper.toInscriptionsDTO(i));
    }

    @Override
    public Optional<List<InscriptionDTO>> getByUserId(Long id) {
        Optional<List<Inscription>> inscriptions=  inscriptionCrudRepository.findByUser(id);
        return inscriptions.map(i -> mapper.toInscriptionsDTO(i));
    }


}
