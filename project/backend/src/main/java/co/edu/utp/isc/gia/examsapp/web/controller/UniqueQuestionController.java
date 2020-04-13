/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.controller;

import co.edu.utp.isc.gia.examsapp.service.UniqueQuestionService;
import co.edu.utp.isc.gia.examsapp.web.dto.UniqueQuestionDto;
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
@RequestMapping("uniquequestion")
@CrossOrigin(origins="*")
public class UniqueQuestionController {
    
    private final UniqueQuestionService uniqueQuestionService;

    public UniqueQuestionController(UniqueQuestionService uniqueQuestionService) {
        this.uniqueQuestionService = uniqueQuestionService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<?> save(@RequestBody UniqueQuestionDto uniquequestion) throws Exception {
        try {
            uniquequestion = uniqueQuestionService.save(uniquequestion);
            return new ResponseEntity<>(uniquequestion, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() throws Exception {
        List<UniqueQuestionDto> uniquequestion = uniqueQuestionService.listAll();
        return new ResponseEntity<>(uniquequestion, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) throws Exception {
        UniqueQuestionDto uniquequestion = uniqueQuestionService.findOne(id);
        if (uniquequestion == null) return new ResponseEntity<> ( 
                "Uniquequestion doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(uniquequestion, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UniqueQuestionDto uniquequestion) 
            throws Exception {
        UniqueQuestionDto uniquequest;
        try {
            uniquequest = uniqueQuestionService.update(uniquequestion);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(uniquequest, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id)  
            throws Exception{
        UniqueQuestionDto uniquequestion = uniqueQuestionService.delete(id);
        if (uniquequestion == null) return new ResponseEntity<>(
                "Uniquequestion doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(uniquequestion, HttpStatus.OK);
    }
    
}
