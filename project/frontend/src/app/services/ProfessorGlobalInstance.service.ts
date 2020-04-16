import { Injectable } from '@angular/core';
import { ProfessorDto } from '../dto/ProfessorDto';

@Injectable()
export class ProfessorGlobalInstance {

    public professor: ProfessorDto;

    constructor() {
    }

    public getProfessorInstance(): ProfessorDto {
        return this.professor;
    }

    public setProfessorInstance(professor: ProfessorDto): void {
        this.professor = professor;
    }
}