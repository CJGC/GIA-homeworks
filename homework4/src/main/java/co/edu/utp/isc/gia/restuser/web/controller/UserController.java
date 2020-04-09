/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
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
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping // POST http://localhost:8080/user
    public ResponseEntity<UserDto> save(@RequestBody UserDto user) {
        if (user == null) return new ResponseEntity<> ( HttpStatus.BAD_REQUEST);
        user = userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<UserDto>> listAll() {
        List<UserDto> users = userService.listAll();
        if (users == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findOne(
            @PathVariable("id") Long id
    ) {
        UserDto user = userService.findOne(id);
        if (user == null) return new ResponseEntity<> ( HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(
            @PathVariable("id") Long id,
            @RequestBody UserDto user) {
        UserDto _user = userService.update(id, user);
        if (_user == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> delete(
            @PathVariable("id") Long id) {
        UserDto _user = userService.delete(id);
        if (_user == null) return new ResponseEntity<> (HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }
    
}
