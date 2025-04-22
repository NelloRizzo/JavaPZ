import { Component } from '@angular/core';

@Component({
  selector: 'app-time',
  imports: [],
  templateUrl: './time.component.html',
  styleUrl: './time.component.css'
})
export class TimeComponent {
  currentTime: string = new Date().toLocaleTimeString();

  constructor() {
    setInterval(() => {
      this.currentTime = new Date().toLocaleTimeString();
    }, 1000);
  }
}
