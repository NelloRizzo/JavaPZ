import { Injectable } from '@angular/core';
import { Contact } from '../models/contacts';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  private static contacts: Contact[] = [
    {
      id: 1,
      lastName: 'Smith',
      firstName: 'John',
      deliveries: [
        { id: 1, phoneNumber: '123-456-7890' },
        { id: 1, emailAddress: 'john.smith@email.com' }]
    },
    {
      id: 2,
      lastName: 'Doe', firstName: 'Jane',
      deliveries: [{ id: 2, emailAddress: 'jane.doe@email.com' }]
    },
    {
      id: 3,
      lastName: 'Brown',
      firstName: 'Charlie',
      deliveries: [{ id: 3, phoneNumber: '987-654-3210' }]
    },
  ]

  constructor() { }

  getContacts() {
    return [...ContactService.contacts];
  }
  addContact(contact: Contact) {
    ContactService.contacts.push(contact);
  }
}
