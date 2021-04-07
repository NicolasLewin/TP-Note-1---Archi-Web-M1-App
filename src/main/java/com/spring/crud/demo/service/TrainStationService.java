package com.spring.crud.demo.service;


import java.util.List;

public interface TrainStationService {
	
	List<TrainStation> getAll();

	TrainStation getTrainStationById(int stationId);

	TrainStation save(TrainStation trainStation);
	
	TrainStation update(int id, TrainStation trainStation);

    void delete(int id);
}
