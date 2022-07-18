package com.example.car_rental.controller;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.exception.BookingException;
import com.example.car_rental.exception.CustomerException;
import com.example.car_rental.service.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingServiceInterface bookingServiceInterface;

    @PostMapping("/{carRegNum}/add/{customerDlNum}")
    public ResponseEntity<Booking> addBooking(@PathVariable String carRegNum, @PathVariable String customerDlNum,
                                              @RequestBody Booking booking) throws BookingException, CustomerException {
        Booking newBooking = bookingServiceInterface.addBooking(carRegNum, customerDlNum, booking);
        return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Booking>> getAllBookings() throws BookingException{
        List<Booking> allBookings = bookingServiceInterface.getAllBookings();
        return new ResponseEntity<List<Booking>>(allBookings, HttpStatus.OK);
    }


    @GetMapping("/{customerDlNum}")
    public ResponseEntity<List<Booking>> viewCustomerBookings(@PathVariable String customerDlNum) throws BookingException{
        List<Booking> customerRetrivedBookings = bookingServiceInterface.viewCustomerBookings(customerDlNum);
        return new ResponseEntity<List<Booking>>(customerRetrivedBookings, HttpStatus.OK);
    }

    @PutMapping("/return/{carRegNum}")
    public ResponseEntity<Booking> returnCar(@PathVariable String carRegNum) throws BookingException{
        Booking returnedBookingDetails = bookingServiceInterface.returnCar(carRegNum);
        return new ResponseEntity<Booking>(returnedBookingDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{carRegNum}")
    public ResponseEntity<Void> deleteReturnedCar(@PathVariable String carRegNum) throws BookingException {
        bookingServiceInterface.deleteReturnedCar(carRegNum);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
