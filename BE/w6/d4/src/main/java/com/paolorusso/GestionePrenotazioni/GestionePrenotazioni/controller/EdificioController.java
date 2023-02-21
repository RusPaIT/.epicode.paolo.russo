package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.entities.Edificio;
import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services.EdificioService;

import java.util.List;
import java.util.Optional;

@RestController
public class EdificioController {

    @Autowired
    private EdificioService edServ;

    @GetMapping(value = "/edifici", produces = MediaType.APPLICATION_JSON_VALUE)	
    public ResponseEntity<List<Edificio>> getEdifici() {
        List<Edificio> edifici = edServ.getAll();
        if (edifici.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(edifici, HttpStatus.OK);
    }
    
    @GetMapping("/edificio/{id}")
    public ResponseEntity<Optional<Edificio>> getEdificioById(@PathVariable("id") int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Optional<Edificio> edificio = edServ.getById(id);
        if (edificio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(edificio);
    }
    
    @GetMapping("edifici/page")
    public ResponseEntity<Object> getAll_page(Pageable pageable) {
        Page<Edificio> utenti = edServ.getAll_page(pageable);

        if( utenti.isEmpty() ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(utenti, HttpStatus.OK);
    }
    
    @PostMapping("/edificio")
    public ResponseEntity<String> addEdificio(@RequestBody Edificio edificio) {
    	edServ.insert(edificio);
        return ResponseEntity.status(HttpStatus.CREATED).body("Edificio inserito con successo");
    }
    
    @DeleteMapping("/edificio/{id}")
    public ResponseEntity<String> deleteEdificio(@PathVariable("id") int id) {
        try {
        	edServ.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Edificio eliminato con successo");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/edificio/{id}")
    public ResponseEntity<String> updateEdificio(@PathVariable int id, @RequestBody Edificio edificio) {
        Optional<Edificio> edificioOptional = edServ.getEdificioById(id);
        if (edificioOptional.isPresent()) {
            Edificio edificioToUpdate = edificioOptional.get();
            edificioToUpdate.setNome(edificio.getNome());
            edificioToUpdate.setIndirizzo(edificio.getIndirizzo());
            edificioToUpdate.setCitta(edificio.getCitta());
            edServ.insert(edificioToUpdate);
            return ResponseEntity.ok("Edificio aggiornato con successo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'edificio con ID " + id + " non è stato trovato");
        }
    }

}
