package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> findAllParkingLots(){
        return parkingLotRepository.findAll();
    }

    public Boolean deleteParkingLotById(String id){
        parkingLotRepository.deleteById(id);
        return !parkingLotRepository.findById(id).isPresent();
    }
}
