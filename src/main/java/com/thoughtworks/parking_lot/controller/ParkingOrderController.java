package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingOrder;
import com.thoughtworks.parking_lot.service.ParkingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-orders")
public class ParkingOrderController {
    @Autowired
    private ParkingOrderService parkingOrderService;
    @PostMapping()
    public ResponseEntity createOrder(@RequestBody ParkingOrder parkingOrder) {
        return parkingOrderService.createOrder(parkingOrder)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
