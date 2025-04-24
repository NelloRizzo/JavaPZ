import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-digit',
  imports: [],
  templateUrl: './digit.component.html',
  styleUrl: './digit.component.css'
})
export class DigitComponent {
  @Input() digit: number = 0;
}
