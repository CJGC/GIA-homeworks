/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;

import co.edu.utp.isc.gia.examsapp.data.entity.Question;
import co.edu.utp.isc.gia.examsapp.data.repository.QuestionRepository;
import co.edu.utp.isc.gia.examsapp.validators.QuestionValidator;
import co.edu.utp.isc.gia.examsapp.web.dto.UniqueQuestionDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class UniqueQuestionService {
    
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final QuestionValidator questionValidator;
    
    public UniqueQuestionService(
            QuestionRepository questionRepository, 
            ModelMapper modelMapper,
            QuestionValidator questionValidator)
    {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
        this.questionValidator = questionValidator;
    }
    
    public UniqueQuestionDto save(UniqueQuestionDto question) throws Exception {        
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidationsExcept("id");
            Question auxUniqueQuestion = modelMapper.map(question ,Question.class);
            auxUniqueQuestion = questionRepository.save(auxUniqueQuestion);
            return modelMapper.map(auxUniqueQuestion, UniqueQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<UniqueQuestionDto> listAll() throws Exception {
        ArrayList<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        
        List<UniqueQuestionDto> questionsDto = new ArrayList<>();
        questions.forEach(question -> {
            questionsDto.add(modelMapper.map(question, UniqueQuestionDto.class));
        });
        return questionsDto;
    }
    
    public UniqueQuestionDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(questionRepository.findById(id).get(), 
                UniqueQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public UniqueQuestionDto update(UniqueQuestionDto question) throws Exception {
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidations();
            Question auxUniqueQuestion = questionRepository.save(modelMapper.map(question, 
                    Question.class));
            return modelMapper.map(auxUniqueQuestion, UniqueQuestionDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public UniqueQuestionDto delete(Long id) throws Exception {
        
        try {
            UniqueQuestionDto question = modelMapper.map(questionRepository.findById(id).get(), 
                    UniqueQuestionDto.class);
            questionRepository.deleteById(id);
            return question;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
