import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeliculaPiezaComponent } from './pelicula-pieza.component';

describe('PeliculaPiezaComponent', () => {
  let component: PeliculaPiezaComponent;
  let fixture: ComponentFixture<PeliculaPiezaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PeliculaPiezaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PeliculaPiezaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
