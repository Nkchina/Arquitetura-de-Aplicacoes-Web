package com.example.BD_RestAPI.repository;
import com.example.BD_RestAPI.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
  
    List<UserEntity> findByNomeIgnoreCase(String nome);
    List<UserEntity> findByEmailIgnoreCase(String email);
    List<UserEntity> findByNomeAndEmail(String nome, String email);
    List<UserEntity> findByNomeStartingWithIgnoreCase(String prefixo);
    List<UserEntity> findByNomeContainingIgnoreCase(String substring);
}
