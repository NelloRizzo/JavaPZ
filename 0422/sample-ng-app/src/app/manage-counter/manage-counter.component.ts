import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-manage-counter',
  imports: [],
  templateUrl: './manage-counter.component.html',
  styleUrl: './manage-counter.component.css'
})
export class ManageCounterComponent {

  @Output()
  counterChanged = new EventEmitter<number>();

  increment() {
    this.counterChanged.emit(1);
  }
  decrement() {
    this.counterChanged.emit(-1);
  }
  decrement10() {
    this.counterChanged.emit(-10);
  }
}
