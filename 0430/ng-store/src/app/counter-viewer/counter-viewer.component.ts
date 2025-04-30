import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';
import { selectCounter } from '../../store/app-state-selectors';

@Component({
  selector: 'app-counter-viewer',
  imports: [AsyncPipe],
  templateUrl: './counter-viewer.component.html',
  styleUrl: './counter-viewer.component.css'
})
export class CounterViewerComponent {
  counter$: Observable<number>

  constructor(private store: Store) {
    this.counter$ = this.store.select(selectCounter);
  }

}
