import { Component, Input } from '@angular/core';
import Fraction from '../../model/fraction';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-fraction',
  imports: [NgIf],
  templateUrl: './fraction.component.html',
  styleUrl: './fraction.component.css'
})
export class FractionComponent {

  @Input()
  fraction?: Fraction

  @Input()
  showSignum: boolean = false
}
