import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Contact } from '../../store/models';
import { Store } from '@ngrx/store';
import { addContact } from '../../store/state-actions';

const empty = {
  id: 0,
  addresses: [],
  firstName: '',
  lastName: '',
  nickName: undefined
}
@Component({
  selector: 'app-add-contact',
  imports: [FormsModule],
  templateUrl: './add-contact.component.html',
  styleUrl: './add-contact.component.css'
})
export class AddContactComponent {
  contact: Contact = { ...empty }
  constructor(private store: Store) { }
  add() {
    this.store.dispatch(addContact({ contact: this.contact }))
    this.contact = { ...empty }
  }
}
