package com.example.RestAPI.controller;

import com.example.RestAPI.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Service service = new Service();

    @GetMapping("/marcas")
    public String consultarMarcas(){
        return service.consultarMarcas();
    }
    @GetMapping("/modelos/[marca]")
    public String consultarModelos(@PathVariable int marca, String id){
        return service.consultarModelos(marca, id);
    }
    @GetMapping("/anos/[modelo]/[marca]")
    public String consultarAnos(@PathVariable int marca,@PathVariable int modelo){
        return service.consultarAnos(marca, modelo);
    }
    @GetMapping("/valor/{ano}/[modelo]/[marca]")
    public String consultarValor(@PathVariable int marca,@PathVariable int modelo,@PathVariable String ano){
        return service.consultarValor(marca, modelo, ano);
    }
}
