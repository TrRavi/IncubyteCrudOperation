package com.incubytecrud.crud.service;

import com.incubytecrud.crud.dto.WordDTO;
import com.incubytecrud.crud.entity.WordEntity;
import com.incubytecrud.crud.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CRUDOperationServiceImpl implements CRUDOperationService{

    @Autowired
    WordRepository wordRepository;

    @Override
    public List<WordDTO> getWordList() {
        List<WordEntity> wordEntityList = wordRepository.findAll();
        return wordEntityList.stream()
                .map(word -> new WordDTO(word.getId(),word.getWord()))
                .collect(Collectors.toList());
    }

    @Override
    public WordDTO save(WordDTO requestWordDTO) {
        WordEntity savedWord = wordRepository.save(new WordEntity(requestWordDTO.getId(), requestWordDTO.getWord()));
        return new WordDTO(savedWord.getId(),savedWord.getWord());
    }

    @Override
    public String deleteWord(Integer id) {
        wordRepository.deleteById(id);
        return "Successfully deleted";
    }
}
