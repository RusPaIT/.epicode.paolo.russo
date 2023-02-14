package it.paolorusso.GestionePrenotazioni.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrenotazioneController {
    
    private Map<String, String> prenotazioni = new HashMap<String, String>();

    public PrenotazioneController() {
        prenotazioni.put("italiano", "Regole di prenotazione in italiano...");
        prenotazioni.put("inglese", "Booking rules in English...");
    }

    @GetMapping("/prenotazione/{lingua}")
    public ResponseEntity<String> getPrenotazione(@PathVariable String lingua) {
    	String testo = prenotazioni.get(lingua.toLowerCase());
    	if (testo == null) {
    	    String customErrorMessage = "La lingua " + lingua + " non è supportata";
    	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customErrorMessage);
    	}
    	return ResponseEntity.ok().body(testo);
    }

}
