package com.paolorusso.GestioneDispositiviAziendali.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.paolorusso.GestioneDispositiviAziendali.entities.Device;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceStatus;
import com.paolorusso.GestioneDispositiviAziendali.enums.DeviceType;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
	
	  @Query(
			  nativeQuery = true,
			  value = "SELECT * FROM Device WHERE type = :type"
			  )
	    List<Device> findByType(@Param("type") DeviceType type);
	  
	  @Query(
			  nativeQuery = true,
			  value = "SELECT * FROM Device WHERE status = :status"
			  )
	    List<Device> findByStatus(@Param("status") DeviceStatus status);
}
