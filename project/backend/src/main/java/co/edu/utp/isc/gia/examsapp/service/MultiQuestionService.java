/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;


import co.edu.utp.isc.gia.examsapp.data.entity.Exam;
import co.edu.utp.isc.gia.examsapp.data.entity.Question;
import co.edu.utp.isc.gia.examsapp.data.repository.QuestionRepository;
import co.edu.utp.isc.gia.examsapp.validators.QuestionValidator;
import co.edu.utp.isc.gia.examsapp.web.dto.MultiQuestionDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author CJ
 */
@Service
public class MultiQuestionService {
    
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final QuestionValidator questionValidator;
    
    public MultiQuestionService(
            QuestionRepository questionRepository, 
            ModelMapper modelMapper,
            QuestionValidator questionValidator)
    {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
        this.questionValidator = questionValidator;
    }
    
    public MultiQuestionDto save(MultiQuestionDto question) throws Exception {        
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidationsExcept("id");
            Question auxMultQuestion = modelMapper.map(question ,Question.class);
            auxMultQuestion = questionRepository.save(auxMultQuestion);
            return modelMapper.map(auxMultQuestion, MultiQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<MultiQuestionDto> listAll() throws Exception {
        ArrayList<Question> questions = new ArrayList<>();
        questionRepository.findAll().forEach(questions::add);
        
        List<MultiQuestionDto> questionsDto = new ArrayList<>();
        questions.forEach(question -> {
            questionsDto.add(modelMapper.map(question, MultiQuestionDto.class));
        });
        return questionsDto;
    }
    
    public MultiQuestionDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(questionRepository.findById(id).get(), 
                MultiQuestionDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public MultiQuestionDto update(MultiQuestionDto question) throws Exception {
        try {
            this.questionValidator.setquestion(question);
            this.questionValidator.performValidations();
            Question auxMultQuestion = questionRepository.save(modelMapper.map(question, 
                    Question.class));
            return modelMapper.map(auxMultQuestion, MultiQuestionDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public MultiQuestionDto delete(Long id) throws Exception {
        
        try {
            MultiQuestionDto question = modelMapper.map(questionRepository.findById(id).get(), 
                    MultiQuestionDto.class);
            questionRepository.deleteById(id);
            return question;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
