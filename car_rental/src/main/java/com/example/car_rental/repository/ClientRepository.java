package com.example.car_rental.repository;

import com.example.car_rental.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client , Long> {
    // our crude operations goes here
}
