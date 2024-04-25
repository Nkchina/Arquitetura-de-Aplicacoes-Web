package com.example.Noticias.controller;

import com.example.Noticias.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticiasController {

    @Autowired
    private NoticiasService noticiasService;

    @GetMapping("/noticiasereleases")
    public String consultarNoticiaseReleases() {
        return noticiasService.consultarNoticiasEReleases();
    }

    @GetMapping("/noticias/{noticiasereleases}")
    public String consultarNoticias(@PathVariable int noticiasereleases) {
        return noticiasService.consultarNoticias(noticiasereleases);
    }

    @GetMapping("/releases/{noticiasereleases}")
    public String consultarReleases(@PathVariable int noticiasereleases) {
        return noticiasService.consultarReleases(noticiasereleases);
    }
}