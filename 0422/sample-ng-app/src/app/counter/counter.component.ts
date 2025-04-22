import { Component } from '@angular/core';
import { ShowCounterComponent } from '../show-counter/show-counter.component';
import { ManageCounterComponent } from '../manage-counter/manage-counter.component';

@Component({
  selector: 'app-counter',
  imports: [ShowCounterComponent, ManageCounterComponent],
  templateUrl: './counter.component.html',
  styleUrl: './counter.component.css'
})
export class CounterComponent {
  counter: number = 10;

  modify(v:number) {
    this.counter += v;
  }
}
