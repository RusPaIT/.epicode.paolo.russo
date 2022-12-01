import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardSingolaComponent } from './card-singola.component';

describe('CardSingolaComponent', () => {
  let component: CardSingolaComponent;
  let fixture: ComponentFixture<CardSingolaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardSingolaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardSingolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
