/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.controller;

import co.edu.utp.isc.gia.examsapp.service.OpenQuestionService;
import co.edu.utp.isc.gia.examsapp.web.dto.OpenQuestionDto;
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
@RequestMapping("openquestion")
@CrossOrigin(origins="*")
public class OpenQuestionController {
    
    private final OpenQuestionService openQuestionService;

    public OpenQuestionController(OpenQuestionService openQuestionService) {
        this.openQuestionService = openQuestionService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<?> save(@RequestBody OpenQuestionDto openquestion) throws Exception {
        try {
            openquestion = openQuestionService.save(openquestion);
            return new ResponseEntity<>(openquestion, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() throws Exception {
        List<OpenQuestionDto> openquestion = openQuestionService.listAll();
        return new ResponseEntity<>(openquestion, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) throws Exception {
        OpenQuestionDto openquestion = openQuestionService.findOne(id);
        if (openquestion == null) return new ResponseEntity<> ( 
                "Openquestion doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(openquestion, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody OpenQuestionDto openquestion) 
            throws Exception {
        OpenQuestionDto openQuest;
        try {
            openQuest = openQuestionService.update(openquestion);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(openQuest, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id)  
            throws Exception{
        OpenQuestionDto openquestion = openQuestionService.delete(id);
        if (openquestion == null) return new ResponseEntity<>(
                "Openquestion doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(openquestion, HttpStatus.OK);
    }
    
}
