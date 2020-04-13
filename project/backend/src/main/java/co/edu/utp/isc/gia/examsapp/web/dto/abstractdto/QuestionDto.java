/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.dto.abstractdto;

import co.edu.utp.isc.gia.examsapp.data.entity.AnswerOption;
import co.edu.utp.isc.gia.examsapp.data.entity.Exam;
import co.edu.utp.isc.gia.examsapp.data.entity.OpenResponse;
import java.io.File;
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
public abstract class QuestionDto {
    
    private Long id;
    private String questionType;
    private Double weight;
    private String description;
    private File questionImage;
    private Exam exam;
    private List<AnswerOption> answerOption;
    private List<OpenResponse> openResponse;
}
