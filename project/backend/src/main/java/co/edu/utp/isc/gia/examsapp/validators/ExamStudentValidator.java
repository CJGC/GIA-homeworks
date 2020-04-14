/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.validators;


import co.edu.utp.isc.gia.examsapp.web.dto.ExamStudentDto;

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
    
    public void validateDefinitiveGrade() throws Exception {
        if (this.examStudent.getDefinitive_grade() == null)
            throw new Exception("examStudent definitive grade is null");
    }

    public void validateStudent() throws Exception {
        if (this.examStudent.getStudent() == null)
            throw new Exception("examStudent student is null");
    }
    
    public void validateExam() throws Exception {
        if (this.examStudent.getExam() == null)
            throw new Exception("examStudent exam is null");
    }    
    
    public void performValidationsExcept(String attribute) throws Exception {
        this.isNull();
        if (!attribute.equals("id")) this.validateId();
        if (!attribute.equals("definitiveGrade")) this.validateDefinitiveGrade();
        if (!attribute.equals("student")) this.validateStudent();
        if (!attribute.equals("exam")) this.validateExam();
    }
    
    public void performValidations() throws Exception {
        this.isNull();
        this.validateId();
        this.validateDefinitiveGrade();
        this.validateStudent();
        this.validateExam();
    }
}
