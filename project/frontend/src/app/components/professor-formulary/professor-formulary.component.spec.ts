import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorFormularyComponent } from './professor-formulary.component';

describe('ProfessorFormularyComponent', () => {
  let component: ProfessorFormularyComponent;
  let fixture: ComponentFixture<ProfessorFormularyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfessorFormularyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorFormularyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
