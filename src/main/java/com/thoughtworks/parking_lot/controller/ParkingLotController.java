package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/parking-lots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping()
    public ResponseEntity findAll() {
        return ResponseEntity.ok(parkingLotService.findAllParkingLots());
    }

    @GetMapping(params = {"page","pageSize"})
    public ResponseEntity findAllWithPage(@RequestParam Integer page,@RequestParam(defaultValue = "15") Integer pageSize) {
        List<ParkingLot> parkingLots=parkingLotService.findAllParkingLots();
        parkingLots=parkingLots.stream().skip((page-1)*pageSize).limit(pageSize).collect(Collectors.toList());
        return ResponseEntity.ok(parkingLots);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        return parkingLotService.deleteParkingLotById(id)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
