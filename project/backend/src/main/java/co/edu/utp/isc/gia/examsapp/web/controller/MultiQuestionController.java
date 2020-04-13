/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.controller;

import co.edu.utp.isc.gia.examsapp.service.MultiQuestionService;
import co.edu.utp.isc.gia.examsapp.web.dto.MultiQuestionDto;
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
@RequestMapping("multiquestion")
@CrossOrigin(origins="*")
public class MultiQuestionController {
    
    private final MultiQuestionService multiquestionService;

    public MultiQuestionController(MultiQuestionService multiquestionService) {
        this.multiquestionService = multiquestionService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<?> save(@RequestBody MultiQuestionDto multiquestion) throws Exception {
        try {
            multiquestion = multiquestionService.save(multiquestion);
            return new ResponseEntity<>(multiquestion, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() throws Exception {
        List<MultiQuestionDto> multiquestion = multiquestionService.listAll();
        return new ResponseEntity<>(multiquestion, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) throws Exception {
        MultiQuestionDto multiquestion = multiquestionService.findOne(id);
        if (multiquestion == null) return new ResponseEntity<> ( 
                "Professor doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(multiquestion, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MultiQuestionDto multiquestion) 
            throws Exception {
        MultiQuestionDto multiquest;
        try {
            multiquest = multiquestionService.update(multiquestion);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(multiquest, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id)  
            throws Exception{
        MultiQuestionDto multiquestion = multiquestionService.delete(id);
        if (multiquestion == null) return new ResponseEntity<>(
                "Professor doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(multiquestion, HttpStatus.OK);
    }
    
}
