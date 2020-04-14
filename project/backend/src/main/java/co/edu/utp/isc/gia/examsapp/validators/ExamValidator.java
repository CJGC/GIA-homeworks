/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;

import co.edu.utp.isc.gia.examsapp.data.entity.Question;
import co.edu.utp.isc.gia.examsapp.web.dto.ExamDto;
import co.edu.utp.isc.gia.examsapp.web.dto.abstractdto.QuestionDto;
import java.util.regex.Pattern;
import org.modelmapper.ModelMapper;

/**
 *
 * @author CJ
 */
public class ExamValidator {
    private ExamDto exam;
    private final ModelMapper modelMapper;
    private final QuestionValidator questionValidator;

    public ExamValidator() {
        this.modelMapper = new ModelMapper();
        this.questionValidator = new QuestionValidator();
    }
    
    public ExamDto getexam() {
        return exam;
    }

    public void setExam(ExamDto exam) {
        this.exam = exam;
    }
    
    public void isNull() throws Exception {
        if (this.exam == null)
            throw new Exception("exam object is null");
     }
    
    public void validateId() throws Exception {
        if (this.exam.getId() == null)
            throw new Exception("exam id is null");
    }
    
    public void validateName() throws Exception {
        if (this.exam.getName()== null)
            throw new Exception("exam name is null");
        if (Pattern.matches("", this.exam.getName()))
            throw new Exception ("exam name is empty");
    }
    
    public void validateLink() throws Exception {
        if (this.exam.getLink()== null)
            throw new Exception("exam link is null");
        if (Pattern.matches("", this.exam.getLink()))
            throw new Exception ("exam link is empty");
    }

    public void validateMaxGrade() throws Exception {
        if (this.exam.getMaxGrade() == null)
            throw new Exception("exam maxgrade is null");
    }
    
    public void validateDescription() throws Exception {
        if (this.exam.getDescription() == null)
            throw new Exception("exam description is null");
        if (Pattern.matches("", this.exam.getDescription()))
            throw new Exception ("exam description is empty");
    }
    
    public void validateExamtime() throws Exception {
        if (this.exam.getExamtime() == null)
            throw new Exception("exam time is null");
    }
    
    public void validateProfessor() throws Exception {
        if (this.exam.getProfessor() == null)
            throw new Exception("exam professor is null");
    };
    
    public void validateQuestions() throws Exception {
        for (Question qt : this.exam.getQuestions()) {
            this.questionValidator.setquestion(this.modelMapper.map(qt, 
                    QuestionDto.class));
            this.questionValidator.performValidationsExcept("id");
        }
    }
    
    public void validateExamStudents() throws Exception {
        //List<ExamStudent> examStudents;
    }    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("name")) this.validateName();
        if (!attribute.equals("link")) this.validateLink();
        if (!attribute.equals("maxgrade")) this.validateMaxGrade();
        if (!attribute.equals("description")) this.validateDescription();
        if (!attribute.equals("examtime")) this.validateExamtime();
        if (!attribute.equals("professor")) validateProfessor();
        if (!attribute.equals("questions")) this.validateQuestions();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateName();
        this.validateLink();
        this.validateMaxGrade();
        this.validateDescription();
        this.validateExamtime();
        validateProfessor();
        this.validateQuestions();
    }
}
