import { TestBed } from '@angular/core/testing';
import { ProfessorService } from '../../services/Professsor.service';

describe('UserTableService', () => {
  let service: ProfessorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfessorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
