/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.controller;

import co.edu.utp.isc.gia.examsapp.service.AnswerOptionService;
import co.edu.utp.isc.gia.examsapp.web.dto.AnswerOptionDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CJ
 */
@RestController
@RequestMapping("answeroption")
@CrossOrigin(origins="*")
public class AnswerOptionController {
    
    private final AnswerOptionService answerOptionService;

    public AnswerOptionController(AnswerOptionService answerOptionService) {
        this.answerOptionService = answerOptionService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<?> save(@RequestBody AnswerOptionDto answeroption) throws Exception {
        try {
            answeroption = answerOptionService.save(answeroption);
            return new ResponseEntity<>(answeroption, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() throws Exception {
        List<AnswerOptionDto> answeroption = answerOptionService.listAll();
        return new ResponseEntity<>(answeroption, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) throws Exception {
        AnswerOptionDto answeroption = answerOptionService.findOne(id);
        if (answeroption == null) return new ResponseEntity<> ( 
                "Answer option doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(answeroption, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody AnswerOptionDto answeroption) 
            throws Exception {
        AnswerOptionDto uniquequest;
        try {
            uniquequest = answerOptionService.update(answeroption);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(uniquequest, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id)  
            throws Exception{
        AnswerOptionDto answeroption = answerOptionService.delete(id);
        if (answeroption == null) return new ResponseEntity<>(
                "Answer option doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(answeroption, HttpStatus.OK);
    }
    
}
