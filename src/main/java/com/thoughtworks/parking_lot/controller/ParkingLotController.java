package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(parkingLotService.findAllParkingLots());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return parkingLotService.deleteParkingLotById(id)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
