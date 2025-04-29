import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoritesCitiesComponent } from './favorites-cities.component';

describe('FavoritesCitiesComponent', () => {
  let component: FavoritesCitiesComponent;
  let fixture: ComponentFixture<FavoritesCitiesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FavoritesCitiesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FavoritesCitiesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
