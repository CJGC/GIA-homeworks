import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnswerOptionTableComponent } from './answer-option-table.component';

describe('AnswerOptionTableComponent', () => {
  let component: AnswerOptionTableComponent;
  let fixture: ComponentFixture<AnswerOptionTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnswerOptionTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnswerOptionTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
