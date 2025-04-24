import { Component } from '@angular/core';

@Component({
  selector: 'app-binary-operator',
  imports: [],
  templateUrl: './binary-operator.component.html',
  styleUrl: './binary-operator.component.css'
})
export class BinaryOperatorComponent {
operator: string = '+'; // Default operator is addition
}
