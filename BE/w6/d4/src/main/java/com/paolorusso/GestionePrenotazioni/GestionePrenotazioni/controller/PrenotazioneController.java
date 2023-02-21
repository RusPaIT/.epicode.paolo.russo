package com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.GestionePrenotazioni.GestionePrenotazioni.services.PrenotazioneService;

@RestController
@RequestMapping("/prenotazione")
public class PrenotazioneController {

    private final PrenotazioneService prenServ;

    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenServ = prenotazioneService;
    }

    @GetMapping("/{lingua}")
    public ResponseEntity<String> getLingua(@PathVariable String lingua) {
        String testo = prenServ.getLingua(lingua);
        if (testo == null) {
            String customErrorMessage = "La lingua " + lingua + " non è supportata";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorMessage);
        }
        return ResponseEntity.ok().body(testo);
    }

}
