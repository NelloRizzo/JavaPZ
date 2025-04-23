import { Component } from '@angular/core';

@Component({
  selector: 'app-dice',
  imports: [],
  templateUrl: './dice.component.html',
  styleUrl: './dice.component.scss'
})
export class DiceComponent {
  value?: number;

  rollDice() {
    this.value = Math.floor(Math.random() * 6) + 1;
  }
}
