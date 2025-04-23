import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { DiceComponent } from './dice/dice.component';

@Component({
  selector: 'app-root',
  imports: [DiceComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'dices';
}
