import { Component, EventEmitter, Output } from '@angular/core';
import { DigitComponent } from '../digit/digit.component';
import { UnaryOperatorComponent } from '../unary-operator/unary-operator.component';
import { BinaryOperatorComponent } from '../binary-operator/binary-operator.component';

@Component({
  selector: 'app-key-pad',
  imports: [DigitComponent, UnaryOperatorComponent, BinaryOperatorComponent],
  templateUrl: './key-pad.component.html',
  styleUrl: './key-pad.component.css'
})
export class KeyPadComponent {
  // Azioni:
  // 1. premere su una cifra
  //    comunicazione della cifra sulla quale si è cliccato
  @Output() digitClicked: EventEmitter<number> = new EventEmitter<number>();
  // 2. premere su un operatore binario
  //    comunicazione dell'operatore binario sul quale si è cliccato
  @Output() binaryOperatorClicked: EventEmitter<string> = new EventEmitter<string>();
  // 3. premere su un operatore unario
  //    comunicazione dell'operatore unario sul quale si è cliccato
  @Output() unaryOperatorClicked: EventEmitter<string> = new EventEmitter<string>();

  handleDigitClick(digit: number) {
    this.digitClicked.emit(digit);
  }
}
