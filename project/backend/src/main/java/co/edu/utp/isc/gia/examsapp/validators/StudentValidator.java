/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.StudentDto;
import java.util.regex.Pattern;

/**
 *
 * @author CJ
 */
public class StudentValidator {
    private StudentDto student;

    public StudentDto getstudent() {
        return student;
    }

    public void setstudent(StudentDto student) {
        this.student = student;
    }
    
    public void isNull() throws Exception {
        if (this.student == null)
            throw new Exception("student object is null");
     }
    
    public void validateId() throws Exception {
        if (this.student.getId() == null)
            throw new Exception("student's id is null");
    }

    public void validateIdentificationCard() throws Exception {
        if (this.student.getIdentificationCard()== null)
            throw new Exception("student's identification card is null");
        if (Pattern.matches("", this.student.getIdentificationCard()))
            throw new Exception ("student's identification card is empty");
        if (!Pattern.matches("[0-9]+", this.student.getIdentificationCard()))
            throw new Exception("student's identification card is not a number");
    }
    
    public void validateName() throws Exception {
        if (this.student.getName()== null)
            throw new Exception("student's name is null");
        if (Pattern.matches("", this.student.getName()))
            throw new Exception ("student's name is empty");
    }

    public void validateLastname() throws Exception {
        if (this.student.getLastname()== null)
            throw new Exception("student's lastname is null");
        if (Pattern.matches("", this.student.getLastname()))
            throw new Exception ("student's lastname is empty");
    }
    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("identificationCard")) this.validateIdentificationCard();
        if (!attribute.equals("name")) this.validateName();
        if (!attribute.equals("lastname")) this.validateLastname();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateIdentificationCard();
        this.validateName();
        this.validateLastname();

    }
}
