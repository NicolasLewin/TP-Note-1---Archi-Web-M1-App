package com.spring.crud.demo.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.demo.repository.TrainStationRepository;
import com.spring.crud.demo.service.TrainStationService;

@Service
public class TrainStationServiceImpl implements TrainStationService {

	@Autowired
	private TrainStationRepository repository;
	
	@PersistenceContext
	private EntityManager entityManger;

	@Override
	public List<TrainStation> getAll() {
		return repository.findAll();
	}

	@Override
	public TrainStation getTrainStationById(int trainStationId) {
		List<TrainStation> trainStations = repository.findAll();
		for (TrainStation trainStation : trainStations) {
			if (trainStationId == trainStation.getTrainStationId())
				return trainStation;
		}
		return null;
	}

	@Override
	public TrainStation save(TrainStation trainStation) {
		return repository.save(trainStation);
	}

	@Override
	public TrainStation update(int id, TrainStation trainStation) {
		if(!repository.existsById(id) ) return null;
    	
		trainStation.setTrainStationId(id);
        return repository.save(trainStation);
	}

	@Override
	public void delete(int id) {
		if(repository.existsById(id) ) {
			repository.deleteById(id);
		}
	}

}
