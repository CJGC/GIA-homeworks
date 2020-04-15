import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserFormularyComponent } from './user-formulary.component';

describe('UserFormularyComponent', () => {
  let component: UserFormularyComponent;
  let fixture: ComponentFixture<UserFormularyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserFormularyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserFormularyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
