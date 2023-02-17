package com.paolorusso.GestioneDispositiviAziendali.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.GestioneDispositiviAziendali.entities.Device;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceStatus;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceType;
import com.paolorusso.GestioneDispositiviAziendali.repository.DeviceRepository;
import com.paolorusso.GestioneDispositiviAziendali.service.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {

	@Autowired
	private DeviceService deServ;

	@Autowired
	private DeviceRepository deRepo;

	@GetMapping
	public ResponseEntity<List<Device>> getDevices() {
		List<Device> devices = deServ.getAll();
		if (devices.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(devices, HttpStatus.OK);
	}

	@GetMapping("type/{type}")
	public ResponseEntity<List<Device>> findByType(@PathVariable DeviceType type) {
		List<Device> devices = deRepo.findByType(type);
		if (devices.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(devices);
		}
	}

	@GetMapping("status/{status}")
	public ResponseEntity<List<Device>> findByStatus(@PathVariable DeviceStatus status) {
		List<Device> devices = deRepo.findByStatus(status);
		if (devices.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(devices);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Device> updateStatusDevice(@PathVariable(value = "id") Integer deviceId,
	                                           @RequestBody Device deviceDetails) {
	    Optional<Device> optionalDevice = deRepo.findById(deviceId);

	    if (optionalDevice.isPresent()) {
	        Device device = optionalDevice.get();

	        if (deviceDetails.getStatus() != null) {
	            device.setStatus(deviceDetails.getStatus());
	        }

	        device = deRepo.save(device);

	        return ResponseEntity.ok(device);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteDevice(@PathVariable int id) {
	    Optional<Device> optionalDevice = deRepo.findById(id);
	    if (!optionalDevice.isPresent()) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    deRepo.delete(optionalDevice.get());
	    return ResponseEntity.noContent().build();
	}

}
