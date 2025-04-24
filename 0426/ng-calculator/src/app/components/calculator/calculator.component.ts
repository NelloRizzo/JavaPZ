import { Component } from '@angular/core';
import { DisplayComponent } from '../display/display.component';
import { KeyPadComponent } from '../key-pad/key-pad.component';

@Component({
  selector: 'app-calculator',
  imports: [DisplayComponent, KeyPadComponent],
  templateUrl: './calculator.component.html',
  styleUrl: './calculator.component.css'
})
export class CalculatorComponent {

}
