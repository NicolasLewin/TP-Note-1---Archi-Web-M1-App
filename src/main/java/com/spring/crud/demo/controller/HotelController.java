package com.spring.crud.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.demo.model.Chambre;
import com.spring.crud.demo.repository.HotelRepository;
import com.spring.crud.demo.repository.ReservationRepository;
import com.spring.crud.demo.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	HotelRepository repoHotel;
	
	@Autowired
	ReservationRepository repoReservation;
	
	@Autowired
	HotelService service;
	
	@GetMapping("/get-total-ca")
	/**
	 * get CA (for total or for a given month), the month isn't required
	 * @param indexMonth
	 * @return
	 */
	public double getCa(@RequestParam(required = false) int indexMonth) {
		
		if(indexMonth != 0 && indexMonth >= 1 && indexMonth <= 12 && indexMonth >= LocalDateTime.now().getMonthValue() ) {
			//a month was given so we only return ca for the given month
			repoReservation.getTotalCAForMonth(indexMonth);
		}
		
		//else return total ca
		return repoReservation.getTotalCA();
	}
	
	@GetMapping("/occupations")
	public Map<Integer, Integer> getDaysOccuppesForMonth(@RequestParam int indexMonth) {
		if(indexMonth != 0 && indexMonth >= 1 && indexMonth <= 12 && indexMonth >= LocalDateTime.now().getMonthValue() ) {
			return service.getOccupationByHotel(indexMonth);
		}
		
		return null;
	}
	
	@GetMapping("/suggestions")
	public List<Chambre> getSuggestionRooms(@RequestParam LocalDate date) {
		return service.getReservationFromLessCrowdedHotel(date);
	}
}
