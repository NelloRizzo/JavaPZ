import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { UiSampleComponent } from './ui-sample/ui-sample.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, UiSampleComponent, HelloComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'app';
  username: string = "World";
  handleIncrement(currentValue: number) {
    console.log('Increment button clicked:', currentValue);
  }
}
