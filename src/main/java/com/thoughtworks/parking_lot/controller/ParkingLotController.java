package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
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

    @GetMapping(params = {"page","pageSize"})
    public ResponseEntity findAllWithPage(@RequestParam Integer page,@RequestParam Integer pageSize) {
        return ResponseEntity.ok(parkingLotService.findAllParkingLotsWithPage(page,pageSize));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id) {
        return ResponseEntity.ok(parkingLotService.findParkingLotsById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@PathVariable Integer id,@RequestBody ParkingLot parkingLot) {
        return ResponseEntity.ok(parkingLotService.updateParkingLotById(id,parkingLot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        return parkingLotService.deleteParkingLotById(id)?ResponseEntity.ok().build():ResponseEntity.badRequest().build();
    }
}
