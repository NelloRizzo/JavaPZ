import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigitComponent } from './digit.component';

describe('DigitComponent', () => {
  let component: DigitComponent;
  let fixture: ComponentFixture<DigitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DigitComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DigitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
