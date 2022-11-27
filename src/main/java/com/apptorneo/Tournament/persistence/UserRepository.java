package com.apptorneo.Tournament.persistence;

import com.apptorneo.Tournament.domain.dto.UserDTO;
import com.apptorneo.Tournament.domain.repository.UserRepositoryDTO;
import com.apptorneo.Tournament.persistence.crud.UserCrudRepository;
import com.apptorneo.Tournament.persistence.entity.User;
import com.apptorneo.Tournament.persistence.mapper.UserMapper;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserRepositoryDTO {

    @Autowired
    UserCrudRepository userCrudRepository;
    @Autowired
    UserMapper mapper;
    @Override
    public List<UserDTO> getAll() {
        List<User> users = (List<User>) userCrudRepository.findAll();
        return  mapper.toUser(users);
    }

    @Override
    public Optional<UserDTO> getOne(Long id) {
        Optional<User> user = userCrudRepository.findById(id);
        return  user.map(u -> mapper.toUser(u));
    }

    @Override
    public Optional<UserDTO> getByUsernameAndPassword(String user, String pass) {
        Optional<User> u = userCrudRepository.findByUsernameAndPassword(user,pass);

        return  u.map(d -> mapper.toUser(d));
    }
}
