package com.apptorneo.Tournament.domain.service;

import com.apptorneo.Tournament.domain.dto.UserDTO;
import com.apptorneo.Tournament.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll(){
        return  userRepository.getAll();
    }
    public Optional<UserDTO> getOne(Long id){
        return  userRepository.getOne(id);
    }
    public Optional<UserDTO> getByUsernameAndPassword(String user, String pass){
        return userRepository.getByUsernameAndPassword(user,pass);
    }

}
