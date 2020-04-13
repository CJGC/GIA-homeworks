/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.AnswerOptionDto;
import java.util.regex.Pattern;

/**
 *
 * @author CJ
 */
public class AnswerOptionValidator {
    private AnswerOptionDto answerOption;

    public AnswerOptionDto getansweroption() {
        return answerOption;
    }

    public void setansweroption(AnswerOptionDto answerOption) {
        this.answerOption = answerOption;
    }
    
    public void isNull() throws Exception {
        if (this.answerOption == null)
            throw new Exception("answer option object is null");
     }
    
    public void validateId() throws Exception {
        if (this.answerOption.getId() == null)
            throw new Exception("answer option id is null");
    }

    public void validateIndex() throws Exception {
        if (this.answerOption.getIndex() == null)
            throw new Exception("answer option index is null");
        if (Pattern.matches("", this.answerOption.getIndex()))
            throw new Exception ("answer option index is empty");
    }
    
    public void validateDescription() throws Exception {
        if (this.answerOption.getDescription() == null)
            throw new Exception("answer option description is null");
        if (Pattern.matches("", this.answerOption.getDescription()))
            throw new Exception ("anwer option description is empty");
    }
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("index")) this.validateIndex();
        if (!attribute.equals("description")) this.validateDescription();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateIndex();
        this.validateDescription();
    }
}
