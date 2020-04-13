/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.dto;

import co.edu.utp.isc.gia.examsapp.data.entity.Exam;
import co.edu.utp.isc.gia.examsapp.data.entity.OpenResponse;
import co.edu.utp.isc.gia.examsapp.data.entity.Student;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author CJ
 */
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class ExamStudentDto implements Serializable {
    
    private Long id;
    private Double definitive_grade;
    private List<OpenResponse> openResponses;
    private Student student;
    private Exam exam;
}
