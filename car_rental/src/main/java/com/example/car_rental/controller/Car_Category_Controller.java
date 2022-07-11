package com.example.car_rental.controller;
import com.example.car_rental.model.Car_Model;
import com.example.car_rental.model.Car_category;
import com.example.car_rental.repository.Car_ModelRepository;
import com.example.car_rental.repository.Car_categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/carcategories")

public class Car_Category_Controller {
    @Autowired
    Car_categoryRepository car_categoryRepository;

    @GetMapping
    public List<Car_category> getAllCarCategories(){
        return car_categoryRepository.findAll();
    }
}
