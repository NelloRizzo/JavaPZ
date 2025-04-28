import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'hex'
})
export class HexPipe implements PipeTransform {

  transform(value: number): string {
    return value.toString(16);
  }



}
