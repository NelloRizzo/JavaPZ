import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import Fraction from '../model/fraction';
import { FractionComponent } from './fraction/fraction.component';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, FractionComponent, NgFor],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'fractions';
  fractions = [Fraction.of('1/3')
    , Fraction.from(1.235)
    , Fraction.from(1, -4)
    , Fraction.from(1)
  ]
}
