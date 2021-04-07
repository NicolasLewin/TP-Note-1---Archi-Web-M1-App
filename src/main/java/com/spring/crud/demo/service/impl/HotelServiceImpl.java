package com.spring.crud.demo.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.demo.model.Chambre;
import com.spring.crud.demo.model.Hotel;
import com.spring.crud.demo.model.Reservation;
import com.spring.crud.demo.repository.ChambreRepository;
import com.spring.crud.demo.repository.HotelRepository;
import com.spring.crud.demo.repository.ReservationRepository;
import com.spring.crud.demo.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private ReservationRepository reservationRepo;
	
	@Autowired
	private HotelRepository hotelRepo;
	
	@Autowired
	private ChambreRepository chambreRepo;


	public List<Chambre> getReservationFromLessCrowdedHotel(LocalDate date) {
		Map<Integer, Integer> nbChambreAvecResevationByHotel = new TreeMap<Integer, Integer>();
		Map<Integer, Integer> nbChambreTotalByHotel = new TreeMap<Integer, Integer>();

		List<Reservation> reservations = reservationRepo.getReservationsFromDate(date);

		// compute nb chambre by hotel with a reservation in given date
		for (Reservation r : reservations) {
			Hotel hotel = r.getChambre().getHotel();

			if (!nbChambreAvecResevationByHotel.containsKey(hotel.getIdHotel())) {
				nbChambreAvecResevationByHotel.put(hotel.getIdHotel(), 0);
			}

			nbChambreAvecResevationByHotel.merge(hotel.getIdHotel(), 1, Integer::sum);
			nbChambreTotalByHotel.put(hotel.getIdHotel(), hotel.getChambres().size());
		}

		// map with hotel id as value and occupation as key
		Map<Integer, Integer> hotelByOccupation = new TreeMap<Integer, Integer>();
		for (Integer i : nbChambreAvecResevationByHotel.keySet()) {
			int value = (nbChambreAvecResevationByHotel.get(i) / nbChambreTotalByHotel.get(i)) * 100;
			hotelByOccupation.put(value, i);
		}

		// getting at least 3 rooms from less crowded hotels
		List<Chambre> chambres = new ArrayList<Chambre>();
		for (Hotel h : hotelRepo.findAllById(hotelByOccupation.values() )) {
			if (chambres.size() >= 3)
				break;

			chambres.addAll(chambreRepo.getChambresWithoutReservationInDate(date));
		}

		return chambres;
	}

	@Override
	public Map<Integer, Integer> getOccupationByHotel(int indexMonth) {
		List<Reservation> reservations = reservationRepo.findAll();
		Map<Integer, Integer> occupationByHotelId = new TreeMap<Integer, Integer>();

		for (Reservation r : reservations) {
			int idHotel = r.getChambre().getHotel().getIdHotel();
			int totalChambre = r.getChambre().getHotel().getChambres().size();

			if (!occupationByHotelId.containsKey(r.getChambre().getHotel().getIdHotel())) {
				occupationByHotelId.put(idHotel, 0);
			}

			int nbDays = (int) (getDaysInMonthOfDateRange(indexMonth, r.getStartDate(), r.getEndDate()) / totalChambre)
					* 100;
			occupationByHotelId.merge(idHotel, nbDays, Integer::sum);

		}

		return occupationByHotelId;
	}

	/**
	 * Ce calcul suppose qu'une chambre ne peut pas etre reserve plus de 2 mois
	 * 
	 * @param month
	 * @param start
	 * @param end
	 * @return number of days between date range filtered by given month
	 */
	private long getDaysInMonthOfDateRange(int month, LocalDateTime start, LocalDateTime end) {
		LocalDateTime endOfMonth = start.with(TemporalAdjusters.lastDayOfMonth());

		// date deb et date fin le meme mois
		if (start.getMonthValue() == end.getMonthValue()) {
			return ChronoUnit.DAYS.between(start, end);
		}

		// le mois est celui de la date de debut
		if (start.getMonthValue() == month) {
			return ChronoUnit.DAYS.between(start, endOfMonth.plusDays(1));
		}

		// le mois est celui de la date de fin
		if (end.getMonthValue() == month) {
			LocalDateTime startOfMonth = end.with(TemporalAdjusters.firstDayOfMonth());
			return ChronoUnit.DAYS.between(startOfMonth, end);
		}

		return 0;
	}

}
