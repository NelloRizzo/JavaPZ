import { Component } from '@angular/core';

@Component({
  selector: 'app-unary-operator',
  imports: [],
  templateUrl: './unary-operator.component.html',
  styleUrl: './unary-operator.component.css'
})
export class UnaryOperatorComponent {
  operator: string = 'sqrt'; // Default operator is square root
}
