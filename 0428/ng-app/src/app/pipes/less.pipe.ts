import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'less'
})
export class LessPipe implements PipeTransform {

  transform(value: number[], upperBound: number): number[] {
    return value.filter(item => item < upperBound);
  }

}
