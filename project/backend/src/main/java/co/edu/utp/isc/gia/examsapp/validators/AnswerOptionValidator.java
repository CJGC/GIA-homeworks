/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.data.entity.SelectedResponse;
import co.edu.utp.isc.gia.examsapp.web.dto.AnswerOptionDto;
import co.edu.utp.isc.gia.examsapp.web.dto.SelectedResponseDto;
import co.edu.utp.isc.gia.examsapp.web.dto.abstractdto.QuestionDto;
import java.util.regex.Pattern;
import org.modelmapper.ModelMapper;

/**
 *
 * @author CJ
 */
public class AnswerOptionValidator {
    private AnswerOptionDto answerOption;
    private final SelectedResponseValidator selecRespValidator;
    private final QuestionValidator questionValidator;
    private final ModelMapper modelMapper;
    
    public AnswerOptionValidator(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.selecRespValidator = new SelectedResponseValidator();
        this.questionValidator = new QuestionValidator();
    }

    public AnswerOptionDto getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(AnswerOptionDto answerOption) {
        this.answerOption = answerOption;
    }
    
    public void isNull() throws Exception {
        if (this.answerOption == null)
            throw new Exception("AnswerOption object is null");
     }
    
    public void validateId() throws Exception {
        if (this.answerOption.getId() == null)
            throw new Exception("AnswerOption id is null");
    }

    public void validateIndex() throws Exception {
        if (this.answerOption.getIndex() == null)
            throw new Exception("AnswerOption index is null");
        if (Pattern.matches("", this.answerOption.getIndex()))
            throw new Exception ("AnswerOption index is empty");
    }
    
    public void validateDescription() throws Exception {
        if (this.answerOption.getDescription() == null)
            throw new Exception("AnswerOption description is null");
        if (Pattern.matches("", this.answerOption.getDescription()))
            throw new Exception ("AnswerOption description is empty");
    }
    
    public void validateCorrectAnswer() throws Exception {
        if (this.answerOption.getCorrectAnswer() == null)
            throw new Exception("AnswerOption correctAnswer is null");
    }
    
    public void validateWeight() throws Exception {
        if (this.answerOption.getWeight() == null)
            throw new Exception("AnswerOption is null");
    }
    
    public void validateSelectedResponses() throws Exception {
        
        for (SelectedResponse sr : this.answerOption.getSelectedResponses()) {
            selecRespValidator.setselectedResponse(this.modelMapper.map(sr, 
                    SelectedResponseDto.class));
            selecRespValidator.performValidationsExcept("id");
        }
    }

    public void validateQuestion() throws Exception {
        if (this.answerOption.getQuestion() == null)
            throw new Exception("AnswerOption question is null");
        this.questionValidator.setquestion(this.modelMapper.map(
        this.answerOption.getQuestion(), QuestionDto.class));
    }
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("index")) this.validateIndex();
        if (!attribute.equals("description")) this.validateDescription();
        if (!attribute.equals("correctAnswer")) this.validateCorrectAnswer();
        if (!attribute.equals("weight")) this.validateWeight();
        if (!attribute.equals("selectedResponses")) this.validateSelectedResponses();
        if (!attribute.equals("question")) this.validateQuestion();
    }
    
    public void performValidations() throws Exception {
        this.validateId();
        this.validateIndex();
        this.validateDescription();
        this.validateCorrectAnswer();
        this.validateWeight();
        this.validateSelectedResponses();
        this.validateQuestion();
    }
}
