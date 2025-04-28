import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StructuralSampleComponent } from './structural-sample.component';

describe('StructuralSampleComponent', () => {
  let component: StructuralSampleComponent;
  let fixture: ComponentFixture<StructuralSampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StructuralSampleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StructuralSampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
