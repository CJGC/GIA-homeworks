/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;

import co.edu.utp.isc.gia.examsapp.data.entity.Question;
import co.edu.utp.isc.gia.examsapp.data.repository.QuestionRepository;
import co.edu.utp.isc.gia.examsapp.validators.QuestionValidator;
import co.edu.utp.isc.gia.examsapp.web.dto.OpenQuestionDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class OpenQuestionService {
    
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final QuestionValidator questionValidator;
    
    public OpenQuestionService(
            QuestionRepository questionRepository, 
            ModelMapper modelMapper,
            QuestionValidator questionValidator)
    {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
        this.questionValidator = questionValidator;
    }
    
    public OpenQuestionDto save(OpenQuestionDto question) throws Exception {        
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidationsExcept("id");
            Question auxOpenQuestion = modelMapper.map(question ,Question.class);
            auxOpenQuestion = questionRepository.save(auxOpenQuestion);
            return modelMapper.map(auxOpenQuestion, OpenQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<OpenQuestionDto> listAll() throws Exception {
        ArrayList<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        
        List<OpenQuestionDto> questionsDto = new ArrayList<>();
        questions.forEach(question -> {
            questionsDto.add(modelMapper.map(question, OpenQuestionDto.class));
        });
        return questionsDto;
    }
    
    public OpenQuestionDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(questionRepository.findById(id).get(), 
                OpenQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public OpenQuestionDto update(OpenQuestionDto question) throws Exception {
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidations();
            Question auxOpenQuestion = questionRepository.save(modelMapper.map(question, 
                    Question.class));
            return modelMapper.map(auxOpenQuestion, OpenQuestionDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public OpenQuestionDto delete(Long id) throws Exception {
        
        try {
            OpenQuestionDto question = modelMapper.map(questionRepository.findById(id).get(), 
                    OpenQuestionDto.class);
            questionRepository.deleteById(id);
            return question;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
