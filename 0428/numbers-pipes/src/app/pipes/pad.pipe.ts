import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pad'
})
export class PadPipe implements PipeTransform {

  transform(value: string | number, sliceLen: number = 0, padWith: string = '0'): string {
    value = value.toString();
    if (sliceLen <= 0) return value;
    const slices = Math.ceil(value.length / sliceLen);
    const pad = padWith.repeat(sliceLen * slices);
    return pad.slice(0, -value.length) + value;
  }

}
