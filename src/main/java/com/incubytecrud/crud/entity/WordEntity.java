package com.incubytecrud.crud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "WORDS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WordEntity {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "COLUMN")
    private String word;

}

