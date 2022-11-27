package com.apptorneo.Tournament.web.controller;

import com.apptorneo.Tournament.domain.dto.TournamentDTO;
import com.apptorneo.Tournament.domain.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tournaments")
@CrossOrigin(origins = "http://localhost:4200")

public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @GetMapping("")
    public ResponseEntity<List<TournamentDTO>> getAll() {

        if (!tournamentService.getAll().isEmpty()) {
            return new ResponseEntity<>(tournamentService.getAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/date/{date}")
    public ResponseEntity<List<TournamentDTO>> getByDateTime(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){

        return tournamentService.getByDateTime(date).map(tour -> new ResponseEntity<>(tour,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/isActive")
    public ResponseEntity<List<TournamentDTO>> getActive(){
        return tournamentService.getActiveTorunaments().map(tour -> new ResponseEntity<>(tour,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}

