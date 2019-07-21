package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import com.thoughtworks.parking_lot.repository.ParkingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ParkingOrderService {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private ParkingOrderRepository parkingOrderRepository;

    public Boolean createOrder(ParkingOrder parkingOrder) {
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingOrder.getParkingLotName());
        parkingOrder.setParkingLotId(parkingLot.getId());
        parkingOrder.setCreatedTime(new Date());
        parkingOrder.setClosedTime(new Date());
        try {
            parkingOrderRepository.saveAndFlush(parkingOrder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    public ParkingOrder closeOrder(Integer id) {
        ParkingOrder parkingOrder = parkingOrderRepository.findById(id).get();
        parkingOrder.setClosedTime(new Date());
        parkingOrder.setStatus(false);
        try {
            return parkingOrderRepository.saveAndFlush(parkingOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
