import { Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-component-ref',
  imports: [],
  templateUrl: './component-ref.component.html',
  styleUrl: './component-ref.component.css'
})
export class ComponentRefComponent {
  @ViewChild('myText') myText?: ElementRef;

  ngAfterViewInit() {
    console.log(this.myText); // undefined
    if (this.myText) {
      console.log(this.myText.nativeElement); // <div>...</div>
      this.myText.nativeElement.style.color = 'red'; // Change text color to red
      this.myText.nativeElement.innerText = 'Welcome'; // Change text color to red
    }
  }
}
