import { Component, ViewChild } from '@angular/core';
import { ToggleVisibilityDirective } from '../../directives/toggle-visibility.directive';
import { initialContacts } from '../../models/contact';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-main',
  imports: [ToggleVisibilityDirective, NgFor],
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss', '../../directives/toggle-visibility.scss'],
})
export class MainComponent {
  @ViewChild('editPanel') editPanel!: HTMLDivElement;

  contacts = initialContacts;
}
