import { Component } from '@angular/core';
import { ContactService } from './services/contact.service';
import { Contact } from './models/contacts';
import { NgFor } from '@angular/common';
import { ContactNamePipe } from './pipes/contact-name.pipe';
import { DeliveryPipe } from './pipes/delivery.pipe';
import { PromiseViewComponent } from './promise-view/promise-view.component';
import { TypicodeComponent } from './typicode/typicode.component';

@Component({
  selector: 'app-root',
  imports: [NgFor, PromiseViewComponent,TypicodeComponent, ContactNamePipe, DeliveryPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Services & D.I. Sample';
  contacts: Contact[] = [];

  constructor(private contactService: ContactService) { }

  ngOnInit() {
    this.contactService.addContact({
      id: 4,
      firstName: 'Alice',
      lastName: 'Wonderland',
      deliveries: [
        { id: 4, phoneNumber: '555-123-4567' },
        { id: 4, emailAddress: 'alice@wonderland.org' }
      ]
    })
    this.contacts = this.contactService.getContacts()
  }
}
