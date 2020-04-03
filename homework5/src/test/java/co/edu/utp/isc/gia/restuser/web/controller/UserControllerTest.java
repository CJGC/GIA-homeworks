/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.service.UserService;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/**
 *
 * @author CJ
 */
public class UserControllerTest {
    
    public UserControllerTest() {
    }

    private UserRepository userRepository; 
    private UserController userController;
    
    @Before
    public void init() {
        userRepository = Mockito.mock(UserRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        UserService userService = new UserService(userRepository, modelMapper);
        userController = new UserController(userService);
    }
    /**
     * Test of save method, of class UserController.
     */
    @Test
    public void testSave() {

        User resulted = new User(null, "cesar", "123", "Cesar Diaz","cdiaz@me.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        UserDto user = new UserDto(null, "cesar", "123", "Cesar Diaz", "cdiaz@me.com");
        ResponseEntity<UserDto> result = userController.save(user);
        ResponseEntity<UserDto> expResult = new ResponseEntity<>(user, HttpStatus.OK);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of listAll method, of class UserController.
     */
    @Test
    public void testListAll() {
        ArrayList<User> usrResp = new ArrayList<>();
        
        usrResp.add(new User(1L, "cesar", "123", "Cesar Diaz","cdiaz@me.com"));
        usrResp.add(new User(2L, "julian", "123", "Julian G","julio@me.com"));
        usrResp.add(new User(3L, "robin", "123", "Robin H","robin@me.com"));
        
        when(userRepository.findAll()).thenReturn(usrResp);
        

        ResponseEntity<List<UserDto>> result = userController.listAll();
        
        ArrayList<UserDto> expUsers = new ArrayList<>();
        expUsers.add(new UserDto(1L, "cesar", "123", "Cesar Diaz","cdiaz@me.com"));
        expUsers.add(new UserDto(2L, "julian", "123", "Julian G","julio@me.com"));
        expUsers.add(new UserDto(3L, "robin", "123", "Robin H","robin@me.com"));
        ResponseEntity<List<UserDto>> expResult = new ResponseEntity<>(expUsers, HttpStatus.OK);
        
        assert result != null;
        assertEquals(result.getHeaders(), expResult.getHeaders());
        
        
        for (int i=0; i < expUsers.size(); i++) {
            assertEquals(expResult.getBody().get(i).getId(), 
                    result.getBody().get(i).getId());
            assertEquals(expResult.getBody().get(i).getUsername(), 
                    result.getBody().get(i).getUsername());
            assertEquals(expResult.getBody().get(i).getPassword(), 
                    result.getBody().get(i).getPassword());
            assertEquals(expResult.getBody().get(i).getName(), 
                    result.getBody().get(i).getName());
            assertEquals(expResult.getBody().get(i).getEmail(), 
                    result.getBody().get(i).getEmail());
        }
        
    }

    /**
     * Test of findOne method, of class UserController.
     */
    @Test
    public void testFindOne() {
        
        User resulted = new User(2L, "julian", "123", "Julian G","julio@me.com");
        Optional<User> op = Optional.of(resulted);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        
        ResponseEntity<UserDto> result = userController.findOne(2L);
        
        
        UserDto user = new UserDto(2L, "julian", "123", "Julian G", "julio@me.com");
        ResponseEntity<UserDto> expResult = new ResponseEntity<>(user, HttpStatus.OK);
        
        assert result != null;
        
        assertEquals(expResult.getHeaders(), result.getHeaders());
        
        assertEquals(expResult.getBody().getId(),
                result.getBody().getId());
        assertEquals(expResult.getBody().getName(),
                result.getBody().getName());
        assertEquals(expResult.getBody().getUsername(),
                result.getBody().getUsername());
        assertEquals(expResult.getBody().getPassword(),
                result.getBody().getPassword());
        assertEquals(expResult.getBody().getEmail(),
                result.getBody().getEmail());
    }

    /**
     * Test of update method, of class UserController.
     */
    @Test
    public void testUpdate() {
        User resulted = new User(1L, "juan", "123", "Juan","juan@me.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        UserDto user = new UserDto(null, "juan", "321", "juan", "juan@me.com");
        
        ResponseEntity<UserDto> result = userController.update(1L, user);
        ResponseEntity<UserDto> expResult = new ResponseEntity<>(user, HttpStatus.OK);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class UserController.
     */
    @Test
    public void testDelete() {
        
        User user = new User(2L, "julian", "123", "Julian G","julio@me.com");
        Optional<User> op = Optional.of(user);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        
        ResponseEntity<UserDto> result = userController.delete(2L);
        
        UserDto userDto = new UserDto(2L, "julian", "123", "Julian G","julio@me.com");
        ResponseEntity<UserDto> expResult = new ResponseEntity<>(userDto, HttpStatus.OK);
        
        assert result != null;
        
        assertEquals(expResult.getHeaders(), result.getHeaders());
        
        assertEquals(expResult.getBody().getId(), 
                result.getBody().getId());
        assertEquals(expResult.getBody().getUsername(), 
                result.getBody().getUsername());
        assertEquals(expResult.getBody().getPassword(), 
                result.getBody().getPassword());
        assertEquals(expResult.getBody().getName(), 
                result.getBody().getName());
        assertEquals(expResult.getBody().getEmail(), 
                result.getBody().getEmail());
        
    }
    
}
