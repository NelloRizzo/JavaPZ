import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCounterComponent } from './show-counter.component';

describe('ShowCounterComponent', () => {
  let component: ShowCounterComponent;
  let fixture: ComponentFixture<ShowCounterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowCounterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
