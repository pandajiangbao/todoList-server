package com.thoughtworks.parking_lot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ParkingOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String parkingLotName;

    private String carNumber;

    private Date createdTime;

    private Date closedTime;

    private Boolean status;

    private Integer parkingLotId;

    public ParkingOrder(String parkingLotName, String carNumber) {
        this.parkingLotName = parkingLotName;
        this.carNumber = carNumber;
    }

    public ParkingOrder(String parkingLotName, String carNumber, Date createdTime, Date closedTime) {
        this.parkingLotName = parkingLotName;
        this.carNumber = carNumber;
        this.createdTime = createdTime;
        this.closedTime = closedTime;
    }
}
