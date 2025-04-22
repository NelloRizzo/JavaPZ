import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HelloComponent } from './hello/hello.component';
import { TimeComponent } from './time/time.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HelloComponent, TimeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'sample-ng-app';
  name = 'Paperino';

  constructor() {
    setTimeout(() => {
      this.name = 'Pluto';
    }, 2000);
  }
  handleClick(ev: string) {
    alert(`Click su ${ev}`);
  }
}
