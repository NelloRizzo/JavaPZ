import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BindColorComponent } from './bind-color.component';

describe('BindColorComponent', () => {
  let component: BindColorComponent;
  let fixture: ComponentFixture<BindColorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BindColorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BindColorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
