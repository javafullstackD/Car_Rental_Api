package com.example.car_rental.controller;


import com.example.car_rental.model.Client;
import com.example.car_rental.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")

public class Client_controller {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllCients(){
        return  clientRepository.findAll();
    }

}
