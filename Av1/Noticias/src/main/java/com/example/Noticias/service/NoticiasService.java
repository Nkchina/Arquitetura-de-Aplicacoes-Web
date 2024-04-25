package com.example.Noticias.service;

import com.example.Noticias.Repository.ReleaseRepository;
import com.example.Noticias.model.NoticiasModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NoticiasService {

    @Autowired
    private NoticiasModel noticiaRepository;

    @Autowired
    private ReleaseRepository releaseRepository;

    private String consultarURL(String apiUrl){
        String dados;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();
        } else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
        return dados;
    }

    public String consultarNoticiasEReleases() {
        String noticiasEReleases = consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias");

        return noticiasEReleases;
    }

    public String consultarNoticias(int noticiasereleases) {
        String noticias = consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=noticia");
        return noticias;
    }

    public String consultarReleases(int noticiasereleases) {
        String releases = consultarURL("https://servicodados.ibge.gov.br/api/v3/noticias/?tipo=release");

        return releases;
    }
}
