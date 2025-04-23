import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Contact } from '../../models/contact';

@Component({
  selector: 'app-show-contact',
  imports: [],
  templateUrl: './show-contact.component.html',
  styleUrl: './show-contact.component.scss'
})
export class ShowContactComponent {
  @Input() contact?: Contact
  showAddresses: boolean = false;

  @Output() onContactEditing: EventEmitter<Contact> = new EventEmitter<Contact>();
  @Output() onContactDeleting: EventEmitter<Contact> = new EventEmitter<Contact>();
  
  toggleVisibility(){
    this.showAddresses = !this.showAddresses;
  }

  editContact() {
    if (this.contact) {
      this.onContactEditing.emit(this.contact);
    }
  }
  deleteContact() {
    if (this.contact) {
      this.onContactDeleting.emit(this.contact);
    }
  }
}
