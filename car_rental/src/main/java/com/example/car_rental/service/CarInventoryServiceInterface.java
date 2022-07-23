package com.example.car_rental.service;

import com.example.car_rental.entity.CarInventory;
import com.example.car_rental.exception.CarInventoryException;
import com.example.car_rental.exception.InputEmptyException;

import java.util.List;

public interface CarInventoryServiceInterface {
    CarInventory addCar(CarInventory carInventory) throws InputEmptyException;

    public void deleteByCarRegNum(String carRegNum) throws CarInventoryException;

    public List<CarInventory> getAllCars()  throws CarInventoryException;

    public List<CarInventory> getAvailableCars() throws CarInventoryException ;
}
