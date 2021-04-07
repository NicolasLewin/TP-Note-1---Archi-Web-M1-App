package com.spring.crud.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainStationRepository extends JpaRepository<TrainStation, Integer> {

    TrainStation findByName(String name);


}
