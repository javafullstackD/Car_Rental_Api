package com.example.car_rental.repository;

import com.example.car_rental.model.Car_category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Car_categoryRepository extends JpaRepository<Car_category , Long> {
    // our crude operations goes here
}
