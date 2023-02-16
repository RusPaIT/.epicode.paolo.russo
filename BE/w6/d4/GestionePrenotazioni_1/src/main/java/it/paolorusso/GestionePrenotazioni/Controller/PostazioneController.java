package it.paolorusso.GestionePrenotazioni.Controller;

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

import it.paolorusso.GestionePrenotazioni.entity.Edificio;
import it.paolorusso.GestionePrenotazioni.entity.Postazione;
import it.paolorusso.GestionePrenotazioni.service.EdificioService;
import it.paolorusso.GestionePrenotazioni.service.PostazioneService;

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
