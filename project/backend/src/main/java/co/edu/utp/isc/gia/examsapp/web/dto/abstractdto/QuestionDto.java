/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.examsapp.web.dto.abstractdto;

import co.edu.utp.isc.gia.examsapp.web.dto.AnswerOptionDto;
import co.edu.utp.isc.gia.examsapp.web.dto.ExamDto;
import co.edu.utp.isc.gia.examsapp.web.dto.OpenResponseDto;
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
    private ExamDto exam;
    private List<AnswerOptionDto> answerOption;
    private List<OpenResponseDto> openResponse;
}
