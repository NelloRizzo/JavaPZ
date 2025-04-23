import { Component, Input } from '@angular/core';
import { Contact } from '../../models/contact';

@Component({
  selector: 'app-show-contact',
  imports: [],
  templateUrl: './show-contact.component.html',
  styleUrl: './show-contact.component.scss'
})
export class ShowContactComponent {
  @Input() contact?: Contact
  showAddresses: boolean = true;

  toggleVisibility(){
    this.showAddresses = !this.showAddresses;
  }
}
