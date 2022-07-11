package com.example.car_rental.controller;
import com.example.car_rental.model.Car_Model;
import com.example.car_rental.repository.Car_ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/carmodels")

public class Car_Model_Controller {
    @Autowired
    Car_ModelRepository car_modelRepository;

    @GetMapping
    public List<Car_Model> getAllCarModel(){
        return car_modelRepository.findAll();
    }

}
