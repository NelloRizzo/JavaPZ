import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-hello',
  imports: [],
  templateUrl: './hello.component.html',
  styleUrl: './hello.component.css'
})
export class HelloComponent {
  @Input()
  username: string = 'Mondo';
  @Input()
  language?: string;

  @Output()
  notifyClick = new EventEmitter<string>();;

  buttonClicked(){
    //alert(`Hello ${this.username}`);
    this.notifyClick.emit(this.username);
  }
}
