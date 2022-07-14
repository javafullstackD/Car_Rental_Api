package com.example.car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reservingId;

    @Temporal(TemporalType.DATE)
    private Date reservingStartDate;

    @Temporal(TemporalType.DATE)
    private Date reservingEndDate;

    private int reservingCost;

    @OneToOne
    @JoinColumn(name = "reservedCarRegNum", referencedColumnName = "carRegNum")
    private CarInventory reservedcarRegNum;

    @ManyToOne
    @JoinColumn(name = "reservedCustomerDlNum", referencedColumnName = "customerDlNum")
    private Customer reservedcustomerDlNum;

}
