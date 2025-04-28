import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'roman'
})
export class RomanPipe implements PipeTransform {

  transform(value: number): string {
    if (value < 1 || value > 3999) return 'N/A';
    const romanliterals: { value: number, literal: string }[] = [
      { value: 1000, literal: 'M' },
      { value: 900, literal: 'CM' },
      { value: 500, literal: 'D' },
      { value: 400, literal: 'CD' },
      { value: 100, literal: 'C' },
      { value: 90, literal: 'XC' },
      { value: 50, literal: 'L' },
      { value: 40, literal: 'XL' },
      { value: 10, literal: 'X' },
      { value: 9, literal: 'IX' },
      { value: 5, literal: 'V' },
      { value: 4, literal: 'IV' },
      { value: 1, literal: 'I' }
    ];
    return romanliterals.reduce((acc, n) => {
      const numKey = n.value
      while (value >= numKey) {
        acc += n.literal;
        value -= numKey;
      }
      return acc;
    }, '')
  }

}
