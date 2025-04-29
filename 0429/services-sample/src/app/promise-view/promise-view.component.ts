import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { PromiseSampleService } from '../promise-sample.service';

@Component({
  selector: 'app-promise-view',
  imports: [NgIf],
  templateUrl: './promise-view.component.html',
  styleUrl: './promise-view.component.scss'
})
export class PromiseViewComponent {
  data?: string;

  constructor(private promiseSampleService: PromiseSampleService) { }

  async getData() {
    try {
      this.data = await this.promiseSampleService.getData();
    } catch (e) {
      this.data = "ERRORE";
      console.error('Error loading data:', e);
    }
  }

  ngOnInit() {
    this.promiseSampleService.getData()
      .then(d => {
        this.data = d;
      })
      .catch(e => {
        this.data = "ERRORE";
        console.error('Error loading data:', e);
      })
  }
}
