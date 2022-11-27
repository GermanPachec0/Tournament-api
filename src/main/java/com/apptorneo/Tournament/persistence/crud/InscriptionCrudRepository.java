package com.apptorneo.Tournament.persistence.crud;

import com.apptorneo.Tournament.persistence.entity.Inscription;
import com.apptorneo.Tournament.persistence.entity.Tournament;
import com.apptorneo.Tournament.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface InscriptionCrudRepository extends CrudRepository<Inscription,Long> {

    @Query(value = "Select * FROM inscription where id_tournament = :id",nativeQuery = true)
    Optional<List<Inscription>> findBytournament(Long id);

    @Query(value = "Select * FROM inscription where id_user = :id",nativeQuery = true)
    Optional<List<Inscription>> findByUser(Long id);

}
