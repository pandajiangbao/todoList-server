package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    public Boolean deleteById(String id){
        parkingLotRepository.deleteById(id);
        return !parkingLotRepository.findById(id).isPresent();
    }
}
