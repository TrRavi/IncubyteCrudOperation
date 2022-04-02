package com.incubytecrud.crud.controller;

import com.incubytecrud.crud.dto.WordDTO;
import com.incubytecrud.crud.service.CRUDOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CRUDOperationController {

    @Autowired
    private CRUDOperationService crudOperationService;


    @PostMapping(value = "/words",consumes = "application/json", produces = "application/json")
    public ResponseEntity<WordDTO>saveOrUpdateWord(@RequestBody WordDTO requestWordDTO){
        WordDTO wordDTO = crudOperationService.save(requestWordDTO);
        return ResponseEntity.ok(wordDTO);
    }

    @DeleteMapping(value = "/words")
    public ResponseEntity<String> deleteWord(@RequestParam("id") Integer id){
        String res = crudOperationService.deleteWord(id);
        return ResponseEntity.ok(res);
    }



}
