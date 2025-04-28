import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'range'
})
export class RangePipe implements PipeTransform {

  transform(value: number[], lower: number, upper: number): number[] {
    return value.filter(item => item >= lower && item <= upper);
  }

}
