import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Contact, contactsList } from './models/contact';
import { ContactListComponent } from './components/contact-list/contact-list.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ContactListComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Contacts Management System';

  contacts: Contact[] = contactsList
}
