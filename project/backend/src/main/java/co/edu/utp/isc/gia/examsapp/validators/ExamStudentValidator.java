/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.ExamStudentDto;
import java.util.regex.Pattern;

/**
 *
 * @author CJ
 */
public class ExamStudentValidator {
    private ExamStudentDto examStudent;

    public ExamStudentDto getexamStudent() {
        return examStudent;
    }

    public void setexamStudent(ExamStudentDto examStudent) {
        this.examStudent = examStudent;
    }
    
    public void isNull() throws Exception {
        if (this.examStudent == null)
            throw new Exception("examStudent object is null");
     }
    
    public void validateId() throws Exception {
        if (this.examStudent.getId() == null)
            throw new Exception("examStudent id is null");
    }    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
    }
}
