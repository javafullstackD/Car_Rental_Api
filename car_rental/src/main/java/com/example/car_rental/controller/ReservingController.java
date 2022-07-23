package com.example.car_rental.controller;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.entity.Reservation;
import com.example.car_rental.exception.BookingException;
import com.example.car_rental.exception.CustomerException;
import com.example.car_rental.exception.ReservingException;
import com.example.car_rental.service.BookingServiceInterface;
import com.example.car_rental.service.ReservingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserving")
public class ReservingController {
    @Autowired
    private ReservingServiceInterface reservingServiceInterface;

    @PostMapping("/{carRegNum}/add/{customerDlNum}")
    public ResponseEntity<Reservation> addReserving(@PathVariable String carRegNum, @PathVariable String customerDlNum,
                                                  @RequestBody Reservation reserving) throws ReservingException, CustomerException {
        Reservation newReserving = reservingServiceInterface.addReserving(carRegNum, customerDlNum, reserving);
        return new ResponseEntity<Reservation>(newReserving, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservings() throws ReservingException{
        List<Reservation> allReservings = reservingServiceInterface.getAllReservations();
        return new ResponseEntity<List<Reservation>>(allReservings, HttpStatus.OK);
    }




    @GetMapping("/{customerDlNum}")
    public ResponseEntity<List<Reservation>> viewCustomerReservings(@PathVariable String customerDlNum) throws ReservingException{
        List<Reservation> customerRetrivedReservings = reservingServiceInterface.viewCustomerReservings(customerDlNum);
        return new ResponseEntity<List<Reservation>>(customerRetrivedReservings, HttpStatus.OK);
    }

    //Ended Here For Now

    @PutMapping("/return/{carRegNum}")
    public ResponseEntity<Reservation> returnCar(@PathVariable String carRegNum) throws ReservingException{
        Reservation returnedReservingDetails = reservingServiceInterface.returnCar(carRegNum);
        return new ResponseEntity<Reservation>(returnedReservingDetails, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{carRegNum}")
    public ResponseEntity<Void> deleteReturnedCar(@PathVariable String carRegNum) throws ReservingException {
        reservingServiceInterface.deleteReturnedCar(carRegNum);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
