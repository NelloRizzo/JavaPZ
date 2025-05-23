import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BinPipe } from './pipes/bin.pipe';
import { HexPipe } from './pipes/hex.pipe';
import { PadPipe } from './pipes/pad.pipe';
import { StringBlockPipe } from './pipes/string-block.pipe';
import { RomanPipe } from './pipes/roman.pipe';
import { LiteralPipe } from './pipes/literal.pipe';

@Component({
  selector: 'app-root',
  imports: [NgFor, NgIf, FormsModule, BinPipe, LiteralPipe, HexPipe, RomanPipe, StringBlockPipe, PadPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Esercizio su Pipes';
  from: number = 0;
  to: number = 10;

  get numbers(): number[] {
    return Array.from({ length: this.to - this.from + 1 },
      (_, i) => i + this.from);
  }
  get toSize(): number { return this.to.toString().length; }
}
