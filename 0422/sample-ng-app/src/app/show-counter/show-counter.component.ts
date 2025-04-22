import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-show-counter',
  imports: [],
  templateUrl: './show-counter.component.html',
  styleUrl: './show-counter.component.css'
})
export class ShowCounterComponent {
  @Input()
  counter: number = 0;
}
