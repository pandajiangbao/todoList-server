package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> findAllParkingLots(){
        return parkingLotRepository.findAll();
    }

    public Optional<ParkingLot> findParkingLotsById(String id){
        return parkingLotRepository.findById(id);
    }

    public Boolean deleteParkingLotById(String id){
        parkingLotRepository.deleteById(id);
        return !parkingLotRepository.findById(id).isPresent();
    }
}
