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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.examsapp.data.repository.ProfessorRepository;
import co.edu.utp.isc.gia.examsapp.validators.ProfessorValidator;

/**
 *
 * @author CJ
 */
@Service
public class ProfessorService {
    
    private final ProfessorRepository userRepository;
    private final ModelMapper modelMapper;
    private final ProfessorValidator ProfessorValidator;
    
    public ProfessorService(
            ProfessorRepository userRepository, 
            ModelMapper modelMapper,
            ProfessorValidator professorValidator)
    {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.ProfessorValidator = professorValidator;
    }
    
    public ProfessorDto save(ProfessorDto professor) throws Exception {        
        try {
            this.ProfessorValidator.setProfessor(professor);
            this.ProfessorValidator.performValidationsExcept("id");
            Professor auxProf = modelMapper.map(professor ,Professor.class);
            auxProf = userRepository.save(auxProf);
            return modelMapper.map(auxProf, ProfessorDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<ProfessorDto> listAll() throws Exception {
        ArrayList<Professor> professors = new ArrayList<>();
        userRepository.findAll().forEach(professors::add);
        
        List<ProfessorDto> professorsDto = new ArrayList<>();
        professors.forEach(professor -> {
            professorsDto.add(modelMapper.map(professor, ProfessorDto.class));
        });
        return professorsDto;
    }
    
    public ProfessorDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(userRepository.findById(id).get(), 
                ProfessorDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ProfessorDto update(ProfessorDto professor) throws Exception {
        try {
            this.ProfessorValidator.setProfessor(professor);
            this.ProfessorValidator.performValidations();
            Professor auxProf = userRepository.save(modelMapper.map(professor, 
                    Professor.class));
            return modelMapper.map(auxProf, ProfessorDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public ProfessorDto delete(Long id) throws Exception {
        
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
    
    public ProfessorDto findByUsername(String username) throws Exception {
        
        try{
           return modelMapper.map(userRepository.findByUsername(username), 
                ProfessorDto.class);
        }
        catch(Exception e) {
            System.out.print(e.getMessage());
            return null;
        }
    }
}
