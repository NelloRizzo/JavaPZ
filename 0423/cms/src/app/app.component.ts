import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Contact, contactsList, emptyContact } from './models/contact';
import { ContactListComponent } from './components/contact-list/contact-list.component';
import { ContactFormComponent } from './components/contact-form/contact-form.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ContactListComponent, ContactFormComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Contacts Management System';

  contacts: Contact[] = contactsList
  editingContact: Contact = emptyContact

  addContact(contact: Contact) {
    const ids: number[] = [...this.contacts.map(c => c.id), contact.id].filter(id => id !== undefined) as number[];
    contact.id = Math.max(...ids) + 1;
    this.contacts.push(contact);
  }

  modifyContact(contact: Contact) {
    let c = this.contacts.find(c => c.id === contact.id);
    if (c) {
      this.contacts[this.contacts.indexOf(c)] = { ...c, ...contact };
    }
  }

  deleteContact(contact: Contact) {
    let c = this.contacts.find(c => c.id === contact.id);
    if (c) {
      const pos = this.contacts.indexOf(c);
      this.contacts = [...this.contacts.slice(0, pos), ...this.contacts.slice(pos + 1)];
    }
  }

  editContact(contact: Contact) {
    this.editingContact = { ...contact };
  }
}
