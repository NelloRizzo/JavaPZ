import { Component } from '@angular/core';
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
  constructor(private italianCitiesService: ItalianCitiesService) { }
  
  ngOnInit() {
    this.italianCitiesService.getProvinces().subscribe({
      next: response => {
        this.provinces = response.data;
        console.log(this.provinces);
      }, 
      error: e => console.error(e)
    });
  }

  scrollRight(){
    const container = document.querySelector('.list') as HTMLElement;
    container.scrollLeft = container.scrollLeft + 100;
  }
  scrollLeft(){
    const container = document.querySelector('.list') as HTMLElement;
    container.scrollLeft = container.scrollLeft - 100;
  }
}
