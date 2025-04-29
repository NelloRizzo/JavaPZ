import { Pipe, PipeTransform } from '@angular/core';
import { Delivery } from '../models/contacts';

@Pipe({
  name: 'delivery'
})
export class DeliveryPipe implements PipeTransform {

  transform(value: Delivery): string {
    if (!value) return '';

    if ('phoneNumber' in value) {
      return `📞 ${value.phoneNumber}`;
    } else if ('emailAddress' in value) {
      return `📧 ${value.emailAddress}`;
    }

    return 'Unknown delivery type';
  }

}
