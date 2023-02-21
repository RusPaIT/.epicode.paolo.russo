package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Edificio;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Postazione;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services.EdificioService;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services.PostazioneService;

@RestController
public class PostazioneController {
	
    @Autowired
    private PostazioneService posServ;
    
    @Autowired
    private EdificioService edServ;
    
    @GetMapping("/postazioni")
    public List<Postazione> getAllPostazioni() {
        return posServ.getAll();
    }
	
    @PostMapping("/postazione")
    public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione postazione,
                                                       @RequestParam Integer edificioId) {
        Optional<Edificio> edificio = edServ.getById(edificioId);
        if (edificio.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Edificio x = edificio.get();
        postazione.setEdificio(x);
        Postazione post = posServ.insert(postazione);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

}
