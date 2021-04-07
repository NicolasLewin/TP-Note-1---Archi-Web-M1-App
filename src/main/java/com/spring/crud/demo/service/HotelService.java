package com.spring.crud.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.spring.crud.demo.model.Chambre;

public interface HotelService {

	Map<Integer, Integer> getOccupationByHotel(int indexMonth);
	public List<Chambre> getReservationFromLessCrowdedHotel(LocalDate date);
}
