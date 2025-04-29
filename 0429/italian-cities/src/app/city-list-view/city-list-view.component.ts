import { NgFor, NgIf } from '@angular/common';
import { Component, Input, SimpleChanges } from '@angular/core';
import { City, Province } from '../services/models';
import { ItalianCitiesService } from '../services/italian-cities.service';

@Component({
  selector: 'app-city-list-view',
  imports: [NgIf, NgFor],
  templateUrl: './city-list-view.component.html',
  styleUrl: './city-list-view.component.css'
})
export class CityListViewComponent {
  @Input() province?: Province;
  cities: City[] = [];
  dragging: boolean = false;

  constructor(private italianCitiesService: ItalianCitiesService) { }

  gmaps(c: City): string {
    return `https://www.google.com/maps/search/?api=1&query=${c.name},${c.province.name}`;
  }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['province'] && this.province) {
      this.italianCitiesService.getcitiesByProvince(this.province?.acronym!)
        .subscribe(d => this.cities = d.data);
    }
  }

  onDragStart(event: DragEvent, city: City) {
    const data = JSON.stringify(city);
    event.dataTransfer?.setData('application/json', data);
  }
}