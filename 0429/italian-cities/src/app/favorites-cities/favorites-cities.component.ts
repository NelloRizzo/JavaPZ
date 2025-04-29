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
    event.preventDefault(); // fondamentale
  }

  onDrop(event: DragEvent) {
    event.preventDefault();
    const json = event.dataTransfer?.getData('application/json');
    if (json) {
      const obj: City = JSON.parse(json);
      this.cities.push(obj);
    }
  }
}
