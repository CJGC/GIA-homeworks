/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;

import co.edu.utp.isc.gia.examsapp.data.entity.AnswerOption;
import co.edu.utp.isc.gia.examsapp.validators.AnswerOptionValidator;
import co.edu.utp.isc.gia.examsapp.web.dto.AnswerOptionDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.examsapp.data.repository.AnswerOptionRepository;

/**
 *
 * @author CJ
 */
@Service
public class AnswerOptionService {
    
    private final AnswerOptionRepository answerOptionRepository;
    private final ModelMapper modelMapper;
    private final AnswerOptionValidator answerOptionValidator;
    
    public AnswerOptionService(
            AnswerOptionRepository answerOptionRepository, 
            ModelMapper modelMapper,
            AnswerOptionValidator answerOptionValidator)
    {
        this.answerOptionRepository = answerOptionRepository;
        this.modelMapper = modelMapper;
        this.answerOptionValidator = answerOptionValidator;
    }
    
    public AnswerOptionDto save(AnswerOptionDto answerOption) throws Exception {        
        try {
            this.answerOptionValidator.setansweroption(answerOption);
            this.answerOptionValidator.performValidationsExcept("id");
            AnswerOption auxAnswerOption = modelMapper.map(answerOption ,AnswerOption.class);
            auxAnswerOption = answerOptionRepository.save(auxAnswerOption);
            return modelMapper.map(auxAnswerOption, AnswerOptionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<AnswerOptionDto> listAll() throws Exception {
        ArrayList<AnswerOption> answerOptions = new ArrayList<>();
        answerOptionRepository.findAll().forEach(answerOptions::add);
        
        List<AnswerOptionDto> answerOptionssDto = new ArrayList<>();
        answerOptions.forEach(answerOption -> {
            answerOptionssDto.add(modelMapper.map(answerOption, AnswerOptionDto.class));
        });
        return answerOptionssDto;
    }
    
    public AnswerOptionDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(answerOptionRepository.findById(id).get(), 
                AnswerOptionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public AnswerOptionDto update(AnswerOptionDto answerOption) throws Exception {
        try {
            this.answerOptionValidator.setansweroption(answerOption);
            this.answerOptionValidator.performValidations();
            AnswerOption auxAnswerOption = answerOptionRepository.save(modelMapper.map(answerOption, 
                    AnswerOption.class));
            return modelMapper.map(auxAnswerOption, AnswerOptionDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public AnswerOptionDto delete(Long id) throws Exception {
        
        try {
            AnswerOptionDto answerOption = modelMapper.map(answerOptionRepository.findById(id).get(), 
                    AnswerOptionDto.class);
            answerOptionRepository.deleteById(id);
            return answerOption;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
