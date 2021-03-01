import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogtextComponent } from './logtext.component';

describe('LogtextComponent', () => {
  let component: LogtextComponent;
  let fixture: ComponentFixture<LogtextComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogtextComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogtextComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
