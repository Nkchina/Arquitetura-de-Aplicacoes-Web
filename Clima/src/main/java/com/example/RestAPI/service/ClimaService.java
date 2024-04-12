package com.example.RestAPI.service;

import com.example.RestAPI.repository.ClimaRepository;
import com.example.RestAPI.model.ClimaEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ClimaService {

    @Autowired
    private ClimaRepository climaRepository;

    public List<ClimaEntity> obterTodos(){
        return climaRepository.findAll();
    }

    public ClimaEntity obterPorId(String id){
        return climaRepository.findById(id).orElse(null);
    }

    public ClimaEntity inserir(ClimaEntity clima){
        return climaRepository.save(clima);
    }

    public ClimaEntity atualizar(String id, ClimaEntity newClima){
        ClimaEntity existingClima = climaRepository.findById(id).orElse(null);

        if(existingClima != null){
            existingClima.setPais(newClima.getPais());
            existingClima.setData(newClima.getData());
            return climaRepository.save(existingClima);
        }
        else{
            return null;
        }
    }

    public void excluir(String id){
        climaRepository.deleteById(id);
    }

    public String preverTempo() {
        String dadosMeteorologicos;
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=9fe25332679ebce952fdd9f7f9a83c3e";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMeteorologicos = responseEntity.getBody();

            try {
                JSONArray jsonArray = new JSONArray(dadosMeteorologicos);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject entry = jsonArray.getJSONObject(i);

                    ClimaEntity clima = new ClimaEntity();
                    clima.setPais(entry.getString("country"));
                    clima.setTexto(entry.getString("text"));
                    clima.setData(entry.getString("date"));

                    climaRepository.save(clima);
                }
            } catch (JSONException e) {
                dadosMeteorologicos = "Erro ao analisar os dados meteorológicos.";
                e.printStackTrace();
            }
        } else {
            dadosMeteorologicos = "Falha ao obter dados meteorológicos. Código de status: " + responseEntity.getStatusCode();
        }

        return dadosMeteorologicos;
    }
}