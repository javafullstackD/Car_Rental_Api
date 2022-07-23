package com.example.car_rental.service;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.entity.CarInventory;
import com.example.car_rental.entity.Customer;
import com.example.car_rental.entity.Reservation;
import com.example.car_rental.exception.BookingException;
import com.example.car_rental.exception.CustomerException;
import com.example.car_rental.exception.ReservingException;
import com.example.car_rental.repository.BookingRepository;
import com.example.car_rental.repository.CarInventoryRepository;
import com.example.car_rental.repository.CustomerRepository;
import com.example.car_rental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ReservingService implements ReservingServiceInterface {

    @Autowired
    private ReservationRepository reservingRepository;

    @Autowired
    private CarInventoryRepository carInventoryRepository;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Reservation> getAllReservations() throws ReservingException {
        List<Reservation> allReservings = reservingRepository.findAll();
        if(ReservingException.checkReservings(allReservings)) {
            throw new ReservingException("No reservations are made.");
        }
        return allReservings;
    }

    @Override
    public Reservation addReserving(String carRegNum, String customerDlNum, Reservation reserving) throws ReservingException, CustomerException {
        CarInventory reservedCar = carInventoryRepository.findById(carRegNum).get();
        if (!reservedCar.isCarAvailablity()) {
            throw new ReservingException("The car is already reserved.");
        }
        List<Customer> allCustomer = customerRepository.findAll();
        Customer reservedCustomer = customerRepository.findById(customerDlNum).get();
        if(!CustomerException.checkIfCustomerExist(allCustomer, customerDlNum)) {
            throw new CustomerException("No customer found for the DL number.") ;
        }
        Date reservingStartDate = reserving.getReservingStartDate();
        Date reservingEndDate = reserving.getReservingEndDate();
        if(ReservingException.validateDates(reserving)) {
            throw new ReservingException("Reserving start date cannot be after end date");
        }
        reserving.setReservingStartDate(reservingStartDate);
        reserving.setReservingEndDate(reservingEndDate);
        reserving.setReservedcarRegNum(reservedCar);
        reserving.setReservedcustomerDlNum(reservedCustomer);

        int carCostPerDay = reservedCar.getCarCostPerDay();
        long duration = reservingEndDate.getTime() - reservingStartDate.getTime();
        duration = TimeUnit.MILLISECONDS.toDays(duration);

        int newReservingCost = 0;
        if (duration == 0) {
            newReservingCost = reserving.getReservedcarRegNum().getCarCostPerDay();
        } else {
            newReservingCost = (int) (carCostPerDay * duration);
        }
        reserving.setReservingCost(newReservingCost);
        reservedCar.setCarAvailablity(false);
        carInventoryRepository.save(reservedCar);

        reservingRepository.save(reserving);
        return reserving;

    }

    @Override
    public List<Reservation> viewCustomerReservings(String customerDlNum) throws ReservingException {
        Customer reservedCustomer = customerRepository.findById(customerDlNum).get();
        List<Reservation> allReservings = reservingRepository.findAll();
        if(!ReservingException.checkCustomerReservingExist(allReservings, customerDlNum)) {
            throw new ReservingException("No reservation found for the DL number");
        }
        List<Reservation> retrievedReservings = allReservings.stream().filter(s -> s.getReservedcustomerDlNum().equals(reservedCustomer))
                .toList();
        return retrievedReservings;
    }


    @Override
    public Reservation returnCar(String carRegNum) throws ReservingException {
        List<CarInventory> allCars = carInventoryRepository.findAll();

        if(!ReservingException.checkIfCarRegNumExists(allCars, carRegNum)) {
            throw new ReservingException("No details found for the registrartion number");
        }
        CarInventory reservedCar = carInventoryRepository.findById(carRegNum).get();
        reservedCar.setCarAvailablity(true);
        carInventoryRepository.save(reservedCar);
        List<Reservation> allReservings = getAllReservations();
        Reservation returnedReservingDetails = allReservings.stream()
                .filter(s -> s.getReservedcarRegNum().getCarRegNum().equals(carRegNum)).findAny().get();
        return returnedReservingDetails;
    }

    @Override
    public void deleteReturnedCar(String carRegNum) throws ReservingException {
        CarInventory reservedCar = carInventoryRepository.findById(carRegNum).get();

        List<Reservation> allReservings = getAllReservations();
        if (reservedCar.isCarAvailablity()) {
            Reservation currentReserving = allReservings.stream().filter(s -> s.getReservedcarRegNum().equals(reservedCar))
                    .findFirst().get();
            reservingRepository.delete(currentReserving);
        } else {
            throw new ReservingException("The has not been returned by to inventory");
        }


    }
}
