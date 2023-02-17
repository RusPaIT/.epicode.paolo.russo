package it.paolorusso.GestionePrenotazioni.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.paolorusso.GestionePrenotazioni.entities.Device;
import it.paolorusso.GestionePrenotazioni.repository.DeviceRepository;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

//    public void insert(Device d) {
//        deviceRepository.save(d);
//        System.out.println("Dispositivo inserito con successo");
//    }
//
//    public List<Device> getAll() {
//        return deviceRepository.findAll();
//    }
//
//    public Optional<Device> getById(int id) {
//        return deviceRepository.findById(id);
//    }

    public void stampaLista(List<Device> d) {
        for(Device di : d) {
            System.out.println(di);
        }
    }
}