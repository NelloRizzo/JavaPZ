import { Component } from '@angular/core';
import { ProvinceListViewComponent } from './province-list-view/province-list-view.component';

@Component({
  selector: 'app-root',
  imports: [ProvinceListViewComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Esploriamo l\'Italia';
}
