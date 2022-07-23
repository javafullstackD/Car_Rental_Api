package com.example.car_rental.exception;

import com.example.car_rental.entity.Booking;
import com.example.car_rental.entity.CarInventory;
import com.example.car_rental.entity.Reservation;

import java.util.Date;
import java.util.List;

public class ReservingException extends Exception{
    private static final long serialVersionUID = -5789561353212240200L;

    public ReservingException() {

    }

    public ReservingException(String s) {
        super(s);
    }

    public static boolean validateCarAvailablity(Reservation reserving) {

        if (reserving.getReservedcarRegNum().isCarAvailablity() == false) {
            return false;
        }
        return true;

    }

    public static boolean checkReservings(List<Reservation> allReservings) {

        if (allReservings.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean checkIfCarRegNumExists(List<CarInventory> allCars, String carRegNum) {
        boolean carToBeChecked = allCars.stream().filter(s -> s.getCarRegNum().equals(carRegNum)).findFirst().isPresent();
        return carToBeChecked;
    }

    public static boolean validateDates(Reservation reserving) {
        Date start = reserving.getReservingStartDate();
        Date end = reserving.getReservingEndDate();

        int res = start.compareTo(end);
        if(res < 0) {
            return false;
        }
        return true;
    }

    public static boolean checkCustomerReservingExist(List<Reservation> allReservings, String customerDlNum) {
        boolean DlNumExist = allReservings.stream().filter(s -> s.getReservedcustomerDlNum().getCustomerDlNum().equalsIgnoreCase(customerDlNum)).findAny().isPresent();
        return DlNumExist;
    }
}
