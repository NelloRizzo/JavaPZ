import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PromiseViewComponent } from './promise-view.component';

describe('PromiseViewComponent', () => {
  let component: PromiseViewComponent;
  let fixture: ComponentFixture<PromiseViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PromiseViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PromiseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
