package com.incubytecrud.crud.service;

import com.incubytecrud.crud.dto.WordDTO;

import java.util.List;

public interface CRUDOperationService {

    List<WordDTO> getWordList();

    WordDTO save(WordDTO requestWordDTO);

    String deleteWord(Integer id);
}
