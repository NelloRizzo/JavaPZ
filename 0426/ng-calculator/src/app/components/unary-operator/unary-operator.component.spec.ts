import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnaryOperatorComponent } from './unary-operator.component';

describe('UnaryOperatorComponent', () => {
  let component: UnaryOperatorComponent;
  let fixture: ComponentFixture<UnaryOperatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnaryOperatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UnaryOperatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
