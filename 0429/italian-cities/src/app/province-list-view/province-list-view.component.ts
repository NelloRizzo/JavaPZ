import { Component, EventEmitter, Output } from '@angular/core';
import { ItalianCitiesService } from '../services/italian-cities.service';
import { Province } from '../services/models';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-province-list-view',
  imports: [NgFor],
  templateUrl: './province-list-view.component.html',
  styleUrl: './province-list-view.component.css'
})
export class ProvinceListViewComponent {
  title = 'Province d\'Italia';
  provinces: Province[] = [];

  @Output() selectedProvinceChanged: EventEmitter<Province> = new EventEmitter<Province>();

  constructor(private italianCitiesService: ItalianCitiesService) { }

  ngOnInit() {
    this.italianCitiesService.getProvinces().subscribe({
      next: response => {
        this.provinces = response.data;
      },
      error: e => console.error(e)
    });
  }

  scrollRight() {
    const container = document.querySelector('.province-list .list') as HTMLElement;
    container.scrollLeft = container.scrollLeft + 100;
  }
  scrollLeft() {
    const container = document.querySelector('.province-list .list') as HTMLElement;
    container.scrollLeft = container.scrollLeft - 100;
  }

  select(p: Province) {
    this.selectedProvinceChanged.emit(p);
  }

  onWheel(e: WheelEvent) {
    if (e.deltaY < 0)
      this.scrollLeft();
    else
      this.scrollRight()
  }
}
