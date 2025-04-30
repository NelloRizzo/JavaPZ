import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CounterViewerComponent } from './counter-viewer/counter-viewer.component';
import { CounterControlsComponent } from './counter-controls/counter-controls.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CounterViewerComponent, CounterControlsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ng-store';
}
