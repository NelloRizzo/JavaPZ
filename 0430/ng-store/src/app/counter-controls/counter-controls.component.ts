import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { ApplicationState } from '../../store/app-state';
import { decrement, increment, incrementBy, reset } from '../../store/app-state-actions';

@Component({
  selector: 'app-counter-controls',
  imports: [],
  templateUrl: './counter-controls.component.html',
  styleUrl: './counter-controls.component.css'
})
export class CounterControlsComponent {
  constructor(private store: Store<ApplicationState>) { }

  onIncrement() {
    this.store.dispatch(increment())
  }
  onIncrementBy10() {
    this.store.dispatch(incrementBy({ amount: 10 }))
  }
  onDecrement() {
    this.store.dispatch(decrement())
  }
  onReset() {
    this.store.dispatch(reset())
  }
}
