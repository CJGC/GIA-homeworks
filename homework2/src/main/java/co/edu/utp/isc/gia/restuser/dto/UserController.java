/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.dto;

import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.UserDto;
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
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping() // POST http://localhost:8080/user
    public ResponseEntity<String> save(@RequestBody UserDto user) {
        if (user == null) return new ResponseEntity<> ( HttpStatus.BAD_REQUEST);
        
        userService.save(user);
        return new ResponseEntity<> ( HttpStatus.OK);
    }
    
    @GetMapping
    public List<UserDto> listAll() {
        return userService.listAll();
    }
    
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<String> findOne(
            @PathVariable("id") Long id
    ) {
        UserDto user = userService.findOne(id);
        if (user == null) return new ResponseEntity<> ( HttpStatus.NOT_FOUND);
        return new ResponseEntity(user, HttpStatus.OK);
    }
    
    @PutMapping
    public ResponseEntity<String> update(
            @RequestBody UserDto user) {
        //if (userService.update(user) == null) 
        //    return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<> (HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public UserDto delete(
            @PathVariable("id") Long id) {
        return null;
    }
    
}
