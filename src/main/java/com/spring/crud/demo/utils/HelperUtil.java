package com.spring.crud.demo.utils;


import java.util.Arrays;

import java.util.List;

public class HelperUtil {
	DataFactory df = new DataFactory();
	
	
    public HelperUtil() {
    }


    public List<TrainStation> getTrainsStations() {
    	TrainStation versailles = df.getTrainStationVersaillesChantiers();
    	TrainStation montparnasse = df.getTrainStationMontparnasse();
    	LineTrainStation lineN = df.getLineN();
    	
    	df.setLineforTrainStation(lineN, versailles);
    	df.setLineforTrainStation(lineN, montparnasse);
    	
    	return Arrays.asList(versailles, montparnasse, df.getTrainStationLaDefense());
    }
    	   

}
