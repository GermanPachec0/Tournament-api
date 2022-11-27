package com.apptorneo.Tournament.web.controller;

import com.apptorneo.Tournament.domain.dto.InscriptionDTO;
import com.apptorneo.Tournament.domain.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;

    @GetMapping("")
    public  ResponseEntity<List<InscriptionDTO>> getAll(){
        return new ResponseEntity<>(inscriptionService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/tournament/{id}")
    public  ResponseEntity<List<InscriptionDTO>> getByTournamentId(@PathVariable("id") Long id) {
        return  inscriptionService.getByTournamentId(id).map(i -> new ResponseEntity<>(i,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/user/{id}")
    public  ResponseEntity<List<InscriptionDTO>> getByUserId(@PathVariable("id") Long id) {
        return  inscriptionService.getByUserId(id).map(i -> new ResponseEntity<>(i,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
