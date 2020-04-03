/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;

/**
 *
 * @author CJ
 */
public class UserServiceTest {
    
    public UserServiceTest() {
    }

    //@Mock
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private UserService userService;
    
    @Before
    public void init() {
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = new ModelMapper();
        userService = new UserService(userRepository, modelMapper);
    }
    
    @After
    public void end() {
        modelMapper = null;
    }
    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {

        User resulted = new User(1L, "cesar", "123", "Cesar Diaz","cdiaz@me.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        // Input
        UserDto user = new UserDto(null, "CESAR", "123", "Cesar Diaz", "cdiaz@me.com");

        // Testing save method
        UserDto result = userService.save(user);
        
        // Expected result
        UserDto expResult = new UserDto(1L, "cesar", "123", "Cesar Diaz","cdiaz@me.com");
        
        // Validations
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
    }

    
//    @Test
//    public void testParamNull_RestulException() throws Exception {
//        // Input
//        UserDto user = null;
//        
//        // Target
//        UserService instance = new UserService(userRepository, modelMapper);
//        
//        // Expected
//        UserDto expResult = instance.save(user);
//        assertThrows(Exception.class, () -> {
//            UserDto result = instance.save(user);
//        });
//    }
    /**
     * Test of listAll method, of class UserService.
     */
    @Test
    public void testListAll() {
        ArrayList<User> users = new ArrayList<>();
        
        users.add(new User(1L, "cesar", "123", "Cesar Diaz","cdiaz@me.com"));
        users.add(new User(2L, "julian", "123", "Julian G","julio@me.com"));
        users.add(new User(3L, "robin", "123", "Robin H","robin@me.com"));
        
        when(userRepository.findAll()).thenReturn(users);
        
        List<UserDto> resultDto = userService.listAll();
        
        // validations
        for (int i=0; i<resultDto.size(); i++) {
            assertEquals(users.get(i).getId(), resultDto.get(i).getId());
            assertEquals(users.get(i).getName(), resultDto.get(i).getName());
            assertEquals(users.get(i).getUsername(), resultDto.get(i).getUsername());
            assertEquals(users.get(i).getEmail(), resultDto.get(i).getEmail());
            assertEquals(users.get(i).getPassword(), resultDto.get(i).getPassword());
        }
    }

    /**
     * Test of findOne method, of class UserService.
     */
    @Test
    public void testFindOne() {
        
        User user = new User(2L, "julian", "123", "Julian G","julio@me.com");
        Optional<User> op = Optional.of(user);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        UserDto result = userService.findOne(2L);

        // Expected result
        UserDto expResult = new UserDto(2L, "julian", "123", "Julian G",
                "julio@me.com");
        
        // Validations
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
    }

    /**
     * Test of update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        User resulted = new User(1L, "juan", "123", "Juan","juan@me.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        // Input
        UserDto user = new UserDto(null, "juan", "321", "juan", "juan@me.com");

        // Testing save method
        UserDto result = userService.update(1L, user);
        
        // old register
        UserDto oldReg = new UserDto(1L, "cesar", "123", "Cesar Diaz","cesar@me.com");
        
        // Validations
        assertEquals(oldReg.getId(), result.getId());
        assertNotSame(oldReg.getName(), result.getName());
        assertNotSame(oldReg.getUsername(), result.getUsername());
        assertNotSame(oldReg.getEmail(), result.getEmail());
        assertNotSame(oldReg.getPassword(), result.getPassword());
    }

    /**
     * Test of delete method, of class UserService.
     */
    @Test
    public void testDelete() {
        User user = new User(2L, "julian", "123", "Julian G","julio@me.com");
        Optional<User> op = Optional.of(user);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        //when(userRepository.delete(any(Long.class)));
        
        UserDto result = userService.delete(2L);
        
        UserDto expResult = new UserDto(2L, "julian", "123", "Julian G","julio@me.com");
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getUsername(), result.getUsername());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getPassword(), result.getPassword());
    }
    
}
