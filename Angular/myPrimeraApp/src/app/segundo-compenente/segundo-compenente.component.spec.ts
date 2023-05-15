import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegundoCompenenteComponent } from './segundo-compenente.component';

describe('SegundoCompenenteComponent', () => {
  let component: SegundoCompenenteComponent;
  let fixture: ComponentFixture<SegundoCompenenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SegundoCompenenteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SegundoCompenenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
