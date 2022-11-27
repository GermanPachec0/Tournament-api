package com.apptorneo.Tournament.persistence.crud;

import com.apptorneo.Tournament.persistence.entity.Tournament;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TournamentCrudRepository extends CrudRepository<Tournament,Long> {

    @Query (value ="SELECT * FROM tournament where  is_active = 1",nativeQuery = true)
    Optional<List<Tournament>> getActiveTorunaments();

    Optional<List<Tournament>> findBydatetime(Date date);
}
