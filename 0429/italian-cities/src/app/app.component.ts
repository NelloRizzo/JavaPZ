import { Component } from '@angular/core';
import { ProvinceListViewComponent } from './province-list-view/province-list-view.component';
import { CityListViewComponent } from './city-list-view/city-list-view.component';
import { Province } from './services/models';
import { FavoritesCitiesComponent } from './favorites-cities/favorites-cities.component';

@Component({
  selector: 'app-root',
  imports: [ProvinceListViewComponent, FavoritesCitiesComponent, CityListViewComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Esploriamo l\'Italia';
  province?: Province

  changeProvince(p: Province) {
    this.province = p;
  }
}
