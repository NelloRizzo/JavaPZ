import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowContactComponent } from './show-contact.component';

describe('ShowContactComponent', () => {
  let component: ShowContactComponent;
  let fixture: ComponentFixture<ShowContactComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShowContactComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ShowContactComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
