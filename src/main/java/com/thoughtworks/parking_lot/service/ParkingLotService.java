package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingLotService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    public Page<ParkingLot> findAllParkingLotsWithPage(int page,int pageSize) {
        return parkingLotRepository.findAll(PageRequest.of(page-1,pageSize));
    }

    public Optional<ParkingLot> findParkingLotsById(Integer id) {
        return parkingLotRepository.findById(id);
    }

    public ParkingLot updateParkingLotById(Integer id, ParkingLot parkingLot) {
        parkingLot.setId(id);
        return parkingLotRepository.saveAndFlush(parkingLot);
    }

    public Boolean deleteParkingLotById(Integer id) {
        parkingLotRepository.deleteById(id);
        return !parkingLotRepository.findById(id).isPresent();
    }
}
