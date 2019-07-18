package com.thoughtworks.parking_lot.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ParkingLot {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(nullable = false)
    private String name;
    private Integer capacity;
    private String location;

    public ParkingLot(String name, Integer capacity, String location) {
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }
}
