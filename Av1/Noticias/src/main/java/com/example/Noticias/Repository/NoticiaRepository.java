package com.example.Noticias.Repository;

import com.example.Noticias.model.NoticiasModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends MongoRepository<NoticiasModel, String>{

}

