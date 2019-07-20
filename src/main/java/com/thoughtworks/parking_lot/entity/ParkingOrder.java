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

    private String carNumber;

    private Date createdTime;

    private Date closedTime;

    private Boolean status;

    public ParkingOrder(String carNumber, Date createdTime, Date closedTime) {
        this.carNumber = carNumber;
        this.createdTime = createdTime;
        this.closedTime = closedTime;
    }

    public ParkingOrder(String carNumber, Date createdTime, Date closedTime, Boolean status) {
        this.carNumber = carNumber;
        this.createdTime = createdTime;
        this.closedTime = closedTime;
        this.status = status;
    }
}
