/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restuser.web.controller;

import co.edu.utp.isc.gia.examsapp.web.controller.ProfessorController;
import co.edu.utp.isc.gia.examsapp.data.entity.Professor;
import co.edu.utp.isc.gia.examsapp.service.ProfessorService;
import co.edu.utp.isc.gia.examsapp.web.dto.ProfessorDto;
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
import co.edu.utp.isc.gia.examsapp.data.repository.ProfessorRepository;
import co.edu.utp.isc.gia.examsapp.validators.ProfessorValidator;


/**
 *
 * @author CJ
 */
public class ProfessorControllerTest {
    
    public ProfessorControllerTest() {
    }

    private ProfessorRepository userRepository; 
    private ProfessorController userController;
    private ProfessorValidator professorValidator;
    
    @Before
    public void init() {
        userRepository = Mockito.mock(ProfessorRepository.class);
        ModelMapper modelMapper = new ModelMapper();
        professorValidator = new ProfessorValidator();
        ProfessorService userService = new ProfessorService(userRepository, 
                modelMapper, professorValidator);
        userController = new ProfessorController(userService);
    }
    /**
     * Test of save method, of class ProfessorController.
     */
   @Test
    public void testSaveProfessorNullObject() {
                ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor object is null", 
                        HttpStatus.BAD_REQUEST);
        
        ProfessorDto professor = null;
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testSaveProfessorNullIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(null, null, "Juan carlos", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
        
    }

    @Test
    public void testSaveProfessorNullName() {
        ProfessorDto professor = new ProfessorDto(null, "11", null, 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's name is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorNullLastname() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                null, "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's lastname is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorNullEmail() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", null, "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testSaveProfessorNullUsername() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", null, "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's username is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorNullPassword() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", null,null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    

    @Test
    public void testSaveProfessorEmptyIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(null, "", "Juan carlos", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testSaveProfessorEmptyName() {
        ProfessorDto professor = new ProfessorDto(null, "11", "", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's name is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorEmptyLastname() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's lastname is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorEmptyEmail() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testSaveProfessorEmptyUsername() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's username is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorEmptyPassword() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorInvalidIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(null, "idcard", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "juan23",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is not a number", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        //
        assertEquals(response, expResult);
    }        
    
    @Test
    public void testSaveProfessorInvalidEmail() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juanme.co", "juan23", "juan23",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is invalid", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testSaveProfessorInvalidPassword() {
        ProfessorDto professor = new ProfessorDto(null, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "12",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is invalid", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.save(professor);
        }
        catch(Exception e) {
        }
        assertEquals(response, expResult);
    }    
    
    @Test
    public void testSave() {
        Professor resulted = new Professor(null,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid", null);

        when(userRepository.save(any(Professor.class))).thenReturn(resulted);
        
        ProfessorDto professor = new ProfessorDto(null,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = new ResponseEntity<>(professor, HttpStatus.OK);
        try {
            response = userController.save(professor);
            
        }
        catch(Exception e) { }
        
        assertEquals(response.getHeaders(), expResult.getHeaders());

        ProfessorDto bodyFromResponse = (ProfessorDto) response.getBody();
        ProfessorDto bodyFromExpResult = (ProfessorDto) expResult.getBody();
        
        assertEquals(bodyFromResponse.getId(), bodyFromExpResult.getId());
        assertEquals(bodyFromResponse.getIdentificationCard(), bodyFromExpResult.getIdentificationCard());
        assertEquals(bodyFromResponse.getName(), bodyFromExpResult.getName());
        assertEquals(bodyFromResponse.getLastname(), bodyFromExpResult.getLastname());
        assertEquals(bodyFromResponse.getEmail(), bodyFromExpResult.getEmail());
        assertEquals(bodyFromResponse.getUsername(), bodyFromExpResult.getUsername());
        assertEquals(bodyFromResponse.getPassword(), bodyFromExpResult.getPassword());
    }
    
/* Update method test */    

   @Test
    public void testUpdateProfessorNullObject() {
                ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor object is null", 
                        HttpStatus.BAD_REQUEST);
        
        ProfessorDto professor = null;
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testUpdateProfessorNullIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(1L, null, "Juan carlos", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
        
    }

    @Test
    public void testUpdateProfessorNullName() {
        ProfessorDto professor = new ProfessorDto(1L, "11", null, 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's name is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorNullLastname() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                null, "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's lastname is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorNullEmail() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", null, "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testUpdateProfessorNullUsername() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", null, "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's username is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorNullPassword() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", null,null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    

    @Test
    public void testUpdateProfessorEmptyIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(1L, "", "Juan carlos", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testUpdateProfessorEmptyName() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "", 
                "Gomez", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's name is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorEmptyLastname() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "", "juant@me.co", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's lastname is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorEmptyEmail() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "", "Janco27", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testUpdateProfessorEmptyUsername() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "", "123",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's username is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorEmptyPassword() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is empty", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }

    @Test
    public void testUpdateProfessorNullId() {
        ProfessorDto professor = new ProfessorDto(null, "idcard", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "juan23",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's id is null", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }      
    
    
    @Test
    public void testUpdateProfessorInvalidIdentificationCard() {
        ProfessorDto professor = new ProfessorDto(1L, "idcard", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "juan23",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's identification card is not a number", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }        
    
    @Test
    public void testUpdateProfessorInvalidEmail() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juanme.co", "juan23", "juan23",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's email is invalid", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        
        assertEquals(response, expResult);
    }
    
    @Test
    public void testUpdateProfessorInvalidPassword() {
        ProfessorDto professor = new ProfessorDto(1L, "11", "Juan Carlos", 
                "Gomez", "juan@me.co", "juan23", "12",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = 
                new ResponseEntity<>("Professor's password is invalid", 
                        HttpStatus.BAD_REQUEST);
        
        try {
            response = this.userController.update(professor);
        }
        catch(Exception e) {
        }
        assertEquals(response, expResult);
    }

    /**
     * Test of update method, of class ProfessorController.
     */
    @Test
    public void testUpdate() {
        Professor resulted = new Professor(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid", null);

        when(userRepository.save(any(Professor.class))).thenReturn(resulted);
        
        ProfessorDto professor = new ProfessorDto(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid",null);
        
        ResponseEntity<?> response = null;
        ResponseEntity<?> expResult = new ResponseEntity<>(professor, HttpStatus.OK);
        try {
            response = userController.update(professor);
            
        }
        catch(Exception e) { }
        
        assertEquals(response.getHeaders(), expResult.getHeaders());

        ProfessorDto bodyFromResponse = (ProfessorDto) response.getBody();
        ProfessorDto bodyFromExpResult = (ProfessorDto) expResult.getBody();
        
        assertEquals(bodyFromResponse.getId(), bodyFromExpResult.getId());
        assertEquals(bodyFromResponse.getIdentificationCard(), bodyFromExpResult.getIdentificationCard());
        assertEquals(bodyFromResponse.getName(), bodyFromExpResult.getName());
        assertEquals(bodyFromResponse.getLastname(), bodyFromExpResult.getLastname());
        assertEquals(bodyFromResponse.getEmail(), bodyFromExpResult.getEmail());
        assertEquals(bodyFromResponse.getUsername(), bodyFromExpResult.getUsername());
        assertEquals(bodyFromResponse.getPassword(), bodyFromExpResult.getPassword());
    }

    @Test
    public void testFindOneNonExistentProfessor() {
        when(userRepository.findById(any(Long.class))).thenReturn(null);
        ResponseEntity<?> response = null;
        try {
            response = userController.findOne(1L);
        }
        catch (Exception e) {}
        
        ResponseEntity<?> expResult = 
                new ResponseEntity<> ("Professor doesn't exist", 
                        HttpStatus.NOT_FOUND);
        
        assertEquals(expResult, response);

    }
    
    /**
     * Test of findOne method, of class ProfessorController.
     */
    @Test
    public void testFindOne() {
        
        Professor resulted = new Professor(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid", null);
        Optional<Professor> op = Optional.of(resulted);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        
        ResponseEntity<?> response = null;
        try {
            response = userController.findOne(1L);
        }
        catch (Exception e) {}
        
        ProfessorDto user = new ProfessorDto(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid",null);
        ResponseEntity<?> expResult = new ResponseEntity<>(user, HttpStatus.OK);
        
        assertEquals(expResult.getHeaders(), response.getHeaders());
        
        ProfessorDto bodyFromResponse = (ProfessorDto) response.getBody();
        ProfessorDto bodyFromExpResult = (ProfessorDto) expResult.getBody();
        
        assertEquals(bodyFromResponse.getId(), bodyFromExpResult.getId());
        assertEquals(bodyFromResponse.getIdentificationCard(), bodyFromExpResult.getIdentificationCard());
        assertEquals(bodyFromResponse.getName(), bodyFromExpResult.getName());
        assertEquals(bodyFromResponse.getLastname(), bodyFromExpResult.getLastname());
        assertEquals(bodyFromResponse.getEmail(), bodyFromExpResult.getEmail());
        assertEquals(bodyFromResponse.getUsername(), bodyFromExpResult.getUsername());
        assertEquals(bodyFromResponse.getPassword(), bodyFromExpResult.getPassword());
    }


    @Test
    public void testDeleteNonExistentProfessor() {
        when(userRepository.findById(any(Long.class))).thenReturn(null);
        ResponseEntity<?> response = null;
        try {
            response = userController.delete(1L);
        }
        catch (Exception e) {}
        
        ResponseEntity<?> expResult = 
                new ResponseEntity<> ("Professor doesn't exist", 
                        HttpStatus.NOT_FOUND);
        
        assertEquals(expResult, response);
    }

    /**
     * Test of delete method, of class ProfessorController.
     */
    @Test
    public void testDelete() {
        
        Professor resulted = new Professor(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid", null);
        Optional<Professor> op = Optional.of(resulted);
        when(userRepository.findById(any(Long.class))).thenReturn(op);
        
        ResponseEntity<?> response = null;
        try {
            response = userController.delete(1L);
        }
        catch (Exception e) {}
        
        ProfessorDto professor = new ProfessorDto(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid",null);
        ResponseEntity<?> expResult = new ResponseEntity<>(professor, HttpStatus.OK);
        
        assertEquals(expResult.getHeaders(), response.getHeaders());
        
        ProfessorDto bodyFromResponse = (ProfessorDto) response.getBody();
        ProfessorDto bodyFromExpResult = (ProfessorDto) expResult.getBody();
        
        assertEquals(bodyFromResponse.getId(), bodyFromExpResult.getId());
        assertEquals(bodyFromResponse.getIdentificationCard(), bodyFromExpResult.getIdentificationCard());
        assertEquals(bodyFromResponse.getName(), bodyFromExpResult.getName());
        assertEquals(bodyFromResponse.getLastname(), bodyFromExpResult.getLastname());
        assertEquals(bodyFromResponse.getEmail(), bodyFromExpResult.getEmail());
        assertEquals(bodyFromResponse.getUsername(), bodyFromExpResult.getUsername());
        assertEquals(bodyFromResponse.getPassword(), bodyFromExpResult.getPassword());
        
    }

    /**
     * Test of listAll method, of class ProfessorController.
     */
    @Test
    public void testListAll() {
        ArrayList<Professor> resulted = new ArrayList<>();
        
        resulted.add(new Professor(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid", null));
        resulted.add(new Professor(2L,"12","Carlos mario", "Lopez", 
                "carlos@me.co", "Carl727", "Carlosthebest", null));
        resulted.add(new Professor(3L,"13","Natalia", "Castano", 
                "natalia@me.co", "Natalia50", "Nataliaalva", null));
        
        when(userRepository.findAll()).thenReturn(resulted);
        
        ArrayList<ProfessorDto> exit = new ArrayList<>();
        exit.add(new ProfessorDto(1L,"11","Juan carlos", "Gomez", 
                "juant@me.co", "Janco27", "Juanavid",null));
        exit.add(new ProfessorDto(2L,"12","Carlos mario", "Lopez", 
                "carlos@me.co", "Carl727", "Carlosthebest",null));
        exit.add(new ProfessorDto(3L,"13","Natalia", "Castano", 
                "natalia@me.co", "Natalia50", "Nataliaalva",null));
        
        ResponseEntity<?> expResult = new ResponseEntity<>(exit, HttpStatus.OK);
        ResponseEntity<?> result = null;
        try {
            result = userController.listAll();
        }
        catch(Exception e) {}
        
        List<ProfessorDto> BodyfromExpResult = (List<ProfessorDto>) expResult.getBody();
        List<ProfessorDto> BodyfromResult = (List<ProfessorDto>) result.getBody();
        
        assertEquals(result.getHeaders(), expResult.getHeaders());
        for (int i=0; i < BodyfromExpResult.size(); i++) {
            assertEquals(BodyfromExpResult.get(i).getId(), 
                    BodyfromResult.get(i).getId());
            assertEquals(BodyfromExpResult.get(i).getUsername(), 
                    BodyfromResult.get(i).getUsername());
            assertEquals(BodyfromExpResult.get(i).getPassword(), 
                    BodyfromResult.get(i).getPassword());
            assertEquals(BodyfromExpResult.get(i).getName(), 
                    BodyfromResult.get(i).getName());
            assertEquals(BodyfromExpResult.get(i).getLastname(), 
                    BodyfromResult.get(i).getLastname());
            assertEquals(BodyfromExpResult.get(i).getEmail(), 
                    BodyfromResult.get(i).getEmail());
        }
        
    }

}
