package com.example.car_rental.repository;

import com.example.car_rental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking , Integer> {
}
