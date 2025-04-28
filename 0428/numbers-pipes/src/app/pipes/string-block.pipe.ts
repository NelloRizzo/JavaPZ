import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'stringBlock'
})
export class StringBlockPipe implements PipeTransform {

  transform(value: string, blockSize: number = 0, separator: string = ' '): string {
    return value.match(new RegExp(`.{1,${blockSize}}`, 'g'))?.join(separator) ?? value;
  }

}
