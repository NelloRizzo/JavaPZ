import { Component } from '@angular/core';
import { DisplayComponent } from '../display/display.component';
import { KeyPadComponent } from '../key-pad/key-pad.component';
import { addDigit, CalculatorState, executeBinaryOperator, executeUnaryOperator, initialState } from '../../models/calculator-state';

@Component({
  selector: 'app-calculator',
  imports: [DisplayComponent, KeyPadComponent],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {
  state: CalculatorState = initialState;

  handleDigit(digit: number) {
    // devo cambiare lo stato in maniera da
    // aggiungere la cifra al display
    this.state = addDigit(this.state, digit);
  }
  handleBinary(operator: string) {
    this.state = executeBinaryOperator(this.state, operator);
  }
  handleUnary(operator: string) {
    this.state = executeUnaryOperator(this.state, operator);
  }
}
