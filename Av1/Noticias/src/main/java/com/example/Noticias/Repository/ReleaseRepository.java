package com.example.Noticias.Repository;

import com.example.Noticias.model.ReleaseModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends MongoRepository<ReleaseModel, String> {

}

