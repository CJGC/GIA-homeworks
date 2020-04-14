/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.SelectedResponseDto;

/**
 *
 * @author CJ
 */
public class SelectedResponseValidator {
    private SelectedResponseDto selectedResponse;

    public SelectedResponseDto getselectedResponse() {
        return selectedResponse;
    }

    public void setselectedResponse(SelectedResponseDto selectedResponse) {
        this.selectedResponse = selectedResponse;
    }
    
    public void isNull() throws Exception {
        if (this.selectedResponse == null)
            throw new Exception("SelectedResponse object is null");
     }
    
    public void validateId() throws Exception {
        if (this.selectedResponse.getId() == null)
            throw new Exception("SelectedResponse id is null");
    }
    
    public void validateValoration() throws Exception {
        if (this.selectedResponse.getValoration() == null)
            throw new Exception("SelectedResponse valoration is null");
    }

    public void validateExamStudent() throws Exception {
        if (this.selectedResponse.getExamStudent() == null)
            throw new Exception("SelectedResponse examenStudent is null");
    }

    public void validateAnswerOption() throws Exception {
        if (this.selectedResponse.getAnswerOption() == null)
            throw new Exception("SelectedResponse answerOption is null");
    }
    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("answerOption")) this.validateAnswerOption();
        if (!attribute.equals("valoration")) this.validateValoration();
        if (!attribute.equals("examstudent")) this.validateExamStudent();
        if (!attribute.equals("answerOption")) this.validateAnswerOption();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateValoration();
        this.validateExamStudent();
        this.validateAnswerOption();
        this.validateAnswerOption();
    }
}