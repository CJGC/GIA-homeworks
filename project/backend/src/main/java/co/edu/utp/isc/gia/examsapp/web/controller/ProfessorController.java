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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CJ
 */
@RestController
@RequestMapping("user")
public class ProfessorController {
    
    private ProfessorService userService;

    public ProfessorController(ProfessorService userService) {
        this.userService = userService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<ProfessorDto> save(@RequestBody ProfessorDto user) {
        if (user == null) return new ResponseEntity<> ( HttpStatus.BAD_REQUEST);
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<ProfessorDto>> listAll() {
        List<ProfessorDto> users = userService.listAll();
        if (users == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDto> findOne(
            @PathVariable("id") Long id
    ) {
        ProfessorDto user = userService.findOne(id);
        if (user == null) return new ResponseEntity<> ( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDto> update(
            @PathVariable("id") Long id,
            @RequestBody ProfessorDto user) {
        ProfessorDto _user = userService.update(id, user);
        if (_user == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ProfessorDto> delete(
            @PathVariable("id") Long id) {
        ProfessorDto _user = userService.delete(id);
        if (_user == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }
    
}
