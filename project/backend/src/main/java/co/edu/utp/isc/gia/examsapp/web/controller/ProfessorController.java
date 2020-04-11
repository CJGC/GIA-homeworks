/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.controller;

import co.edu.utp.isc.gia.examsapp.service.ProfessorService;
import co.edu.utp.isc.gia.examsapp.web.dto.ProfessorDto;
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
@RequestMapping("user")
@CrossOrigin(origins="*")
public class ProfessorController {
    
    private final ProfessorService userService;

    public ProfessorController(ProfessorService userService) {
        this.userService = userService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<?> save(@RequestBody ProfessorDto professor) throws Exception {
        try {
            professor = userService.save(professor);
            return new ResponseEntity<>(professor, HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listAll() throws Exception {
        List<ProfessorDto> users = userService.listAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id) throws Exception {
        ProfessorDto professor = userService.findOne(id);
        if (professor == null) return new ResponseEntity<> ( 
                "Professor doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<?> update(@RequestBody ProfessorDto professor) 
            throws Exception {
        ProfessorDto prof;
        try {
            prof = userService.update(professor);
        }
        catch(Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(prof, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable("id") Long id)  
            throws Exception{
        ProfessorDto professor = userService.delete(id);
        if (professor == null) return new ResponseEntity<>(
                "Professor doesn't exist", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(professor, HttpStatus.OK);
    }
    
}
