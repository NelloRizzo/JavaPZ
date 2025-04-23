import { Component, EventEmitter, Input, Output } from '@angular/core';

export interface DiceClicked {
  diceIndex: number;
  value: number;
}

@Component({
  selector: 'app-dice',
  imports: [],
  templateUrl: './dice.component.html',
  styleUrl: './dice.component.scss'
})
export class DiceComponent {
  value?: number;

  @Input()
  diceIndex: number = 0;

  @Output()
  diceValueChanged = new EventEmitter<DiceClicked>();

  get imageUrl() {
    return this.value ? `dices/dice${this.value}.png` : 'dices/dice_.png';
  }

  private counter: number = 0;
  rollDice() {
    let interval = setInterval(() => {
      this.value = Math.floor(Math.random() * 6) + 1;
      this.counter++;
      if (this.counter > 10) {
        clearInterval(interval);
        this.counter = 0;
        this.diceValueChanged.emit({
          diceIndex: this.diceIndex,
          value: this.value!
        });
      }
    }, 100)
  }
}
