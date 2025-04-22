import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookViewComponent } from './book-view.component';

describe('BookViewComponent', () => {
  let component: BookViewComponent;
  let fixture: ComponentFixture<BookViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BookViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
