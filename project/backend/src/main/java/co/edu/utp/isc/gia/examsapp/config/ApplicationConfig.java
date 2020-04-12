package co.edu.utp.isc.gia.examsapp.config;


import co.edu.utp.isc.gia.examsapp.validators.AnswerOptionValidator;
import co.edu.utp.isc.gia.examsapp.validators.ExamValidator;
import co.edu.utp.isc.gia.examsapp.validators.ProfessorValidator;
import co.edu.utp.isc.gia.examsapp.validators.QuestionValidator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CJ
 */
@Configuration
public class ApplicationConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
    public ProfessorValidator professorValidator() {
        return new ProfessorValidator();
    }
    
    @Bean
    public ExamValidator examValidator() {
        return new ExamValidator();
    }
    
    @Bean
    public QuestionValidator questionValidator() {
        return new QuestionValidator();
    }
    
    @Bean
    public AnswerOptionValidator answerOptionValidator() {
        return new AnswerOptionValidator();
    }
}
