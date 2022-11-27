package com.apptorneo.Tournament.web.controller;

import com.apptorneo.Tournament.domain.dto.UserDTO;
import com.apptorneo.Tournament.domain.service.UserServices;
import com.apptorneo.Tournament.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAll(){
        return  new ResponseEntity<>(userServices.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<UserDTO> getOne(@PathVariable("id") long id){
        return userServices.getOne(id).map(u -> new ResponseEntity<>(u,HttpStatus.OK))
                .orElse( new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserDTO> getByUsernameAndPassword(@RequestBody UserDTO userDTO){

        return userServices.getByUsernameAndPassword( userDTO.getUser(),userDTO.getPassword())
                .map(u -> new ResponseEntity<>(u,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
