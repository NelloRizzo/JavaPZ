import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DiceClicked, DiceComponent } from './dice/dice.component';

@Component({
  selector: 'app-root',
  imports: [DiceComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  values: number[] = [0, 0, 0];
  get total() {
    return this.values.reduce((a, b) => a + b, 0);
  }
  sumValues(diceInfo: DiceClicked) {
    this.values[diceInfo.diceIndex] = diceInfo.value;
  }
}
