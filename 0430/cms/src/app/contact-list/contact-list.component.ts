import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Contact } from '../../store/models';
import { Store } from '@ngrx/store';
import { contactsSelector } from '../../store/contacts-selector';
import { AsyncPipe, NgFor } from '@angular/common';

@Component({
  selector: 'app-contact-list',
  imports: [NgFor, AsyncPipe],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.css'
})
export class ContactListComponent {
  contacts$: Observable<Contact[]>;

  constructor(private store: Store) {
    this.contacts$ = store.select(contactsSelector)
  }
}
