import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UiSampleComponent } from './ui-sample.component';

describe('UiSampleComponent', () => {
  let component: UiSampleComponent;
  let fixture: ComponentFixture<UiSampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UiSampleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UiSampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
