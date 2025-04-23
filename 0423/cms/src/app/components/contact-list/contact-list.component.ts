import { Component, Input } from '@angular/core';
import { Contact } from '../../models/contact';
import { NgFor, NgIf } from '@angular/common';
import { ShowContactComponent } from '../show-contact/show-contact.component';

@Component({
  selector: 'app-contact-list',
  imports: [NgIf, NgFor, ShowContactComponent],
  templateUrl: './contact-list.component.html',
  styleUrl: './contact-list.component.scss'
})
export class ContactListComponent {
  @Input() contacts: Contact[] = [];
}
