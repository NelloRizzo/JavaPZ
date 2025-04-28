import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'bin'
})
export class BinPipe implements PipeTransform {

  transform(value: number): string {
    return value.toString(2);
  }

}
