/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.service;

import co.edu.utp.isc.gia.restuser.data.entity.User;
import co.edu.utp.isc.gia.restuser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restuser.web.dto.UserDto;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
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
    
    @BeforeEach
    public void setUp() {
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = Mockito.mock(ModelMapper.class);
    }
    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {
        //System.out.println("save");
        //User sended = new User(null, "Cesar", "123", "Cesar Diaz","cdiaz@me.com");
        User resulted = new User(1L, "Cesar", "123", "Cesar Diaz","cdiaz@me.com");
        when(userRepository.save(any(User.class))).thenReturn(resulted);
        
        // Input
        UserDto user = new UserDto(null, "CESAR", "123", "Cesar Diaz", "cdiaz@me.com");
        
        // Target
        UserService instance = new UserService(userRepository, modelMapper);
        
        // Expected
        UserDto expResult = new UserDto(1L, "Cesar", "123", "Cesar Diaz","cdiaz@me.com");
        
        // Testing save method
        UserDto result = instance.save(user);
        
        // validations
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUsername(), result.getUsername());
        
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testParamNull_RestulException() throws Exception {
        // Input
        UserDto user = null;
        
        // Target
        UserService instance = new UserService(userRepository, modelMapper);
        
        // Expected
        UserDto expResult = instance.save(user);
        assertThrows(Exception.class, () -> {
            UserDto result = instance.save(user);
        });
    }
    /**
     * Test of listAll method, of class UserService.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        UserService instance = null;
        List<UserDto> expResult = null;
        List<UserDto> result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findOne method, of class UserService.
     */
    @Test
    public void testFindOne() {
        System.out.println("findOne");
        Long id = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.findOne(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserService.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        long id = 0L;
        UserDto user = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.update(id, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        UserService instance = null;
        UserDto expResult = null;
        UserDto result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
