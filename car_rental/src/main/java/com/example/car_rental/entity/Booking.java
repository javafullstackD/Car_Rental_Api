package com.example.car_rental.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookingId;

    @Temporal(TemporalType.DATE)
    private Date bookingStartDate;

    @Temporal(TemporalType.DATE)
    private Date bookingEndDate;

    private int bookingCost;

    @OneToOne
    @JoinColumn(name = "bookedCarRegNum", referencedColumnName = "carRegNum")
    private CarInventory bookedcarRegNum;

    @ManyToOne
    @JoinColumn(name = "bookedCustomerDlNum", referencedColumnName = "customerDlNum")
    private Customer bookedcustomerDlNum;

}