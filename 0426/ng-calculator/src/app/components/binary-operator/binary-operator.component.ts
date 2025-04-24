import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-binary-operator',
  imports: [],
  templateUrl: './binary-operator.component.html',
  styleUrl: './binary-operator.component.css'
})
export class BinaryOperatorComponent {
  @Input() operator: string = '+';
  @Output() onClick: EventEmitter<string> = new EventEmitter<string>();

  handleClick() {
    this.onClick.emit(this.operator);
  }
}
