package com.paolorusso.GestioneDispositiviAziendali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paolorusso.GestioneDispositiviAziendali.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
