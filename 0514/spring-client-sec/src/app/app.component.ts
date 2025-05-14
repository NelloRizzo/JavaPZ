import { Component } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { HelloComponent } from "./hello/hello.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HelloComponent, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

}
