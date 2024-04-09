package com.example.RestAPI.controller;

import com.example.RestAPI.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ClimaService service;

    @GetMapping("/clima")
    public String preverTempo(){
        return service.preverTempo();
    }
}