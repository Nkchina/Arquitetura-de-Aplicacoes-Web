package com.example.RestAPI.Service;

import com.example.RestAPI.Repository.FipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.RestAPI.Model.FipeEntity;
@Service
public class FipeService {

    @Autowired
    private FipeRepository fipeRepository;

    private String consultarURL(String apiURL) {
        String dados;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiURL, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dados = responseEntity.getBody();


            FipeEntity fipe = new FipeEntity();
            fipe.setNome(dados);
            FipeRepository.inserir(fipe);
        }
        else {
            dados = "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }

        return dados;
    }

    public String consultarMarcas() {

        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas");
    }

    public String consultarModelos(int id) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + id + "/modelos");
    }

    public String consultarAnos(int marca, int modelo) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" +
                modelo + "/anos");
    }

    public String consultarValor(int marca, int modelo, String ano) {
        return consultarURL("https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" +
                modelo + "/anos/" + ano);
    }

    public FipeEntity inserir(FipeEntity user) {
        return fipeRepository.save(user);
    }
}
