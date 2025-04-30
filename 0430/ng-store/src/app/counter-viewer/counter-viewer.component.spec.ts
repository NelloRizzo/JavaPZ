import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CounterViewerComponent } from './counter-viewer.component';

describe('CounterViewerComponent', () => {
  let component: CounterViewerComponent;
  let fixture: ComponentFixture<CounterViewerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CounterViewerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CounterViewerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
