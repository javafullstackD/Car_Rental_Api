package com.example.car_rental.controller;

import com.example.car_rental.entity.CarInventory;
import com.example.car_rental.exception.CarInventoryException;
import com.example.car_rental.exception.InputEmptyException;
import com.example.car_rental.service.CarInventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarInventoryController {

    @Autowired
    private CarInventoryServiceInterface carInventoryServiceInterface;

    @PostMapping("/add")
    public ResponseEntity<CarInventory> addCar(@RequestBody CarInventory carInventory) throws InputEmptyException {
        CarInventory newCar = carInventoryServiceInterface.addCar(carInventory);
        return new ResponseEntity<CarInventory>(newCar, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarInventory>> getAllCars() throws CarInventoryException {
        List<CarInventory> allCars = carInventoryServiceInterface.getAllCars();
        return new ResponseEntity<List<CarInventory>>(allCars,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{carRegNum}")
    public ResponseEntity<Void> deleteCar(@PathVariable("carRegNum") String carRegNum) throws CarInventoryException{
        carInventoryServiceInterface.deleteByCarRegNum(carRegNum);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<CarInventory>> getAvailableCars() throws CarInventoryException {
        List<CarInventory> availableCars = carInventoryServiceInterface.getAvailableCars();
        return new ResponseEntity<List<CarInventory>>(availableCars,HttpStatus.OK);
    }



}

