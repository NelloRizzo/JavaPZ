import { Pipe, PipeTransform } from '@angular/core';
import { Contact } from '../models/contacts';

export type ContactNamePipeOptions =
  'fullName' | 'lastNameFirst' | 'firstNameInitial' | 'firstNameFirst' | 'firstName' | 'lastName';

@Pipe({
  name: 'contactName'
})
export class ContactNamePipe implements PipeTransform {

  transform(value: Contact, format: ContactNamePipeOptions): string {
    if (!value) return '';
    if (format === 'lastNameFirst') return `${value.lastName}, ${value.firstName}`;
    if (format === 'firstNameFirst') return `${value.firstName} ${value.lastName}`;
    if (format === 'firstName') return value.firstName;
    if (format === 'lastName') return value.lastName;
    if (format === 'firstNameInitial')
      return `${value.firstName[0]}. ${value.lastName}`;

    return `${value.firstName} ${value.lastName}`;
  }

}
