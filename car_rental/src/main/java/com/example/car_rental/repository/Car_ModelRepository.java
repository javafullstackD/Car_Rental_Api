package com.example.car_rental.repository;

import com.example.car_rental.model.Car_Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Car_ModelRepository extends JpaRepository<Car_Model, Long> {
    // our crude operations goes here
}
