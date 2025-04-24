import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-unary-operator',
  imports: [],
  templateUrl: './unary-operator.component.html',
  styleUrl: './unary-operator.component.css'
})
export class UnaryOperatorComponent {
  @Input() operator: string = 'sqrt'; // Default operator is square root
  @Output() onClick: EventEmitter<string> = new EventEmitter<string>();
  
  handleClick() {
    this.onClick.emit(this.operator);
  }
}
