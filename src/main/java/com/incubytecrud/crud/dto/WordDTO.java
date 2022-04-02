package com.incubytecrud.crud.dto;

import lombok.*;


public class WordDTO {

    private Integer id;
    private String word;

    public WordDTO() {
    }

    public WordDTO(Integer id, String word) {
        this.id = id;
        this.word = word;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "WordDTO{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
