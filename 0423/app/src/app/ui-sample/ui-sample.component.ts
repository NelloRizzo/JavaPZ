import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-ui-sample',
  imports: [],
  templateUrl: './ui-sample.component.html',
  styleUrl: './ui-sample.component.scss'
})
export class UiSampleComponent {
  counter: number = 0;
  
  @Output()
  incrementClicked: EventEmitter<number>= new EventEmitter<number>();

  increment() {
    this.counter++;
    console.log('Counter incremented:', this.counter);
    this.incrementClicked.emit(this.counter);
  }
  decrement() {
    this.counter--;
    console.log('Counter decremented:', this.counter);
  }
}
