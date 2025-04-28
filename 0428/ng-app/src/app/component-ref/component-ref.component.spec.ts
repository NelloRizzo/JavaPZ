import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponentRefComponent } from './component-ref.component';

describe('ComponentRefComponent', () => {
  let component: ComponentRefComponent;
  let fixture: ComponentFixture<ComponentRefComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComponentRefComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ComponentRefComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
