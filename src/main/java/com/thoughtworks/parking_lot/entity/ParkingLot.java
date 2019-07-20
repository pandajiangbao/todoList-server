package com.thoughtworks.parking_lot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingLot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer capacity;

    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingLotId")
    private List<ParkingOrder> parkingOrders;

    public ParkingLot(String name, Integer capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }
}
