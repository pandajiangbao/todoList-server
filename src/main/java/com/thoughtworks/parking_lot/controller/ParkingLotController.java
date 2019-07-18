package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return parkingLotService.deleteById(id)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
