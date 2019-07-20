package com.thoughtworks.parking_lot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
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

    public ParkingOrder(String carNumber, Date createdTime, Date closedTime) {
        this.carNumber = carNumber;
        this.createdTime = createdTime;
        this.closedTime = closedTime;
    }

    public ParkingOrder(String parkingLotName, String carNumber, Date createdTime, Date closedTime) {
        this.parkingLotName = parkingLotName;
        this.carNumber = carNumber;
        this.createdTime = createdTime;
        this.closedTime = closedTime;
    }
}
