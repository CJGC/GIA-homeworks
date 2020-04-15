import { ExamDto } from '../ExamDto';
import { OpenResponseDto } from '../OpenResponseDto';

export abstract class QuestionDto {

    private id : number;
    private questionType : String;
    private weight : number;
    private description : String;
    private questionImage : File;
    private exam : ExamDto;
    private openResponse : Array<OpenResponseDto>;

}
