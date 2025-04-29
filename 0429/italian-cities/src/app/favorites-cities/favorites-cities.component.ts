import { Component } from '@angular/core';
import { FormatCityPipe } from '../pipes/format-city.pipe';
import { NgFor, NgIf } from '@angular/common';
import { City } from '../services/models';

@Component({
  selector: 'app-favorites-cities',
  imports: [FormatCityPipe, NgFor],
  templateUrl: './favorites-cities.component.html',
  styleUrl: './favorites-cities.component.css'
})
export class FavoritesCitiesComponent {
  cities: City[] = [];

  onDragOver(event: DragEvent) {
    event.preventDefault(); // questo abilita il passaggio del mouse e il drop
  }

  onDrop(event: DragEvent) {
    event.preventDefault();
    const json = event.dataTransfer?.getData('application/json');
    if (json) {
      const city: City = JSON.parse(json);
      this.cities.unshift(city);
    }
  }
}
