import { Pipe, PipeTransform } from '@angular/core';
import { City } from '../services/models';

@Pipe({
  name: 'formatCity'
})
export class FormatCityPipe implements PipeTransform {

  transform(value: City): string {
    return `${value.name} (${value.province.acronym})`;
  }

}
