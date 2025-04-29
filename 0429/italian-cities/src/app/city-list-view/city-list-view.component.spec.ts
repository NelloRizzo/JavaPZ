import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CityListViewComponent } from './city-list-view.component';

describe('CityListViewComponent', () => {
  let component: CityListViewComponent;
  let fixture: ComponentFixture<CityListViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CityListViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CityListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
