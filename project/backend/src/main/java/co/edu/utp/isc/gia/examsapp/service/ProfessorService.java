/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;

import co.edu.utp.isc.gia.examsapp.data.entity.Professor;
import co.edu.utp.isc.gia.examsapp.web.dto.ProfessorDto;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.examsapp.data.repository.ProfessorRepository;

/**
 *
 * @author CJ
 */
@Service
public class ProfessorService {
    
    private ProfessorRepository userRepository;
    private ModelMapper modelMapper;
    
    public ProfessorService(ProfessorRepository userRepository, ModelMapper modelMapper)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    
    public ProfessorDto save(ProfessorDto user) {
                
        try {
            user.setUsername(user.getUsername().toLowerCase());
            Professor auxUser = userRepository.save(modelMapper.map(user, 
                    Professor.class));
            return modelMapper.map(auxUser, ProfessorDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public List<ProfessorDto> listAll() {
        ArrayList<Professor> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        
        List<ProfessorDto> resp = new ArrayList<>();
        users.forEach(user -> {
            resp.add(modelMapper.map(user, ProfessorDto.class));
        });
        return resp;
    }
    
    public ProfessorDto findOne(Long id) {
        try {
            return modelMapper.map(userRepository.findById(id).get(), 
                ProfessorDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ProfessorDto update(long id, ProfessorDto user) {
        user.setId(id);
        try {
            userRepository.save(modelMapper.map(user, Professor.class));
            return user;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ProfessorDto delete(Long id) {
        
        try {
            ProfessorDto user = modelMapper.map(userRepository.findById(id).get(), 
                    ProfessorDto.class);
            userRepository.deleteById(id);
            return user;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
