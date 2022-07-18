package com.example.car_rental.service;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.exception.BookingException;
import com.example.car_rental.exception.CustomerException;

import java.util.List;

public interface BookingServiceInterface {
    public List<Booking> getAllBookings() throws BookingException;

    public Booking addBooking(String carRegNum, String customerDlNum, Booking booking) throws BookingException, CustomerException;

    public List<Booking> viewCustomerBookings(String customerDlNum) throws BookingException;

    public Booking returnCar(String carRegNum) throws BookingException ;

    public void deleteReturnedCar(String carRegNum) throws BookingException;
}
