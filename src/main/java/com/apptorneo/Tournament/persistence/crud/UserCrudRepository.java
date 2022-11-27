package com.apptorneo.Tournament.persistence.crud;
import com.apptorneo.Tournament.persistence.entity.Tournament;
import com.apptorneo.Tournament.persistence.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface UserCrudRepository extends CrudRepository<User,Long> {

    @Query(value ="SELECT * FROM user where username = :user and password = :pass",nativeQuery = true)
    Optional<User> findByUsernameAndPassword(String user, String pass);

}
