import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'array'
})
export class ArrayPipe implements PipeTransform {

  transform(value: number[], ...args: unknown[]): number[] {
    return value.filter( item => item % 2 === 0 );
  }

}
