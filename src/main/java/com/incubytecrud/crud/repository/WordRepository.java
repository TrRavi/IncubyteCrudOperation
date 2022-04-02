package com.incubytecrud.crud.repository;

import com.incubytecrud.crud.entity.WordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Integer> {
}
