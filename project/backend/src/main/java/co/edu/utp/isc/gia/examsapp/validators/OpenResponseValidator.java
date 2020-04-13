/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.OpenResponseDto;
import java.util.regex.Pattern;

/**
 *
 * @author CJ
 */
public class OpenResponseValidator {
    private OpenResponseDto openResponse;

    public OpenResponseDto getopenResponse() {
        return openResponse;
    }

    public void setopenResponse(OpenResponseDto openResponse) {
        this.openResponse = openResponse;
    }
    
    public void isNull() throws Exception {
        if (this.openResponse == null)
            throw new Exception("openResponse object is null");
     }
    
    public void validateId() throws Exception {
        if (this.openResponse.getId() == null)
            throw new Exception("openResponse id is null");
    }

    public void validateContent() throws Exception {
        if (this.openResponse.getContent() == null)
            throw new Exception("openResponse's identification card is null");
        if (Pattern.matches("", this.openResponse.getContent()))
            throw new Exception ("openResponse's identification card is empty");
        if (!Pattern.matches("[0-9]+", this.openResponse.getContent()))
            throw new Exception("openResponse's identification card is not a number");
    }
    
    public void validateValoration() throws Exception {
        if (this.openResponse.getValoration() == null)
            throw new Exception("valoration is null");
    }

    public void validateExamStudent() throws Exception {
        if (this.openResponse.getExamStudent() == null)
            throw new Exception("examen student is null");
    }
    
    public void validateQuestion() throws Exception {
        if (this.openResponse.getExamStudent() == null)
            throw new Exception("question is null");
    }    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("content")) this.validateContent();
        if (!attribute.equals("valoration")) this.validateValoration();
        if (!attribute.equals("examstudent")) this.validateExamStudent();
        if (!attribute.equals("question")) this.validateQuestion();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateContent();
        this.validateValoration();
        this.validateExamStudent();
        this.validateQuestion();
    }
}