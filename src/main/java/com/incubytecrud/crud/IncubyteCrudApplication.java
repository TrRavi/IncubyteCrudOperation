package com.incubytecrud.crud;

import com.incubytecrud.crud.entity.WordEntity;
import com.incubytecrud.crud.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SpringBootApplication
public class IncubyteCrudApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(IncubyteCrudApplication.class, args);
    }

    @Autowired
    WordRepository wordRepository;

    @Override
    public void run(String... args) throws Exception {
        List<WordEntity> wordEntityList = IntStream.range(1,6)
                                .mapToObj(i -> new WordEntity(i,i+"th word"))
                                .collect(Collectors.toList());
        wordRepository.saveAll(wordEntityList);
    }
}
