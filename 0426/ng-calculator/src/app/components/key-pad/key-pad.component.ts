import { Component } from '@angular/core';
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

}
