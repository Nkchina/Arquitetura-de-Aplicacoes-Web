package com.example.RestAPI.controller;

import com.example.RestAPI.model.ClimaEntity;
import com.example.RestAPI.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class Controller {

    //Classe de serviços
    Service service = new Service();

    @GetMapping("/clima")
    public String preverTempo(){
        return service.preverTempo();
    }
}
