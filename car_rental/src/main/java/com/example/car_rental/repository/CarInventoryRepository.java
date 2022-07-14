package com.example.car_rental.repository;

import com.example.car_rental.entity.CarInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInventoryRepository extends JpaRepository<CarInventory , String> {
}
