package com.incubytecrud.crud.controller;

import com.incubytecrud.crud.dto.WordDTO;
import com.incubytecrud.crud.service.CRUDOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private CRUDOperationService crudOperationService;

    @GetMapping("/")
    public ModelAndView home() {
        System.out.println("Here it is ");
        ModelAndView modelAndView = new ModelAndView();
        List<WordDTO> wordList = crudOperationService.getWordList();
        modelAndView.addObject("wordList",wordList);

        modelAndView.setViewName("index");
        System.out.println("returning model");
        return modelAndView;
    }
}
