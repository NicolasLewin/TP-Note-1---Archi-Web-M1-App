package com.spring.crud.demo.repository;

import com.spring.crud.demo.model.TrainStation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainStationRepository extends JpaRepository<TrainStation, Integer> {

    TrainStation findByName(String name);


}
