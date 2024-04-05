package com.example.RestAPI.controller;

import com.example.RestAPI.model.ClimaEntity;
import com.example.RestAPI.service.ClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/clima")
public class Controller {
    @Autowired
    private ClimaService climaService;

    @GetMapping
    public List<ClimaEntity> obterTodos(){
        return climaService.obterTodos();
    }
    @GetMapping("/{id}")
    public ClimaEntity obterPorId(@PathVariable String id){
        return climaService.obterPorId(id);
    }
    @PostMapping
    public ClimaEntity inserir(@RequestBody ClimaEntity user){
        return climaService.inserir(user);
    }
    @PutMapping("/{id}")
    public ClimaEntity atualizar(@PathVariable String id, @RequestBody ClimaEntity user){
        return climaService.atualizar(id, user);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id){
        climaService.excluir(id);
    }
}
