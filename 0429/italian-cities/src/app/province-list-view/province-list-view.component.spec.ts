import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProvinceListViewComponent } from './province-list-view.component';

describe('ProvinceListViewComponent', () => {
  let component: ProvinceListViewComponent;
  let fixture: ComponentFixture<ProvinceListViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProvinceListViewComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProvinceListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
