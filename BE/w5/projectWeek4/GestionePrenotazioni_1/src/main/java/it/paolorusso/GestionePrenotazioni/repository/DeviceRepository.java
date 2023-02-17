package it.paolorusso.GestionePrenotazioni.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.paolorusso.GestionePrenotazioni.entities.Role;

public interface DeviceRepository extends JpaRepository<Role, Integer>  {}
