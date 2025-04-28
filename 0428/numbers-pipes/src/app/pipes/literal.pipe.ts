import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'literal'
})
export class LiteralPipe implements PipeTransform {

  private translate(value?: number): string {
    if (!value || value === 0) return '';
    if (value < 20) return ['uno', 'due', 'tre', 'quattro', 'cinque', 'sei', 'sette', 'otto', 'nove', 'dieci',
      'undici', 'dodici', 'tredici', 'quattordici', 'quindici', 'sedici', 'diciassette', 'diciotto', 'diciannove'][value - 1];
    if (value < 100) {
      const units = value % 10;
      const tens = Math.floor(value / 10);
      return ['venti', 'trenta', 'quaranta', 'cinquanta', 'sessanta', 'settanta', 'ottanta', 'novanta'][tens - 2] +
        this.translate(units)
    }
    if (value < 1000) {
      const hundreds = Math.floor(value / 100);
      const tens = value % 100;
      return ['cento', 'duecento', 'trecento', 'quattrocento', 'cinquecento', 'seicento', 'settecento', 'ottocento', 'novecento'][hundreds - 1] +
        this.translate(tens)
    }
    if (value < 1000000) {
      const thousands = Math.floor(value / 1000);
      const hundreds = value % 1000;
      if (thousands === 1) return 'mille' + this.translate(hundreds);
      return this.translate(thousands) + 'mila' + this.translate(hundreds) ;
    }
    return 'N/A'
  }

  transform(value: number): string {
    if (value === 0) return 'zero';
    if (value < 0) return 'meno ' + this.translate(-value);
    return this.translate(value)
      .replace('iu', 'u')
      .replace('io', 'o')
      .replace('au', 'u')
      .replace('ao', 'o');
  }

}
