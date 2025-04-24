import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BinaryOperatorComponent } from './binary-operator.component';

describe('BinaryOperatorComponent', () => {
  let component: BinaryOperatorComponent;
  let fixture: ComponentFixture<BinaryOperatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BinaryOperatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BinaryOperatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
