import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contact, emptyContact } from '../../models/contact';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-contact-form',
  imports: [FormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.scss'
})
export class ContactFormComponent {
  @Input() contact: Contact = emptyContact
  @Output() onContactAdded: EventEmitter<Contact> = new EventEmitter<Contact>();
  @Output() onContactModified: EventEmitter<Contact> = new EventEmitter<Contact>();

  get adding() { return !this.contact.id; }
  get buttonText() { return this.adding ? 'Aggiungi' : 'Modifica' }

  addContact() {
    if (this.adding) {
      this.onContactAdded.emit(this.contact);
    } else {
      this.onContactModified.emit(this.contact);
    }
    this.contact = emptyContact;
  }

  clearContact() {
    this.contact.email = '';
    this.contact.firstName = '';
    this.contact.id = undefined;
    this.contact.lastName = '';
    this.contact.phone = '';
    console.log(this.contact);
  }
}
