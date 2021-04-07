package com.spring.crud.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.crud.demo.model.Chambre;
import com.spring.crud.demo.model.Hotel;
import com.spring.crud.demo.model.Reservation;

/**
 * repository for chambre
 * @author mickaelgudin
 */
public interface ChambreRepository extends JpaRepository<Hotel, Integer> {
	
	
	@Query("SELECT c FROM Chambre c WHERE c.idChambre NOT IN(SELECT r.chambre.idChambre FROM Reservation r WHERE r.startDate <> :date) ")
	public List<Chambre> getChambresWithoutReservationInDate(@Param("date") LocalDate date);

}
