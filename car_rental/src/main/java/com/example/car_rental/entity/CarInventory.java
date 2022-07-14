package com.example.car_rental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarInventory {

    @Id
    @Size(min = 10, max = 10)
    private String carRegNum;
    private String carType;
    private String carModel;
    private int carCostPerDay;

    private boolean carAvailablity;

    @OneToOne(mappedBy = "bookedcarRegNum")
    @JsonIgnore
    private Booking bookingId;

    @OneToOne(mappedBy = "reservedcarRegNum")
    @JsonIgnore
    private Reservation reservingId;
}

