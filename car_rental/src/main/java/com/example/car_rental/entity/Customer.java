package com.example.car_rental.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Size(min = 15, max = 15)
    private String customerDlNum;

    @NotBlank

    private String customerName;

    @NotBlank
    @Size(min = 10, max = 10)
    private String customerPhoneNum;

    @NotBlank
    private String customerAddress;

    @OneToMany(mappedBy = "bookedcustomerDlNum")
    @JsonIgnore
    private Set<Booking> bookingMadeByCustomer = new HashSet<>();

    @OneToMany(mappedBy = "reservedcustomerDlNum")
    @JsonIgnore
    private Set<Reservation> reservingMadeByCustomer = new HashSet<>();

}