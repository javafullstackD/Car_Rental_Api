package com.example.car_rental.service;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.entity.Reservation;
import com.example.car_rental.exception.BookingException;
import com.example.car_rental.exception.CustomerException;
import com.example.car_rental.exception.ReservingException;

import java.util.List;

public interface ReservingServiceInterface {
    public List<Reservation> getAllReservations() throws ReservingException;

    public Reservation addReserving(String carRegNum, String customerDlNum, Reservation reserving) throws ReservingException, CustomerException;

    public List<Reservation> viewCustomerReservings(String customerDlNum) throws ReservingException;

    public Reservation returnCar(String carRegNum) throws ReservingException ;

    public void deleteReturnedCar(String carRegNum) throws ReservingException;
}
