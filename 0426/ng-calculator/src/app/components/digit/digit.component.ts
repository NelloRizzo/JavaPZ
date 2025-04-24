import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-digit',
  imports: [],
  templateUrl: './digit.component.html',
  styleUrl: './digit.component.css'
})
export class DigitComponent {
  @Input() digit: number = 0;
  @Output() onClick: EventEmitter<number> = new EventEmitter<number>();

  handleClick() {
    this.onClick.emit(this.digit);
  }
}
