package com.apptorneo.Tournament.domain.repository;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.domain.dto.UserDTO;
import com.apptorneo.Tournament.persistence.entity.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepositoryDTO {
    List<UserDTO> getAll();
    Optional<UserDTO> getOne(Long id);
    Optional<UserDTO> getByUsernameAndPassword(String user, String pass);
}
