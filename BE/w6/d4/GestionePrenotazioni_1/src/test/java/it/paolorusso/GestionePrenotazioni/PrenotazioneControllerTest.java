package it.paolorusso.GestionePrenotazioni;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import it.paolorusso.GestionePrenotazioni.Controller.PrenotazioneController;

@SpringBootTest
class PrenotazioneControllerTest {

    @Autowired
    private PrenotazioneController controller;

    @Test
    void testGetPrenotazione_Italiano() throws Exception {
        ResponseEntity<String> response = controller.getLingua("italiano");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Regole di prenotazione in italiano...", response.getBody());
    }

    @Test
    void testGetPrenotazione_Inglese() throws Exception {
        ResponseEntity<String> response = controller.getLingua("inglese");
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Booking rules in English...", response.getBody());
    }

    @Test
    void testGetPrenotazione_LinguaNonSupportata() throws Exception {
        ResponseEntity<String> response = controller.getLingua("spagnolo");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Lingua non supportata: spagnolo", response.getBody());
    }
}
