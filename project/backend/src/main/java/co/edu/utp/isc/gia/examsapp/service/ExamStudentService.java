/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.service;

import co.edu.utp.isc.gia.examsapp.data.entity.ExamStudent;
import co.edu.utp.isc.gia.examsapp.data.entity.Student;
import co.edu.utp.isc.gia.examsapp.web.dto.ExamStudentDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.examsapp.data.repository.ExamStudentRepository;
import co.edu.utp.isc.gia.examsapp.validators.ExamStudentValidator;

/**
 *
 * @author CJ
 */
@Service
public class ExamStudentService {
    
    private final ExamStudentRepository examStudentRepository;
    private final ModelMapper modelMapper;
    private final ExamStudentValidator examStudentValidator;
    
    public ExamStudentService(
            ExamStudentRepository examStudentRepository, 
            ModelMapper modelMapper,
            ExamStudentValidator examStudentValidator)
    {
        this.examStudentRepository = examStudentRepository;
        this.modelMapper = modelMapper;
        this.examStudentValidator = examStudentValidator;
    }
    
    public ExamStudentDto save(ExamStudentDto examstudent) throws Exception {        
        try {
            this.examStudentValidator.setexamStudent(examstudent);
            this.examStudentValidator.performValidationsExcept("id");
            ExamStudent auxExamStud = modelMapper.map(examstudent, 
                    ExamStudent.class);
            auxExamStud = examStudentRepository.save(auxExamStud);
            return modelMapper.map(auxExamStud, ExamStudentDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public List<ExamStudentDto> listAll() throws Exception {
        ArrayList<ExamStudent> examstudents = new ArrayList<>();
        examStudentRepository.findAll().forEach(examstudents::add);
        
        List<ExamStudentDto> examstudentsDto = new ArrayList<>();
        examstudents.forEach(examstudent -> {
            examstudentsDto.add(modelMapper.map(examstudent, 
                    ExamStudentDto.class));
        });
        return examstudentsDto;
    }
    
    public ExamStudentDto findOne(Long id) throws Exception {
        try {
            return modelMapper.map(examStudentRepository.findById(id).get(), 
                ExamStudentDto.class);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ExamStudentDto update(ExamStudentDto examstudent) throws Exception {
        try {
            this.examStudentValidator.setexamStudent(examstudent);
            this.examStudentValidator.performValidations();
            ExamStudent auxExamStud = examStudentRepository.save(
                    modelMapper.map(examstudent, ExamStudent.class));
            return modelMapper.map(auxExamStud, ExamStudentDto.class);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }
    
    public ExamStudentDto delete(Long id) throws Exception {
        
        try {
            ExamStudentDto examstudent = modelMapper.map(
                    examStudentRepository.findById(id).get(),
                    ExamStudentDto.class);
            examStudentRepository.deleteById(id);
            return examstudent;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
